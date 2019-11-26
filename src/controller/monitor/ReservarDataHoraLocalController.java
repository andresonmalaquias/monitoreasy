package controller.monitor;

import controller.coordenador.ConsultarMonitoresController;
import controller.coordenador.DisponibilizarDataHoraLocalController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import model.bean.DataBean;
import model.bean.LocalBean;
import model.bean.MonitoraBean;
import model.bean.ReservaBean;
import model.dao.DataDao;
import model.dao.LocalDao;
import model.dao.MonitoraDao;
import model.dao.ReservaDao;
import view.coordenador.ConsultarMonitoresView;
import view.monitor.ReservarDataHoraLocalView;
import view.coordenador.DisponibilizarDataHoraLocalView;
import view.monitor.ConsultarAtendimentosMonitorView;

public class ReservarDataHoraLocalController {
    private ReservarDataHoraLocalView tela;
    Vector<LocalBean> listaLocais;
    Vector<String> horas;
    Vector<String> horasUpdate = new Vector();
    DefaultListModel listModel = new DefaultListModel();
    int inicio = 0;
    int hora;
    DataBean dataBean = new DataBean();
    
    public ReservarDataHoraLocalController(ReservarDataHoraLocalView tela) {
        this.tela = tela;
        this.tela.addDpDataListener(new AddDpDataListener());
        retornaHoras();
        updateHoras();
        this.tela.addCmbLocalListener(new AddCmbLocalListener()); 
        this.tela.addBtnConfirmarListener(new AddBtnConfirmarListener());
        this.tela.addBtnLimparListener(new AddBtnLimparListener());
        this.tela.addBtnAtendimentosListener(new goAtendimentos());
        this.tela.addCmbHorarioListener(new AddCbmHorarioListener());
        this.tela.setDisabledEditorDpData();
        carregarComboBoxLocais();
        this.tela.setVisible(true);
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
    
    public void carregarComboBoxLocais(){        
        tela.clearComboBoxLocal();
        try {
            LocalDao dao = new LocalDao();
            listaLocais = dao.consultaLocaisDisponiveis(manipulaDataHora());
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
    public void retornaHoras(){
        MonitoraDao monitoraDao;
        try {
            monitoraDao = new MonitoraDao();
            int caso = 0;
            hora = monitoraDao.retornaHorasMonitor(MonitoraBean.mat, manipulaDataHora());
            //hora = 9;
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
        
    
    private void carregarDpData(LocalBean local){ 
        Date data = new Date();
        int day[] = {1, 0, -1, -2, -3, -4, -5};
        data.setDate(data.getDate() + day[data.getDay()]);
        data.setDate(data.getDate() + 7);
        this.tela.setDpDataLowerBound(data);      
        data.setDate(data.getDate() + 4);
        this.tela.setDpDataUpperBound(data);    
        this.tela.setDpDataColor(Color.green);
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
            
            
            /*listModel.clear();
            carregarComboBoxHorarios();
            inicio = 0;*/
        } catch (Exception ex) {
            Logger.getLogger(DisponibilizarDataHoraLocalController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void updateHoras(){
        DataDao dao;
        try {
            dao = new DataDao();
            dataBean = dao.consultarHorasDisponiveis(dataBean);
        } catch (Exception ex) {
            Logger.getLogger(ReservarDataHoraLocalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void carregarComboBoxHorarios(){
        tela.clearComboBoxHorario();
        tela.addItemComboBoxHorario("--Horário--");
        try {
            DataDao dao = new DataDao();
                if(inicio==0){
                    dataBean = dao.consultarHorasDisponiveis(dataBean);
                    inicio = 1;
                }
                for (String hr : dataBean.getHoras()) {
                    int hora = Integer.parseInt(hr.substring(0,2));
                    hora++;
                    this.tela.addItemComboBoxHorario("" +hr.substring(0,2) + ":00" + " às " + hora + ":00");  
                }
        } catch (Exception e) {

        }
    }    
    
    private class AddCmbLocalListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                int num = tela.returnIndexCmbLocal();
                tela.clearDpData();
                listModel.clear();
                dataBean.setData(null);
                if(num == 0){
                    tela.setEnabledCmbHora(false);
                    tela.setEnabledDpData(false);
                    tela.clearDpData();
                    tela.addItemComboBoxHorario("--Horário--");
                                
                }else{
                    LocalBean local = listaLocais.get(num-1);
                    dataBean.setLoccodigo(local.getLocal());
                    carregarDpData(local);
                    tela.setEnabledDpData(true);
                }   
        } 
    }
  
    private class AddDpDataListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            tela.clearComboBoxHorario();
            listModel.clear();
            dataBean.clear();
            horasUpdate.clear();
            if(tela.dataIsEmpty()){
                tela.setEnabledCmbHora(false);
                tela.showMsg("Data selecionada é inválida!");
            }else{
                dataBean.setData(getData());
                inicio = 0;
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
                    //System.out.println(horasUpdate.size()+hora);
                    if(horasUpdate.size()+1+hora>12){
                        tela.showMsg("Você ultrapassou seu número de horas obrigatórias!");
                        return;
                    }
                    horasUpdate.add(dataBean.getHoras().get(num - 1));
                    int horario = Integer.parseInt(dataBean.getHoras().get(num - 1).substring(0,2));
                    
                    horario++;
                    listModel.addElement("" + dataBean.getHoras().get(num - 1)  + " às " + horario + ":00");
                    tela.addListHorarioModel(listModel);
                    dataBean.getHoras().remove(num - 1);
                    carregarComboBoxHorarios();
                } 
        }
        
    }
    private class AddBtnLimparListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            inicio = 0;
            dataBean.clear();
            carregarComboBoxHorarios();
            listModel.clear();
            horasUpdate.clear();
        }
            
    }
    
    private class AddBtnConfirmarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!tela.dataIsEmpty() && !listModel.isEmpty()
                                                && tela.returnIndexCmbLocal()!= 0){  
                try {                    
                    
                    ReservaDao dao;
                    ReservaBean reserva = new ReservaBean();
                    int index = tela.returnIndexCmbLocal();
                    reserva.setLocCodigo(listaLocais.get(index-1).getLocal());

                    // recupera as datas da view e adiciona adiciona as datas ao objeto
                    index = tela.returnIndexCmbHora()-1;

                    reserva.setMonMatricula(MonitoraBean.mat);
                    String dataSemPost;
                    int result = 0; //resultado retornado do banco
                    for(String hr : horasUpdate){
                        dao = new ReservaDao();
                        reserva.setDataHora(hr+":00");
                        reserva.setDataHora(getData() + " " + reserva.getDataHora());
                        dataSemPost = manipulaDataHora();
                        result = dao.reservarHorarioMonitoria(reserva, dataSemPost);
                    }
                    
                    switch(result){
                        case 1: tela.showMsg("Você já atingiu sua carga horária semanal!");
                            break;
                        case 2:
                                tela.showMsg("Você já possui reserva nesse horário e data");
                            break;
                        case 3:
                                tela.showMsg("Local já reservado neste horário!");
                            break;
                        case 0:
                                tela.showMsg("Atendimento agendado com sucesso!");
                                tela.clearComboBoxHorario();
                                tela.setEnabledCmbHora(false);
                                tela.setSelectedRowCmbLocal(0);
                                retornaHoras();
                            break;
                        case -1:
                                tela.showMsg("Erro!");
                            break;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(DisponibilizarDataHoraLocalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                tela.showMsg("Preencha todos os campos!");
            }
        }
        
    }
    
    private class goAtendimentos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new ConsultarAtendimentosMonitorController(new ConsultarAtendimentosMonitorView());
        }
        
    }
    
    
}
