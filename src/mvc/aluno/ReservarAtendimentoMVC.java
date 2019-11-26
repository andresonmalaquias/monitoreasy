package mvc.aluno;

import controller.aluno.ReservarAtendimentoController;
import view.aluno.ReservarAtendimentoView;

public class ReservarAtendimentoMVC {
    public static void main(String[] args){
        new ReservarAtendimentoController(new ReservarAtendimentoView());
    }
}
