/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

import controller.aluno.MenuAlunoController;
import controller.coordenador.ConsultarDatasHorariosLocaisDisponibilizadosController;
import controller.coordenador.MenuCoordenadorController;
import controller.monitor.MenuMonitorController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.DataBean;
import model.dao.AlunoDao;
import model.dao.CoordenadorDao;
import model.dao.DataDao;
import model.dao.MonitoraDao;
import view.aluno.MenuAlunoView;
import view.coordenador.ConsultarDatasHorariosLocaisDisponibilizadosView;
import view.coordenador.MenuCoordenadorView;
import view.main.LoginView;
import view.monitor.MenuMonitorView;

/**
 *
 * @author Aluno
 */
public class LoginController {
    private LoginView tela;
    Vector<DataBean> listaHorarios;
    
    public LoginController(LoginView tela) {
        this.tela = tela;
        this.tela.addBtnEntrarListener(new entrar());
        this.tela.setVisible(true);
    }   
    class entrar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String login = tela.getTxtLogin();
            String senha = tela.getTxtSenha();
            if(!login.equals("") && !senha.equals("")){
                if(tela.btnAlunoIsSelected()){
                    if(isStringOnlyAlphabet(login)){
                        try {
                            AlunoDao dao = new AlunoDao();
                            int ok = dao.login(login, senha);
                            if(ok != 0){
                                new MenuAlunoController(new MenuAlunoView());  
                                tela.closeView();
                            }else{
                                tela.showMsg("Login e/ou senha incorretos!");
                            }                        
                        } catch (Exception ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        tela.showMsg("Insira uma matrícula numérica!");
                    }
                    
                }else if(tela.btnMonitorIsSelected()){
                    if(isStringOnlyAlphabet(login)){
                        try {
                            MonitoraDao dao = new MonitoraDao();
                            int ok = dao.login(login, senha);
                            if(ok != 0){
                                new MenuMonitorController(new MenuMonitorView()); 
                                tela.closeView();
                            }else{
                                tela.showMsg("Login e/ou senha incorretos!");
                            }            
                        } catch (Exception ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }     
                    }
                    else{
                        tela.showMsg("Insira uma matrícula numérica!");
                    }
                    
                }else if(tela.btnCoordIsSelected()){
                    try {
                            CoordenadorDao dao = new CoordenadorDao();
                            int ok = dao.login(login, senha);
                            if(ok != 0){
                                new MenuCoordenadorController(new MenuCoordenadorView());
                                tela.closeView();
                            }else{
                                tela.showMsg("Login e/ou senha incorretos!");
                            }            
                        } catch (Exception ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    //new MenuMonitorController(new MenuMonitorView());
                }else{
                    tela.showMsg("Erro ao selecionar tipo de login!");
                }
            }
            else{
                tela.showMsg("Preencha todos os campos!");
            }
        }
    }
    
    public boolean isStringOnlyAlphabet(String str) 
    { 
        return ((!str.equals("")) 
                && (str != null) 
                && (str.matches("[0-9]+") && str.length() > 2)); 
    } 
}
