/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.coordenador;

import mvc.aluno.*;
import controller.aluno.ConsultarAgendamentosController;
import controller.aluno.MenuAlunoController;
import controller.coordenador.MenuCoordenadorController;
import view.aluno.ConsultarAgendamentosView;
import view.aluno.MenuAlunoView;
import view.coordenador.MenuCoordenadorView;

/**
 *
 * @author Aluno
 */
public class MenuCoordenadorMVC {
    public static void main(String args[]){
       new MenuCoordenadorController(new MenuCoordenadorView());
    }
}
