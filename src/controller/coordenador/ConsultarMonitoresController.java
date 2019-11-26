package controller.coordenador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.bean.MonitoraBean;
import model.dao.MonitoraDao;
import view.coordenador.ConsultarMonitoresView;

public class ConsultarMonitoresController{
    private ConsultarMonitoresView tela;
    Vector<MonitoraBean> listaMonitores;
    
    public ConsultarMonitoresController(ConsultarMonitoresView tela) {
        this.tela = tela;
        carregarTabela();
        this.tela.setEditTableNull();
        this.tela.addBtnBuscarListener(new buscarMonitor());
        this.tela.addTableListener(new excluir());
        //this.tela.addTxtSairListener(new sair());
        this.tela.setVisible(true);

    }
    
    public void carregarTabela(){
        //String valorBuscado = tela.getTxtPesquisar();
        
        try {
            MonitoraDao dao = new MonitoraDao();
            listaMonitores = dao.ConsultaMonitores(tela.getBusca());
            if(listaMonitores.size() < 1){
                tela.showMsg("Monitor não encontrado!");
            }
            else{
                //tela.setTblPosition(0,0);
                
                Vector conjuntoLinhas = new Vector();

                for(MonitoraBean monit: listaMonitores){
                    Vector linha = new Vector();

                    linha.add(monit.getNomeAluno());
                    linha.add(monit.getDiscodigo());
                    linha.add(monit.getCicloLetivo());
                    linha.add(monit.getAlumatricula());

                    conjuntoLinhas.add(linha);
                }
                Vector conjuntoColunas = new Vector();
                conjuntoColunas.add("Nome"); 
                conjuntoColunas.add("Disciplina");
                conjuntoColunas.add("Periodo Letivo");
                conjuntoColunas.add("Matrícula");

                DefaultTableModel modeloTabela = 
                        new DefaultTableModel(conjuntoLinhas, conjuntoColunas);
                tela.setTblDados(modeloTabela);
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar tabela: " + ex.getMessage());
        }
    }
    
    class buscarMonitor implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carregarTabela();
            
        }
        
    }
    class excluir implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int index = tela.getTblRow();
                MonitoraBean monitor = listaMonitores.get(index);
                if(tela.showMsgConfirmation("Você tem certeza que deseja encerrar a monitoria de " + monitor.getNomeAluno() + "?")){
                    try {
                        MonitoraDao dao = new MonitoraDao();
                        boolean ok = dao.encerrarMonitoria(monitor);
                        if(ok){
                            tela.showMsg("Monitoria encerrada!");
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(ConsultarMonitoresController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    carregarTabela();
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
    
    /*class sair implements MouseListener{

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

       
    }*/
        
}

