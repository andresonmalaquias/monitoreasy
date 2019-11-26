package model.dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.bean.DisciplinaBean;

public class DisciplinaDao {
    private Connection connection;

    public DisciplinaDao() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    
    public Vector<DisciplinaBean> consultar()
    {
        try{
            String sql = "call spConsultaDisciplina();";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            String nome = "";
            String codigo = "";
            
            Vector<DisciplinaBean> lista = new Vector();
            while(rs.next()){
                 nome = rs.getString("nome");
                 codigo = rs.getString("codigo");
                 
                 DisciplinaBean disciplina = new DisciplinaBean();
                 disciplina.setCodigo(codigo);
                 disciplina.setNome(nome);
                 lista.add(disciplina);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public Vector<DisciplinaBean> consultarDisciplinaComAtendimento()
    {
        try{
            String sql = "call spconsultarDisciplinaComAtendimento();";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            String nome = "";
            String codigo = "";
            
            Vector<DisciplinaBean> lista = new Vector();
            while(rs.next()){
                 nome = rs.getString("nome");
                 codigo = rs.getString("codigo");
                 
                 DisciplinaBean disciplina = new DisciplinaBean();
                 disciplina.setCodigo(codigo);
                 disciplina.setNome(nome);
                 lista.add(disciplina);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
