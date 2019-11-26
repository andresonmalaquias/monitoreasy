/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.coordenador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.bean.AlunoBean;
import model.bean.DisciplinaBean;
import model.bean.MonitoraBean;
import model.dao.AlunoDao;
import model.dao.DisciplinaDao;
import model.dao.MonitoraDao;
import mvc.coordenador.ConsultarMonitoresMVC;
import view.coordenador.ConsultarMonitoresView;
import view.coordenador.TornarAlunoMonitorView;

/**
 *
 * @author Thiago Sena
 */
public class TornarAlunoMonitorController {
    private TornarAlunoMonitorView tela;
    Vector<AlunoBean> listaAluno;
    Vector<DisciplinaBean> listaDisciplina;
    Calendar calendar = Calendar.getInstance();
    int ano = calendar.get(Calendar.YEAR);
    
    public TornarAlunoMonitorController(TornarAlunoMonitorView tela) {
        this.tela = tela;
        carregarTabela();
        carregarComboBox();
        this.tela.setTxtAnoText(""+ano);
        
        
        if((calendar.get(Calendar.MONTH)+1) > 6){
            this.tela.setCmbPeriodoIndex(2);
        }
        else{
            this.tela.setCmbPeriodoIndex(1);
        }
        this.tela.addBtnListaListener(new abrirLista());
        this.tela.addBtnCadastrarListener(new cadastrarAluno());
        this.tela.addBtnBuscarListener(new buscarAluno());
        this.tela.setVisible(true);
    }
    
    public void carregarTabela(){
        //String valorBuscado = tela.getTxtPesquisar();
        
        try {
            AlunoDao dao = new AlunoDao();
            listaAluno = dao.consultar(tela.getBusca());
            if(listaAluno.size() < 1){
                tela.showMsg("Monitor não encontrado!");
            }
            else{
                //tela.setTblPosition(0,0);
                
                Vector conjuntoLinhas = new Vector();

                for(AlunoBean aluno: listaAluno){
                    Vector linha = new Vector();

                    linha.add(aluno.getMatricula());
                    linha.add(aluno.getNome());
                    linha.add(aluno.getPeriodo());

                    conjuntoLinhas.add(linha);
                }
                Vector conjuntoColunas = new Vector();
                conjuntoColunas.add("Matricula"); 
                conjuntoColunas.add("Nome");
                conjuntoColunas.add("Periodo");

                DefaultTableModel modeloTabela = 
                        new DefaultTableModel(conjuntoLinhas, conjuntoColunas);
                tela.setTblDados(modeloTabela);
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar tabela: " + ex.getMessage());
        }
    }
    
    public void carregarComboBox(){
        //String valorBuscado = tela.getTxtPesquisar();
        
        try {
            DisciplinaDao dao = new DisciplinaDao();
            listaDisciplina = dao.consultar();
            if(listaDisciplina.isEmpty()){
                
            }
            else{
                //tela.setTblPosition(0,0);
                
                //Vector conjuntoLinhas = new Vector();

                for(DisciplinaBean disciplina: listaDisciplina){
                    tela.addItemComboBox(disciplina.getNome());
                    //conjuntoLinhas.add(linha);
                }
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar combobox: " + ex.getMessage());
        }
    }
    
    class cadastrarAluno implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(tela.tableIsSelected() == true && !tela.getTxtAno().equals("") && tela.getCmbPeriodoIndex()!=0){
                int index = tela.getTblDados();
                AlunoBean aluno = listaAluno.get(index);

                index = tela.getComboBoxDados();
                DisciplinaBean disc = listaDisciplina.get(index);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                index = tela.getCmbPeriodoIndex();
                
                String periodo = ano + tela.getItemCmbPeriodo(index);

                MonitoraBean monit = new MonitoraBean(disc.getCodigo(), aluno.getMatricula(), dateFormat.format(date), periodo);
                MonitoraDao dao;
                try {
                    dao = new MonitoraDao();
                    int ok = dao.cadastrar(monit);
                    switch(ok){
                        case 1:
                            tela.showMsg("Aluno já é monitor!");
                        break;
                        case 2:
                            tela.showMsg("Cadastro do monitor realizado com sucesso!");
                        break;
                        case 0:
                            tela.showMsg("Aluno já foi monitor 2 vezes!");
                        break;
                        case -1:
                            tela.showMsg("Algum problema ocorreu!");
                        break;   
                    }
                } catch (Exception ex) {
                    tela.showMsg("Não foi possível cadastrar o monitor: " + ex.getMessage());
                }
            }else{
                tela.showMsg("Preencha e/ou selecine todas os campos necessários!");
            }    
        } 
    }
    class buscarAluno implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carregarTabela();
            
        }
        
    }
    
    class abrirLista implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new ConsultarMonitoresController(new ConsultarMonitoresView());
        }
        
    }
}
