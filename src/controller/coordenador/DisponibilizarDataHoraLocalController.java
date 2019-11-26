package controller.coordenador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import model.bean.DataBean;
import model.bean.LocalBean;
import model.dao.DataDao;
import model.dao.LocalDao;
import view.coordenador.ConsultarDatasHorariosLocaisDisponibilizadosView;
import view.coordenador.DisponibilizarDataHoraLocalView;

public class DisponibilizarDataHoraLocalController {
    private DisponibilizarDataHoraLocalView tela;
    Vector<LocalBean> listaLocais;
    Vector<String> horas;
    Vector<String> horasUpdate = new Vector();
    DefaultListModel listModel = new DefaultListModel();
    DataBean dataBean = new DataBean();

    public DisponibilizarDataHoraLocalController(DisponibilizarDataHoraLocalView tela) {
        this.tela = tela;
        // OBS ESSA FUNCINALIDADE É MERAMENTE DESCARTAVÉL, ATÉ SER IMPLEMENADO 
        // O MÓDULO DE COORDENADOR CADASTRAR LOCAIS E HORAS
        carregaHoras();
        this.tela.addCmbLocalListener(new AddCmbLocalListener());
        this.tela.addDpDataListener(new AddDpDataListener());
        this.tela.addCmbHorarioListener(new AddCbmHorarioListener());
        this.tela.addBtnLimparListener(new AddBtnLimparListener());
        this.tela.addBtnConfirmarListener(new AddBtnConfirmarListener());
        this.tela.addBtnHorarioListener(new AddBtnHorarioListener());
        this.tela.setDisabledEditorDpData();
        carregarComboBoxLocais();
        this.tela.setVisible(true);
    }
    //FUNCIONALIDADE TEMPORÁRIA
    public void carregaHoras(){
        horas = new Vector();
        for(int i = 13; i <= 19 ; i++){
            int h = i + 1;
            horas.add("" +i + ":00" + " às " + h + ":00");
        }
    }
    
    
    public void carregarComboBoxLocais(){        
        tela.clearComboBoxLocal();
        try {
            LocalDao dao = new LocalDao();
            listaLocais = dao.consultarLocais();
            if(listaLocais.isEmpty()){
                tela.addItemComboBoxLocal("--Vazio--");
                tela.addItemComboBoxHorario("--Vazio--");
                
            }
            else{
                tela.addItemComboBoxLocal("--Locais--");
                for(LocalBean local: listaLocais){
                    tela.addItemComboBoxLocal(""+local.getLocal());
                }
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar combobox locais: " + ex.getMessage());
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
        System.out.println(mes);
        String ano = ""+calendar.get(Calendar.YEAR);
        if(Integer.parseInt(dia)<=9){
            dia = "0" + dia;
        }
        if(Integer.parseInt(mes)<=9){
            mes = "0" + mes;
        }
        return ano +"-"+ mes +"-"+ dia + " 00:00:00";
    }
    
    private void carregarDpData(LocalBean local){ 
        Date data = new Date();
        int day[] = {1, 0, -1, -2, -3, -4, -5};
        data.setDate(data.getDate() + day[data.getDay()]);
        data.setDate(data.getDate() + 7);
        this.tela.setDpDataLowerBound(data);      
        data.setDate(data.getDate() + 4);
        this.tela.setDpDataUpperBound(data);    
        this.tela.setDpDataColor(Color.blue);
        this.tela.setDpDataFormats("dd/MM/yyyy");
        try {
            DataDao dao = new DataDao();
            Vector<DataBean> datas = dao.consultarDatasFuturas(local.getLocal(), manipulaDataHora());
            Date vetDatas[] = new Date[datas.size()];
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");            
            int i = 0;
            
            for (DataBean dt : datas) {
                vetDatas[i] = formato.parse(dt.getData());
                i++;
            }
            
            this.tela.setdpDataFlaggedDates(vetDatas);
            tela.setEnabledCmbHora(false);
            tela.addItemComboBoxHorario("--Horário--");
            carregaHoras();
            listModel.clear();
            tela.addListHorarioModel(listModel);
            carregarComboBoxHorarios();
        } catch (Exception ex) {
            Logger.getLogger(DisponibilizarDataHoraLocalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void carregarComboBoxHorarios(){
        this.tela.clearComboBoxHorario();
        tela.addItemComboBoxHorario("--Horário--");
        try {
            DataDao dao = new DataDao();
            dataBean.clear();
            dataBean = dao.consultarHoras(dataBean);
            
            if(dataBean.getHoras().isEmpty()){
                for (String hr : horas) {
                       this.tela.addItemComboBoxHorario(hr);        
                }
            }else{
                for (int i = 0; i < dataBean.getHoras().size(); i++) {
                    String hr = dataBean.getHoras().get(i);
                     
                    for (int j = 0; j < horas.size(); j++) {                        
                        String hora = horas.get(j);      
                        if(hr.equals(hora.substring(0, 5))){
                            horas.removeElementAt(j);
                            int horario = Integer.parseInt(hr.substring(0,2));
                            horario++;
                            listModel.addElement(hr + " às " + horario + ":00");
                        }
                    }
                } 
                for (String hora : horas) {
                    this.tela.addItemComboBoxHorario(hora);
                }    
            }
            
                    
            
        } catch (Exception e) {
        }
        
    }
    
    private String getData(){
        Calendar calendar = tela.getDpData();
        Date date = tela.getDpDataDate();
        String dia = ""+ date.getDate();
        String mes = "" + (calendar.get(Calendar.MONTH)+1);
        String ano = ""+calendar.get(Calendar.YEAR);
        if(Integer.parseInt(dia)<=9){
            dia = "0" + dia;
        }
        if(Integer.parseInt(mes)<=9){
            mes = "0" + mes;
        }

        return ano + "-" + mes + "-" + dia;
    }
    
    
       private class AddCmbLocalListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                int num = tela.returnIndexCmbLocal();
                tela.clearDpData();
                listModel.clear();
                tela.addListHorarioModel(listModel);
                dataBean.setData(null);
                if(num == 0){
                    tela.setEnabledCmbHora(false);
                    tela.setEnabledDpData(false);
                    tela.setEnabledBtnLimpar(false);
                    tela.clearDpData();
                    tela.addItemComboBoxHorario("--Horário--");
                                
                }else{
                    LocalBean local = listaLocais.get(num-1);
                    dataBean.setLoccodigo(local.getLocal());
                    carregarDpData(local);
                    tela.setEnabledBtnLimpar(true);
                    tela.setEnabledDpData(true);
                }   
        } 
    }
       
    private class AddDpDataListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            listModel.clear();
            tela.addListHorarioModel(listModel);
            tela.clearComboBoxHorario();
            carregaHoras();
            
            if(tela.dataIsEmpty()){
                tela.setEnabledCmbHora(false);
                tela.showMsg("Data selecionada é inválida!");
            }else{
                dataBean.setData(getData());
                carregarComboBoxHorarios();
                tela.setEnabledCmbHora(true);
            }
        }
        
    }
    
    private class AddCbmHorarioListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            int num = tela.returnIndexCmbHora();
                if(num == 0){
                    //tela.addItemComboBoxHorario("--Vazio--");
                }else if(num<0){
                
                }else{
                    listModel.addElement(horas.get(num - 1));
                    tela.addListHorarioModel(listModel);
                    horasUpdate.add(horas.get(num - 1));
                    horas.removeElementAt(num - 1);
                    carregarComboBoxHorarios();
                } 
        }
        
    }
    
    private class AddBtnLimparListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            carregaHoras();
            listModel.clear();
            tela.addListHorarioModel(listModel);
            carregarComboBoxHorarios();
        }
            
    }
    
    private class AddBtnConfirmarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!tela.dataIsEmpty() && !listModel.isEmpty()
                                                && tela.returnIndexCmbLocal()!= 0){
                
                
                int index = tela.returnIndexCmbLocal();
                
                dataBean = new DataBean();
                dataBean.setLoccodigo(listaLocais.get(index-1).getLocal());
                dataBean.setData(getData());
                
                // recupera as datas da view e adiciona adiciona as datas ao objeto
                for(String hora : tela.returnListHorario()){
                    dataBean.setHoras(hora.substring(0, 5)+":00");
                }

                try {
                    DataDao dao = new DataDao();
                    boolean ok = dao.disponibilizarHorario(dataBean);
                    if(ok){
                        dao = new DataDao();        
                        ok = dao.cadastrarHoras(dataBean);
                        if(ok){
                            tela.showMsg("Disponibilização de horário, data e local de atendimento realizada com sucesso!");
                            listModel.clear();
                            tela.addListHorarioModel(listModel);
                            tela.clearComboBoxHorario();
                            tela.setEnabledBtnLimpar(false);
                            tela.setEnabledCmbHora(false);
                            tela.setSelectedRowCmbLocal(0);
                        }else{
                            tela.showMsg("Erro!");
                        }
                            
                    }else{
                        tela.showMsg("Erro ao disponibilizar horários!");
                    }     
                } catch (Exception ex) {
                    Logger.getLogger(DisponibilizarDataHoraLocalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                tela.showMsg("Preencha todos os campos!");
            }
        }
        
    }
    
    private class AddBtnCancelarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            tela.showMsg("Cancelando seja lá o que esse botão vá cancelar");
        }
        
    }
    
    private class AddBtnHorarioListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new ConsultarDatasHorariosLocaisDisponibilizadosController(new ConsultarDatasHorariosLocaisDisponibilizadosView());
        }
        
    }
       
}
