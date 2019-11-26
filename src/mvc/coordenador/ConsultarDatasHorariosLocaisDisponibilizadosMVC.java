/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.coordenador;


import controller.aluno.ConsultarAgendamentosController;
import controller.coordenador.ConsultarDatasHorariosLocaisDisponibilizadosController;
import controller.coordenador.ConsultarMonitoresController;
import view.aluno.ConsultarAgendamentosView;
import view.coordenador.ConsultarDatasHorariosLocaisDisponibilizadosView;
import view.coordenador.ConsultarMonitoresView;

/**
 *
 * @author Thiago Sena
 */
public class ConsultarDatasHorariosLocaisDisponibilizadosMVC {
    public static void main(String args[]){
       new ConsultarDatasHorariosLocaisDisponibilizadosController(new ConsultarDatasHorariosLocaisDisponibilizadosView());
    }
}
