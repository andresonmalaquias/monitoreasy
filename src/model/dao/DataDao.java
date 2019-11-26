package model.dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.bean.DataBean;
import model.bean.ReservaBean;

public class DataDao {
    private Connection connection;

    public DataDao() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    public boolean disponibilizarHorario(DataBean dataBean){
        String sql = "call spDisponibilizarLocalData(?, ?)";
       
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dataBean.getData());
            ps.setString(2, dataBean.getLoccodigo());
            ps.execute();

            ps.close();            
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public boolean cadastrarHoras(DataBean dataBean){
        String sql = "call spDisponibilizarLocalHora(?, ?, ?);";
       
        try {
            for (String hora : dataBean.getHoras()) {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, hora);
                ps.setString(2, dataBean.getData());
                ps.setString(3, dataBean.getLoccodigo());

                ps.execute();

                ps.close();
            }          
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public Vector<DataBean> consultarDatas(String local)
    {
        try{
            String sql = "call spConsultarDatasDeLocal(?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, local);
            ResultSet rs = ps.executeQuery();
            
            Vector<DataBean> lista = new Vector();
            while(rs.next()){
                DataBean dataBean = new DataBean();
                dataBean.setData(rs.getString("dia"));
                lista.add(dataBean);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Vector<DataBean> consultarDatasFuturas(String local, String data)
    {
        try{
            String sql = "call spConsultarDatasDeLocalFuturas(?, ?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, local);
            ps.setString(2, data);
            ResultSet rs = ps.executeQuery();
            
            Vector<DataBean> lista = new Vector();
            while(rs.next()){
                DataBean dataBean = new DataBean();
                dataBean.setData(rs.getString("dia"));
                lista.add(dataBean);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Vector<DataBean> consultarHorariosDisponibilizados(String busca, String dt)
    {
        try{
            String sql = "call spConsultaHorariosDisponibilizados(?, ?);";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+busca+"%");
            ps.setString(2, dt);
            ResultSet rs = ps.executeQuery();
            
            Vector<DataBean> lista = new Vector();
            while(rs.next()){
                DataBean data = new DataBean();
                data.setHora(rs.getString("hora"));
                data.setData(rs.getString("datdia"));
                data.setLoccodigo(rs.getString("datloccodigo"));
                lista.add(data);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public DataBean consultarHoras(DataBean dataBean){
        try{
            String sql = "call spConsultarHorasDeLocal(?, ?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dataBean.getData());
            ps.setString(2, dataBean.getLoccodigo());
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                dataBean.setHoras(rs.getString("hora"));
            }
            ps.close();
            connection.close();
            return dataBean;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
            
    public int removeDataHoraDisponibilizada(DataBean data){
        String sql = "select fnRemoverLocalDataHorario(?, ?, ?) as result;";
       
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data.getLoccodigo());
            ps.setString(2, data.getData());
            ps.setString(3, data.getHora());
            ResultSet rs = ps.executeQuery();
            
            int result = -1;
            while(rs.next()){
                result = rs.getInt("result");
            }

            ps.close();        
            connection.close();
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    public DataBean consultarHorasDisponiveis(DataBean dataBean){
        try{
            String sql = "call spConsultarHorasDeLocalDisponivel(?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dataBean.getData());
            ps.setString(2, dataBean.getLoccodigo());
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                dataBean.setHoras(rs.getString("hora"));
            }
            ps.close();
            connection.close();
            return dataBean;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
