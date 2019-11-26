package mvc.coordenador.rank;

import controller.coordenador.rank.RankDisciplinaMaisFrequentadaController;
import view.coordenador.rank.RankDisciplinaMaisFrequentadaView;


public class RankDisciplinaMaisFrequentadaMVC {
    public static void main(String args[]){
        new RankDisciplinaMaisFrequentadaController(new RankDisciplinaMaisFrequentadaView());
    }
}
