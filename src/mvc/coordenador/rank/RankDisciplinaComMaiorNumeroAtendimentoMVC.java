package mvc.coordenador.rank;

import controller.coordenador.rank.RankDisciplinaComMaiorNumeroAtendimentoController;
import view.coordenador.rank.RankDisciplinaComMaiorNumeroAtendimentoView;


public class RankDisciplinaComMaiorNumeroAtendimentoMVC {
    public static void main(String args[]){
        new RankDisciplinaComMaiorNumeroAtendimentoController(new RankDisciplinaComMaiorNumeroAtendimentoView());
    }
}
