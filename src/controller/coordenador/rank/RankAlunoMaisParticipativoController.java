package controller.coordenador.rank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.bean.AlunoBean;
import model.dao.RankDao;
import view.coordenador.rank.RankAlunoMaisParticipativoView;


public class RankAlunoMaisParticipativoController{
    private RankAlunoMaisParticipativoView tela;
    Vector<AlunoBean> lista;
    
    public RankAlunoMaisParticipativoController(RankAlunoMaisParticipativoView tela) {
        this.tela = tela;
        carregarTabela();
        this.tela.addBtnBuscarListener(new BtnBuscarActionListener());
        this.tela.setEditTableNull();
        this.tela.setVisible(true);

    }
    
    public void carregarTabela(){        
        try {
            RankDao dao = new RankDao();
            lista = dao.RankAlunoMaisParticipativo(tela.getBusca());
            if(lista.size() > 0){
                
                Vector conjuntoLinhas = new Vector();

                for(AlunoBean aluno: lista){
                    Vector linha = new Vector();                
                    linha.add(aluno.getNome());
                    linha.add(aluno.getPeriodo());
                    conjuntoLinhas.add(linha);
                }
                Vector conjuntoColunas = new Vector();
                conjuntoColunas.add("Nome"); 
                conjuntoColunas.add("Quantidade");

                DefaultTableModel modeloTabela = 
                        new DefaultTableModel(conjuntoLinhas, conjuntoColunas);
                tela.setTblDados(modeloTabela);
            }
        } catch (Exception ex) {
        }
    }
    
        class BtnBuscarActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carregarTabela();
            
        }    
    }
}

