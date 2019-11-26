/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.coordenador;

import controller.aluno.MenuAlunoController;
import controller.aluno.ReservarAtendimentoController;
import controller.main.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import model.bean.DataBean;
import view.aluno.ReservarAtendimentoView;
import view.coordenador.DisponibilizarDataHoraLocalView;
import view.coordenador.MenuCoordenadorView;
import view.coordenador.TornarAlunoMonitorView;
import view.main.LoginView;

/**
 *
 * @author Aluno
 */
public class MenuCoordenadorController {
    private MenuCoordenadorView tela;
    
    public MenuCoordenadorController(MenuCoordenadorView tela) {
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
            new DisponibilizarDataHoraLocalController(new DisponibilizarDataHoraLocalView());
            tela.closeView();
        }
    
    }
    class Option2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //new ReservarAtendimentoController(new ReservarAtendimentoView());
            tela.showMsg("Função futura.");
        }
    
    }
    class Option3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new TornarAlunoMonitorController(new TornarAlunoMonitorView());
            tela.closeView();
        }
    
    }
    class Option4 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //new ReservarAtendimentoController(new ReservarAtendimentoView());
            tela.showMsg("Função futura.");
        }
    
    }
}
