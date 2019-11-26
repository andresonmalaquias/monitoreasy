package controller.coordenador;

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
import model.bean.DataBean;
import model.dao.DataDao;
import view.coordenador.ConsultarDatasHorariosLocaisDisponibilizadosView;

public class ConsultarDatasHorariosLocaisDisponibilizadosController{
    private ConsultarDatasHorariosLocaisDisponibilizadosView tela;
    Vector<DataBean> listaHorarios;
    
    public ConsultarDatasHorariosLocaisDisponibilizadosController(ConsultarDatasHorariosLocaisDisponibilizadosView tela) {
        this.tela = tela;
        this.tela.setEditTableNull();
        this.tela.addBtnBuscarListener(new BtnBuscarActionListener());
        this.tela.addTableListener(new TblMouseListener());
        carregarTabela();
        //this.tela.addTxtSairListener(new sair());
        this.tela.setVisible(true);

    }
    
    public String organizaData(String datahora){
        String hora = datahora.substring(11, 16);
        String dia = datahora.substring(8, 10);
        String mes = datahora.substring(5, 7);
        String ano = datahora.substring(0, 4);
        
        return dia+"/"+mes+"/"+ano+" às "+hora;
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
            DataDao dao = new DataDao();
            System.out.println(manipulaDataHora());
            
            listaHorarios = dao.consultarHorariosDisponibilizados(valorBuscado, manipulaDataHora());
            if(listaHorarios.size() < 1){
                //tela.showMsg("Horário não encontrado!");
            }
            else{
                
                Vector conjuntoLinhas = new Vector();

                for(DataBean data: listaHorarios){
                    Vector linha = new Vector();

                    linha.add(data.getLoccodigo());
                    String datahora = organizaData(data.getData() + " " + data.getHora());
                    linha.add(datahora.substring(0, 10));
                    linha.add(datahora.substring(14, 19));

                    conjuntoLinhas.add(linha);
                }
                Vector conjuntoColunas = new Vector();
                conjuntoColunas.add("Local"); 
                conjuntoColunas.add("Dia");
                conjuntoColunas.add("Horário");

                DefaultTableModel modeloTabela = 
                        new DefaultTableModel(conjuntoLinhas, conjuntoColunas);
                tela.setTblDados(modeloTabela);
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar tabela: " + ex.getMessage());
        }
    }
    
    class BtnBuscarActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(tela.getBusca());
            carregarTabela();
            
        }
        
    }
    class TblMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int index = tela.getTblRow();
                DataBean data = listaHorarios.get(index);
                String datahora = organizaData(data.getData() + " " + data.getHora());
                if(tela.showMsgConfirmation("Você tem certeza que deseja remover a data " + datahora + " no " + data.getLoccodigo() + "?")){                    
                    try {
                        DataDao dao =  new DataDao();
                        int result = dao.removeDataHoraDisponibilizada(data);
                        switch(result){
                            case 0: 
                                tela.showMsg("Exclusão realizada!");
                                carregarTabela();
                                break;
                            case 1:
                                tela.showMsg("Erro! Algum monitor já selecionou esse horário, data e local para atendimento!");
                                break;
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(ConsultarDatasHorariosLocaisDisponibilizadosController.class.getName()).log(Level.SEVERE, null, ex);
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

