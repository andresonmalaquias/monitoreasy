package controller.coordenador.rank;


import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.bean.DisciplinaBean;
import model.dao.RankDao;
import view.coordenador.rank.RankDisciplinaMaisFrequentadaView;

public class RankDisciplinaMaisFrequentadaController{
    private RankDisciplinaMaisFrequentadaView tela;
    Vector<DisciplinaBean> listaDisciplinas;
    
    public RankDisciplinaMaisFrequentadaController(RankDisciplinaMaisFrequentadaView tela) {
        this.tela = tela;
        carregarTabela();
        this.tela.setEditTableNull();
        this.tela.setVisible(true);

    }
    
    public void carregarTabela(){        
        try {
            RankDao dao = new RankDao();
            listaDisciplinas = dao.RankDisciplinaMaisFrequentada();
            if(listaDisciplinas.size() > 0){
                
                Vector conjuntoLinhas = new Vector();

                for(DisciplinaBean disc: listaDisciplinas){
                    Vector linha = new Vector();

                    linha.add(disc.getCodigo());
                    linha.add(disc.getNome());
                    linha.add(disc.getQtd());

                    conjuntoLinhas.add(linha);
                }
                Vector conjuntoColunas = new Vector();
                conjuntoColunas.add("Código"); 
                conjuntoColunas.add("Disciplina");
                conjuntoColunas.add("Quantidade");

                DefaultTableModel modeloTabela = 
                        new DefaultTableModel(conjuntoLinhas, conjuntoColunas);
                tela.setTblDados(modeloTabela);
            }
        } catch (Exception ex) {
            
        }
    }
}

