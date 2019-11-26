package mvc.coordenador;

import controller.coordenador.TornarAlunoMonitorController;
import view.coordenador.TornarAlunoMonitorView;

public class TornarAlunoMonitorMVC {
    public static void main(String[] args){
        new TornarAlunoMonitorController(new TornarAlunoMonitorView());
    }
}
