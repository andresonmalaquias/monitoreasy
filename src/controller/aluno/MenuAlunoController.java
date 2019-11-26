/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.aluno;

import controller.coordenador.*;
import controller.main.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import model.bean.DataBean;
import view.aluno.MenuAlunoView;
import view.aluno.ReservarAtendimentoView;
import view.coordenador.MenuCoordenadorView;
import view.main.LoginView;

/**
 *
 * @author Aluno
 */
public class MenuAlunoController {
    private MenuAlunoView tela;
    
    public MenuAlunoController(MenuAlunoView tela) {
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
            new ReservarAtendimentoController(new ReservarAtendimentoView());
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
