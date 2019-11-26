/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.monitor;

import controller.coordenador.*;
import controller.main.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import model.bean.DataBean;
import view.coordenador.DisponibilizarDataHoraLocalView;
import view.coordenador.MenuCoordenadorView;
import view.coordenador.TornarAlunoMonitorView;
import view.main.LoginView;
import view.monitor.MenuMonitorView;
import view.monitor.ReservarDataHoraLocalView;

/**
 *
 * @author Aluno
 */
public class MenuMonitorController {
    private MenuMonitorView tela;
    
    public MenuMonitorController(MenuMonitorView tela) {
        this.tela = tela;
        this.tela.addBtnOption1Listener(new Option1());
        this.tela.addBtnOption2Listener(new Option2());
        this.tela.addBtnOption3Listener(new Option3());
        this.tela.addBtnOption4Listener(new Option4());
        this.tela.setVisible(true);
    } 
    class Option1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new ReservarDataHoraLocalController(new ReservarDataHoraLocalView());
            tela.closeView();
        }
    
    }
    class Option2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //new ReservarAtendimentoController(new ReservarAtendimentoView());
            tela.showMsg("Goes somewhere...");
        }
    
    }
    class Option3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //new ReservarAtendimentoController(new ReservarAtendimentoView());
            tela.showMsg("Goes somewhere...");
        }
    
    }
    class Option4 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //new ReservarAtendimentoController(new ReservarAtendimentoView());
            tela.showMsg("Goes somewhere...");
        }
    
    }
}
