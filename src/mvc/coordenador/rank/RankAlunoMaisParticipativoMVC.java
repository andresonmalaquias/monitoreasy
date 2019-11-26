package mvc.coordenador.rank;

import controller.coordenador.rank.RankAlunoMaisParticipativoController;
import view.coordenador.rank.RankAlunoMaisParticipativoView;


public class RankAlunoMaisParticipativoMVC {
    public static void main(String args[]){
        new RankAlunoMaisParticipativoController(new RankAlunoMaisParticipativoView());
    }
}
