package mvc.coordenador;

import controller.monitor.ReservarDataHoraLocalController;
import controller.coordenador.DisponibilizarDataHoraLocalController;
import view.coordenador.DisponibilizarDataHoraLocalView;

public class DisponibilizarDataHoraLocalMVC {
    public static void main(String[] args) {
        new DisponibilizarDataHoraLocalController(new DisponibilizarDataHoraLocalView());
    }
}
