/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.aluno;

import controller.aluno.ConsultarAgendamentosController;
import controller.aluno.MenuAlunoController;
import view.aluno.ConsultarAgendamentosView;
import view.aluno.MenuAlunoView;

/**
 *
 * @author Aluno
 */
public class MenuAlunoMVC {
    public static void main(String args[]){
       new MenuAlunoController(new MenuAlunoView());
    }
}
