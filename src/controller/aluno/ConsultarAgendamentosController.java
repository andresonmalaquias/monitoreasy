package controller.aluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.bean.AlunoBean;
import model.bean.MonitoraBean;
import model.bean.ParticipaBean;
import model.dao.ParticipaDao;
import view.aluno.ConsultarAgendamentosView;

public class ConsultarAgendamentosController{
    private ConsultarAgendamentosView tela;
    Vector<ParticipaBean> listaAtendimentos;
    
    public ConsultarAgendamentosController(ConsultarAgendamentosView tela) {
        this.tela = tela;
        this.tela.setEditTableNull();
        this.tela.addBtnBuscarListener(new buscar());
        this.tela.addTableListener(new excluir());
        //this.tela.addTxtSairListener(new sair());
        carregarTabela();
        this.tela.setVisible(true);

    }
    
    public String organizaData(String datahora){
        String hora = datahora.substring(11, 16);
        String dia = datahora.substring(8, 10);
        String mes = datahora.substring(5, 7);
        String ano = datahora.substring(0, 4);
        
        return dia+"/"+mes+"/"+ano+" às "+hora;
    }
    
    public void carregarTabela(){
        String valorBuscado = tela.getBusca();
        
        try {
            ParticipaDao dao = new ParticipaDao();
            listaAtendimentos = dao.consultarAtendimentos(AlunoBean.mat, valorBuscado);
            if(listaAtendimentos.size() < 1){
                //tela.showMsg("Atendimento não encontrado!");
            }
            else{
                Vector conjuntoLinhas = new Vector();

                for(ParticipaBean part: listaAtendimentos){
                    Vector linha = new Vector();

                    linha.add(part.getNomeMonitor());
                    linha.add(part.getDisciplina());
                    String datahora = organizaData(part.getDataHora());
                    linha.add(datahora);

                    conjuntoLinhas.add(linha);
                }
                Vector conjuntoColunas = new Vector();
                conjuntoColunas.add("Monitor"); 
                conjuntoColunas.add("Disciplina");
                conjuntoColunas.add("Data");

                DefaultTableModel modeloTabela = 
                        new DefaultTableModel(conjuntoLinhas, conjuntoColunas);
                tela.setTblDados(modeloTabela);
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar tabela: " + ex.getMessage());
        }
    }
    
    class buscar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carregarTabela();
            
        }
        
    }
    class sair implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            //tela.closeView();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //tela.closeView();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //tela.closeView();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //tela.closeView();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //tela.closeView();
        }

       
    }
    class excluir implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int index = tela.getTblRow();
                ParticipaBean part = listaAtendimentos.get(index);
                String datahora = organizaData(part.getDataHora());
                if(tela.showMsgConfirmation("Você tem certeza que deseja se cancelar o atendimento da disciplina de " + part.getDisciplina() + " no dia " + datahora + "?")){
                    try {
                        ParticipaDao dao = new ParticipaDao();
                        int result = dao.cancelarAtendimento(part);
                        
                        switch (result){
                            case 0:
                                tela.showMsg("Presença no atendimento cancelada!");
                                carregarTabela();
                                break;
                            case 1:
                                tela.showMsg("Erro! Tempo para cancelar a presença passou do limite máximo!");
                                break;
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(ConsultarAgendamentosController.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }else{
                    tela.showMsg("Operação Cancelada!");
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
           
        }
        
    }
        
}

