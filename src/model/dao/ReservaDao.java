package model.dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.MonitoraBean;
import model.bean.ReservaBean;

public class ReservaDao {
    private Connection connection;

    public ReservaDao() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    public int reservarHorarioMonitoria(ReservaBean reserva, String dataSemPost){
        String sql = "select fnReservarHorarioMonitoria(?, ?, ?, ?) as reserva";
       
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, reserva.getDataHora());
            ps.setInt(2, reserva.getMonMatricula());
            ps.setString(3, reserva.getLocCodigo());
            ps.setString(4, dataSemPost);
            ResultSet rs = ps.executeQuery();
            
            int result = -1;
            while(rs.next()){
                result = rs.getInt("reserva");
            }

            ps.close();        
            connection.close();
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    public int cancelarReserva(MonitoraBean monitora){
        String sql = "select fnCancelarReserva(?, ?, ?) as result";
       
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, monitora.getAlumatricula());
            ps.setString(2, monitora.getData());            
            ps.setString(3, monitora.getLocal());
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
}
