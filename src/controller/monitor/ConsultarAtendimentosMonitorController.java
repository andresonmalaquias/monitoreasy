package controller.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.bean.MonitoraBean;
import model.dao.MonitoraDao;
import model.dao.ReservaDao;
import view.monitor.ConsultarAtendimentosMonitorView;

public class ConsultarAtendimentosMonitorController{
    private ConsultarAtendimentosMonitorView tela;
    Vector<MonitoraBean> listaReservas;
    
    public ConsultarAtendimentosMonitorController(ConsultarAtendimentosMonitorView tela) {
        this.tela = tela;
        this.tela.setEditTableNull();
        this.tela.addBtnBuscarListener(new BtnBuscarActionListener());
        this.tela.addTableListener(new TblMouseListener());
        //this.tela.addTxtSairListener(new sair());
        retornaHoras();
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
    public void retornaHoras(){
        MonitoraDao monitoraDao;
        try {
            monitoraDao = new MonitoraDao();
            int caso = 0;
            //int hora = monitoraDao.retornaHorasMonitor(MonitoraBean.mat);
            int hora = 6;
            if(hora>=6){
                caso = 1;
            }else{
                caso = 2;
            }
            tela.setTxtHorasText(hora, caso);
        } catch (Exception ex) {
            Logger.getLogger(ReservarDataHoraLocalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private String manipulaDataHora(){
        Date data = new Date();
        int day[] = {1, 0, -1, -2, -3, -4, -5};
        data.setDate(data.getDate() + day[data.getDay()]);
        data.setDate(data.getDate() + 7);
        Calendar calendar = Calendar.getInstance(); 
        
        String dia = ""+ data.getDate();
        String mes = "" + (calendar.get(Calendar.MONTH)+2);
        String ano = ""+calendar.get(Calendar.YEAR);
        if(Integer.parseInt(dia)<=9){
            dia = "0" + dia;
        }
        if(Integer.parseInt(mes)<=9){
            mes = "0" + mes;
        }
        return ano +"-"+ mes +"-"+ dia + " 00:00:00";
    }
    
    public void carregarTabela(){
        String valorBuscado = tela.getBusca();      
        try {
            MonitoraDao dao = new MonitoraDao();
            listaReservas = dao.consultaReservas(MonitoraBean.mat, valorBuscado, manipulaDataHora());
            if(listaReservas.size() < 1){
                //tela.showMsg("Monitor sem reservas!");
            }
            else{                
                Vector conjuntoLinhas = new Vector();

                for(MonitoraBean monit: listaReservas){
                    Vector linha = new Vector();
                    
                    linha.add(monit.getLocal());
                    String datahora = organizaData(monit.getData());
                    linha.add(datahora);

                    conjuntoLinhas.add(linha);
                }
                Vector conjuntoColunas = new Vector();
                conjuntoColunas.add("Local"); 
                conjuntoColunas.add("Data");

                DefaultTableModel modeloTabela = 
                        new DefaultTableModel(conjuntoLinhas, conjuntoColunas);
                tela.setTblDados(modeloTabela);
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar tabela: " + ex.getMessage());
        }
    }
    
    private class BtnBuscarActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carregarTabela();          
        }    
    }
    private class TblMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int index = tela.getTblRow();
                MonitoraBean monitor = listaReservas.get(index);
                String datahora = organizaData(monitor.getData());
                if(tela.showMsgConfirmation("Você tem certeza que deseja cancelar seu atendimento do dia " + datahora + "?")){
                    try {
                        ReservaDao dao = new ReservaDao();
                        int result = dao.cancelarReserva(monitor);
                        switch(result){
                            case 0:
                                tela.showMsg("Atendimento cancelado!");
                                carregarTabela();
                                retornaHoras();
                                break;
                            case 1:
                                tela.showMsg("Este atendimento não pode ser cancelado, pois já tem alunos inscritos!");
                                break;
                        }
                        
                    } catch (Exception ex) {
                        Logger.getLogger(ConsultarAtendimentosMonitorController.class.getName()).log(Level.SEVERE, null, ex);
                    }                             
                }else{
                    tela.showMsg("Operação Cancelada!");
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}
        
        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
        
    }
    class sair implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

       
    }
        
}

