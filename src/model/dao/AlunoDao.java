package model.dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.bean.AlunoBean;

public class AlunoDao {
    private Connection connection;

    public AlunoDao() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    
    public Vector<AlunoBean> consultar(String busca)
    {
        try{
            String sql = "select * from aluno where nome like ?";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, '%'+busca+'%');
            ResultSet rs = ps.executeQuery();
            
            Vector<AlunoBean> lista = new Vector();
            while(rs.next()){
                 AlunoBean aluno = new AlunoBean();
                 aluno.setMatricula(rs.getInt("matricula"));
                 aluno.setNome(rs.getString("nome"));
                 aluno.setEmail(rs.getString("email"));
                 aluno.setPeriodo(rs.getInt("periodo"));
                 lista.add(aluno);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public int login(String login, String senha){
        try{
            String sql = "select fnLoginAluno(?, ?) as result";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            int result = 0;        
            if(rs.next()){
                result = rs.getInt("result");
                if(result != 0){
                    AlunoBean.mat = Integer.parseInt(login);
                }
            }
                
            ps.close();
            connection.close();
            return result;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
