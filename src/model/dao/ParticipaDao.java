package model.dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.bean.AlunoBean;
import model.bean.ParticipaBean;

public class ParticipaDao {
    private Connection connection;

    public ParticipaDao() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    
    public int reservarParticipacao(ParticipaBean participa)
    {
        String sql = "select fnReservarAtendimento(?, ?, ?, ?) as atendimento;";
        try{
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, participa.getAlunoMatricula());
            ps.setInt(2, participa.getMonitorMatricula());
            ps.setString(3, participa.getDataHora());       
            ps.setString(4, participa.getLocal());
            ResultSet rs = ps.executeQuery();
            int result = -1;
            
            while(rs.next()){
                result = rs.getInt("atendimento");
            }  
            ps.close();
            connection.close();
            return result;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Vector<ParticipaBean> consultarAtendimentos(int matricula, String busca){
        String sql = "call spConsultaAgendamentoAluno(?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, matricula);
            ps.setString(2, "%"+busca+"%");
            ResultSet rs = ps.executeQuery();

            Vector<ParticipaBean> lista = new Vector();
            while(rs.next()){
                 ParticipaBean part = new ParticipaBean();
                 part.setDisciplina(rs.getString("discodigo"));
                 part.setDataHora(rs.getString("resdatahora"));
                 part.setNomeMonitor(rs.getString("nome"));
                 part.setAlunoMatricula(rs.getInt("alumatricula"));
                 part.setLocal(rs.getString("resloccodigo"));
                 lista.add(part);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public int cancelarAtendimento(ParticipaBean part){
        String sql = "select fnCancelarAtendimento(?, ?, ?) as result";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, part.getAlunoMatricula());
            ps.setString(2, part.getDataHora());
            ps.setString(3, part.getLocal());
            ResultSet rs = ps.executeQuery();

            int result = -1;
            while(rs.next()){
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
