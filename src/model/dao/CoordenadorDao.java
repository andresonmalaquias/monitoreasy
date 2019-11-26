package model.dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.MonitoraBean;

public class CoordenadorDao {
    private Connection connection;

    public CoordenadorDao() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    
    public int login(String login, String senha){
        try{
            String sql = "select fnLoginCoordenador(?, ?) as result";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            int result = 0;        
            if(rs.next()){
                result = rs.getInt("result");
            }
                
            ps.close();
            connection.close();
            return result;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
