package controller.coordenador.rank;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.bean.MonitoraBean;
import model.dao.RankDao;
import view.coordenador.rank.RankMonitorQueMaisDisponibilizouAtendimentoView;

public class RankMonitorQueMaisDisponibilizouAtendimentoController{
    private RankMonitorQueMaisDisponibilizouAtendimentoView tela;
    Vector<MonitoraBean> lista;
    
    public RankMonitorQueMaisDisponibilizouAtendimentoController(RankMonitorQueMaisDisponibilizouAtendimentoView tela) {
        this.tela = tela;
        carregarTabela();
        this.tela.setEditTableNull();
        this.tela.setVisible(true);

    }
    
    public void carregarTabela(){        
        try {
            RankDao dao = new RankDao();
            lista = dao.RankMonitorQueMaisDisponibilizouAtendimento();
            if(lista.size() < 1){
                tela.showMsg("Monitor não encontrado!");
            }
            else{
                
                Vector conjuntoLinhas = new Vector();

                for(MonitoraBean moni: lista){
                    Vector linha = new Vector();

                    linha.add(moni.getNomeAluno());
                    linha.add(moni.getDiscodigo());
                    linha.add(moni.getAlumatricula());

                    conjuntoLinhas.add(linha);
                }
                Vector conjuntoColunas = new Vector();
                conjuntoColunas.add("Monitor"); 
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

