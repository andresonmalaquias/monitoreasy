package model.dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.bean.LocalBean;

public class LocalDao {
    private Connection connection;

    public LocalDao() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    
    public Vector<LocalBean> consultarLocais(){
        String sql = "call spConsultaLocais();";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Vector<LocalBean> locais = new Vector();
            while(rs.next()){
                LocalBean local = new LocalBean();
                local.setLocal(rs.getString("local")); 
                locais.add(local);
            }  
            ps.close();
            connection.close();
            return locais;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Vector<LocalBean> consultaLocaisDisponiveis(String data){
        String sql = "call spConsultaLocaisDisponiveis(?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            
            Vector<LocalBean> locais = new Vector();
            while(rs.next()){
                LocalBean local = new LocalBean();
                local.setLocal(rs.getString("local")); 
                locais.add(local);
            }  
            ps.close();
            connection.close();
            return locais;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Vector<LocalBean> consultarLocaisAtendimento(int codigo)
    {
        String sql = "call spConsultaLocalAtendimentos(?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, codigo);
            //System.out.println(codigo);
            ResultSet rs = ps.executeQuery();
            
            Vector<LocalBean> locais = new Vector();
            while(rs.next()){
                LocalBean local = new LocalBean();
                local.setLocal(rs.getString("local")); 
                locais.add(local);
            }  
            ps.close();
            connection.close();
            return locais;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
