/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.aluno;


import controller.aluno.ConsultarAgendamentosController;
import controller.coordenador.ConsultarMonitoresController;
import view.aluno.ConsultarAgendamentosView;
import view.coordenador.ConsultarMonitoresView;

/**
 *
 * @author Thiago Sena
 */
public class ConsultarAgendamentosMVC {
    public static void main(String args[]){
       new ConsultarAgendamentosController(new ConsultarAgendamentosView());
    }
}
