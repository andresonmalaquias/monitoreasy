package mvc.monitor;

import controller.monitor.ReservarDataHoraLocalController;
import view.monitor.ReservarDataHoraLocalView;
import view.coordenador.DisponibilizarDataHoraLocalView;

public class ReservarDataHoraLocalMVC {
    public static void main(String[] args) {
        new ReservarDataHoraLocalController(new ReservarDataHoraLocalView());
    }
}
