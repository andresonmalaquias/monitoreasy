/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.aluno;

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
import model.bean.AlunoBean;
import model.bean.DisciplinaBean;
import model.bean.LocalBean;
import model.bean.MonitoraBean;
import model.bean.ParticipaBean;
import model.dao.AlunoDao;
import model.dao.DisciplinaDao;
import model.dao.LocalDao;
import model.dao.MonitoraDao;
import model.dao.ParticipaDao;
import view.aluno.ConsultarAgendamentosView;
import view.aluno.ReservarAtendimentoView;

public class ReservarAtendimentoController {
    private ReservarAtendimentoView tela;
    Vector<DisciplinaBean> listaDisciplina;
    Vector<AlunoBean> listaMonitores;
    Vector<LocalBean> listaLocais;
    Vector<MonitoraBean> listaDatas;
    Vector<MonitoraBean> listaHoras;
    
    public ReservarAtendimentoController(ReservarAtendimentoView tela) {
        this.tela = tela;
        carregarComboBox();
        this.tela.addCmbDisciplinaListener(new ComboMouseDisciplinaListener());
        this.tela.addCmbMonitorListener(new ComboMouseMonitorListener());
        this.tela.addCmbLocalListener(new ComboMouseLocalListener());
        this.tela.addDpDataListener(new AddDpDataListener());
        this.tela.addBtnListaListener(new AddBtnListaListener());
        //this.tela.addCmbDataListener(new ComboMouseDataListener());
        this.tela.addBtnReservarListener(new AddBtnReservar());
        this.tela.setEnabledCmbMonitor(false);
        this.tela.setEnabledCmbLocal(false);
        this.tela.setEnabledDpData(false);
        this.tela.setEnabledCmbHora(false);
        this.tela.setEnabledCmbDisciplina(true);
        this.tela.setLblDiscVisible(false);
        this.tela.setLblEmailVisible(false);
        this.tela.setLblPeriodoVisible(false);
        this.tela.setDisabledEditorDpData();
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
    
    public void carregarComboBox(){
        
        try {
            DisciplinaDao dao = new DisciplinaDao();
            listaDisciplina = dao.consultarDisciplinaComAtendimento();
            if(listaDisciplina.isEmpty()){

            }
            else{
                for(DisciplinaBean disciplina: listaDisciplina){
                    tela.addItemComboBox(disciplina.getNome());
                    
                    //conjuntoLinhas.add(linha);
                }
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar combobox disciplinas: " + ex.getMessage());
        }
    }
    
    
    public void carregarComboBoxMonitores(String codigo){
        //String valorBuscado = tela.getTxtPesquisar();
        tela.clearComboBoxMonitor();
        
        try {
            MonitoraDao dao = new MonitoraDao();
            listaMonitores = dao.consultarMonitoresDisciplina(codigo);
            if(listaMonitores.isEmpty()){
                tela.setEnabledCmbMonitor(false);
                tela.addItemComboBoxMonitor("--Vazio--");
                tela.addItemComboBoxLocal("--Vazio--");
                //tela.addItemComboBoxData("--Vazio--");
                tela.addItemComboBoxHorario("--Vazio--");
            }
            else{
                tela.setEnabledCmbMonitor(true);
                tela.addItemComboBoxMonitor("--Monitores--");
                for(AlunoBean aluno: listaMonitores){
                    tela.addItemComboBoxMonitor(aluno.getNome());
                }
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar combobox monitores: " + ex.getMessage());
        }
    }
    
    public void carregarComboBoxLocais(int codigo){        
        tela.clearComboBoxLocal();
        try {
            LocalDao dao = new LocalDao();
            listaLocais = dao.consultarLocaisAtendimento(codigo);
            if(listaLocais.isEmpty()){
                tela.setEnabledCmbLocal(false);
                tela.addItemComboBoxLocal("--Vazio--");
                //tela.addItemComboBoxData("--Vazio--");
                tela.addItemComboBoxHorario("--Vazio--");
            }
            else{
                tela.addItemComboBoxLocal("--Locais--");
                for(LocalBean local: listaLocais){
                    tela.addItemComboBoxLocal(""+local.getLocal());
                    //System.out.println(local.getLocal());
                }
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar combobox locais: " + ex.getMessage());
        }
    }
    //////////////////////////////////////////////////////////////////////////
    private void carregarDpData(int matricula, String local){ 
        Date data = new Date();
        this.tela.setDpDataLowerBound(data); 
        int day[] = {1, 0, -1, -2, -3, -4, -5};
        data.setDate(data.getDate() + day[data.getDay()]);
        data.setDate(data.getDate() + 7);            
        data.setDate(data.getDate() + 4);
        this.tela.setDpDataUpperBound(data);    
        this.tela.setDpDataColor(Color.green);
        this.tela.setDpDataFormats("dd/MM/yyyy");
        try {
            MonitoraDao dao = new MonitoraDao();
            listaDatas = dao.consultarDatas(matricula, local);
            Date vetDatas[] = new Date[listaDatas.size()];
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");            
            int i = 0;
            
            for (MonitoraBean dt : listaDatas) {
                vetDatas[i] = formato.parse(dt.getData());
                i++;
            }
            
            this.tela.setdpDataFlaggedDates(vetDatas);
            tela.setEnabledCmbHora(false);
            tela.addItemComboBoxHorario("--Horário--");
            //carregarComboBoxHorarios();
        } catch (Exception ex) {
            Logger.getLogger(DisponibilizarDataHoraLocalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void carregarComboBoxHora(String data, String codigo_disciplina){
        tela.clearComboBoxHorario();
        try {
            MonitoraDao dao = new MonitoraDao();  
            listaHoras = dao.consultarHorarios(data, codigo_disciplina);
            if(listaHoras.isEmpty()){
                tela.setEnabledCmbHora(false);
                tela.addItemComboBoxHorario("--Vazio--");
            }
            else{
                
                tela.addItemComboBoxHorario("--Horários--");
                for(MonitoraBean hora: listaHoras){
                    int intHora = Integer.parseInt(hora.getHora().substring(0, 2));
                    intHora++;
                    tela.addItemComboBoxHorario("" + hora.getHora() + " às " + intHora + ":00");
                }
            }
        } catch (Exception ex) {
            tela.showMsg("Erro ao caregar combobox horários: " + ex.getMessage());
        }
    }
    
    
    
    private class ComboMouseDisciplinaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = tela.returnIndexCmbDisciplina();
            if(index == 0){
                //tela.showMsg("Opção inválida!");
                tela.clearComboBoxMonitor();
                tela.setEnabledCmbMonitor(false);
                tela.setEnabledCmbLocal(false);
                tela.setEnabledDpData(false);
                tela.setEnabledCmbHora(false);
                tela.addItemComboBoxMonitor("--Vazio--");
                tela.addItemComboBoxLocal("--Vazio--");
                //tela.addItemComboBoxData("--Vazio--");
                tela.addItemComboBoxHorario("--Vazio--");
                tela.setLblDiscVisible(false);
            }
            else{
                DisciplinaBean disc = listaDisciplina.get(index-1);
                carregarComboBoxMonitores(disc.getCodigo());
                tela.setEnabledCmbDisciplina(true);
                tela.setLblDiscVisible(true);
                tela.setLblDiscText("Código: "+disc.getCodigo());
            }
        } 
    }
    
    private class ComboMouseMonitorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                int num = tela.returnIndexCmbMonitor();
                if(num == 0){
                    tela.clearComboBoxLocal();
                    tela.setEnabledCmbLocal(false);
                    tela.setEnabledDpData(false);
                    tela.setEnabledCmbHora(false);
                    tela.addItemComboBoxLocal("--Vazio--");
                    //tela.addItemComboBoxData("--Vazio--");
                    tela.addItemComboBoxHorario("--Vazio--");
                    tela.setLblEmailVisible(false);
                    tela.setLblPeriodoVisible(false);
                }else if(num<0){ 
                
                }else{
                    AlunoBean aluno = listaMonitores.get(num-1);
                    carregarComboBoxLocais(aluno.getMatricula());
                    tela.setEnabledCmbLocal(true);
                    tela.setEnabledCmbMonitor(true);
                    tela.setEnabledCmbDisciplina(true);
                    tela.setLblEmailVisible(true);
                    tela.setLblPeriodoVisible(true);
                    tela.setLblEmailText("Email: "+aluno.getEmail());
                    //System.out.println(aluno.getPeriodo());
                    tela.setLblPeriodoText("Período: "+aluno.getPeriodo());
                }   
        } 
    }
    
    ////////////////////////////////////////////////////////////
    private class ComboMouseLocalListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                int num = tela.returnIndexCmbLocal();
                if(num == 0){
                    //tela.clearComboBoxData();
                    tela.setEnabledDpData(false);
                    tela.setEnabledCmbHora(false);
                    //tela.addItemComboBoxData("--Vazio--");
                    tela.addItemComboBoxHorario("--Vazio--");
                }else if(num<0){
                
                }else{
                    LocalBean local = listaLocais.get(num-1);
                    num = tela.returnIndexCmbMonitor();
                    AlunoBean aluno = listaMonitores.get(num-1);
                    carregarDpData(aluno.getMatricula(), local.getLocal());
                    tela.setEnabledDpData(true);
                }   
        } 
    }
    private class AddDpDataListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            tela.clearComboBoxHorario();
            if(tela.dataIsEmpty()){
                tela.setEnabledCmbHora(false);
                tela.showMsg("Data selecionada é inválida!");
            }else{
                int index = tela.returnIndexCmbLocal();
                LocalBean local = listaLocais.get(index-1);
                carregarComboBoxHora(getData(), local.getLocal());
                tela.setEnabledCmbHora(true);
            }
        }
    }
    
    private class AddBtnReservar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(tela.returnIndexCmbDisciplina() != 0
                                                && tela.returnIndexCmbMonitor()!= 0
                                                && !tela.dataIsEmpty()
                                                && tela.returnIndexCmbLocal()!= 0
                                                && tela.returnIndexCmbHora()!= 0){
                ParticipaBean participa = new ParticipaBean();
                participa.setAlunoMatricula(AlunoBean.mat);
                int index;           
                index = tela.returnIndexCmbMonitor();

                participa.setMonitorMatricula(listaMonitores.get(index-1).getMatricula());
                        
                //index = tela.returnIndexCmbData();
                
                //String dataHora = listaDatas.get(index-1).getData();
                
                index = tela.returnIndexCmbHora();
                String dataHora = getData() + " " + listaHoras.get(index-1).getHora() + ":00";
                
                participa.setDataHora(dataHora);
                
                index = tela.returnIndexCmbLocal();
                participa.setLocal(listaLocais.get(index-1).getLocal());
                
                try {
                    ParticipaDao dao = new ParticipaDao();
                    int result = dao.reservarParticipacao(participa);
                    
                    switch(result){
                        case 1:
                            tela.showMsg("Você já está com reserva em outra monitoria nesse mesmo horário e/ou data!");
                        break;
                        case 2:
                            tela.showMsg("Cadastro na monitoria realizado com sucesso!");
                        break;
                        case 3:
                            tela.showMsg("Você já está cadastrado nesse atendimento!");
                        break;
                        case 4:
                            tela.showMsg("Você não pode se cadastrar no próprio atendimento!");
                        break;
                        case 0: 
                            tela.showMsg("Atendimento cheio!");
                        break;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ReservarAtendimentoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
            }
            else{
                tela.showMsg("Selecione e/ou preencha todos os campos!");
            }
        }
        
    }
    class AddBtnListaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new ConsultarAgendamentosController(new ConsultarAgendamentosView());
        }
        
    }
        
    
}
