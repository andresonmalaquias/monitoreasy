package controller.coordenador.rank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.bean.DisciplinaBean;
import model.bean.MonitoraBean;
import model.dao.MonitoraDao;
import model.dao.RankDao;
import view.coordenador.ConsultarMonitoresView;
import view.coordenador.rank.RankDisciplinaComMaiorNumeroAtendimentoView;

public class RankDisciplinaComMaiorNumeroAtendimentoController{
    private RankDisciplinaComMaiorNumeroAtendimentoView tela;
    Vector<DisciplinaBean> listaDisciplinas;
    
    public RankDisciplinaComMaiorNumeroAtendimentoController(RankDisciplinaComMaiorNumeroAtendimentoView tela) {
        this.tela = tela;
        carregarTabela();
        this.tela.setEditTableNull();
        this.tela.setVisible(true);

    }
    
    public void carregarTabela(){        
        try {
            RankDao dao = new RankDao();
            listaDisciplinas = dao.rankDisciplinaComMaiorNumeroAtendimento();
            if(listaDisciplinas.size() < 1){
                tela.showMsg("Monitor não encontrado!");
            }
            else{
                
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
            tela.showMsg("Erro ao caregar tabela: " + ex.getMessage());
        }
    }
}

