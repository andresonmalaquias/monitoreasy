package mvc.monitor;

import controller.monitor.ConsultarAtendimentosMonitorController;
import view.monitor.ConsultarAtendimentosMonitorView;

public class ConsultarAtendimentosMonitorMVC {
    public static void main(String args[]){
       new ConsultarAtendimentosMonitorController(new ConsultarAtendimentosMonitorView());
    }
}
