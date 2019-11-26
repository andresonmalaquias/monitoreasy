package mvc.monitor;

import mvc.aluno.*;
import controller.aluno.ConsultarAgendamentosController;
import controller.aluno.MenuAlunoController;
import controller.monitor.MenuMonitorController;
import view.aluno.ConsultarAgendamentosView;
import view.aluno.MenuAlunoView;
import view.monitor.MenuMonitorView;

/**
 *
 * @author Aluno
 */
public class MenuMonitorMVC {
    public static void main(String args[]){
       new MenuMonitorController(new MenuMonitorView());
    }
}
