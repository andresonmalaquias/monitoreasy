package mvc.coordenador.rank;


import controller.coordenador.rank.RankMonitorQueMaisDisponibilizouAtendimentoController;
import view.coordenador.rank.RankMonitorQueMaisDisponibilizouAtendimentoView;


public class RankMonitorQueMaisDisponibilizouAtendimentoMVC {
    public static void main(String args[]){
        new RankMonitorQueMaisDisponibilizouAtendimentoController(new RankMonitorQueMaisDisponibilizouAtendimentoView());
    }
}
