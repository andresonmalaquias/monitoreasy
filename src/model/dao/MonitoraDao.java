package model.dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.bean.MonitoraBean;
import model.bean.AlunoBean;

public class MonitoraDao {
    private Connection connection;

    public MonitoraDao() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    
    public int cadastrar(MonitoraBean monit)
    {
        String sql = "select fnTornaAlunoMonitor(?, ?, ?, ?) as alunomonitor;";
       
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1, monit.getDiscodigo());
            ps.setInt(2, monit.getAlumatricula());
            ps.setString(3, monit.getData());
            ps.setString(4, monit.getCicloLetivo());
            
            ResultSet rs = ps.executeQuery();
            int result = 0;
            while(rs.next()){
                result = rs.getInt("alunomonitor");
            }
            ps.close();
            
            connection.close();
            
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    
    public Vector<AlunoBean> consultarMonitoresDisciplina(String codigo)
    {
        String sql = "call spConsultaMonitoresDisciplina(?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigo);
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
    
    
    
    public Vector<MonitoraBean> consultarDatas(int monitor, String codigo_local)
    {
        String sql = "call spConsultaDatas(?, ?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, monitor);
            ps.setString(2, codigo_local);
            ResultSet rs = ps.executeQuery();
            
            Vector<MonitoraBean> lista = new Vector();
            while(rs.next()){
                MonitoraBean monitora = new MonitoraBean();
                monitora.setData(rs.getString("data"));
                lista.add(monitora);
            }
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Vector<MonitoraBean> consultarHorarios(String data, String codigo_local)
    {
        String sql = "call spConsultaHorarios(?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, data);
            ps.setString(2, codigo_local);
            ResultSet rs = ps.executeQuery();
            
            Vector<MonitoraBean> lista = new Vector();
            while(rs.next()){
                MonitoraBean monitora = new MonitoraBean();
                monitora.setHora(rs.getString("hora"));
                lista.add(monitora);
            }
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Vector<MonitoraBean> ConsultaMonitores(String busca){
        String sql = "call spConsultaMonitores(?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, busca);
            ResultSet rs = ps.executeQuery();

            Vector<MonitoraBean> lista = new Vector();
            while(rs.next()){
                 MonitoraBean monit = new MonitoraBean();
                 monit.setNomeAluno(rs.getString("nome"));
                 monit.setAlumatricula(rs.getInt("monmatricula"));
                 monit.setDiscodigo(rs.getString("discodigo"));
                 monit.setCicloLetivo(rs.getString("cicloletivo"));
                 lista.add(monit);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public Vector<MonitoraBean> consultaReservas(int mat, String busca, String data){
        String sql = "call spConsultaReservasMonitor(?, ?, ?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, mat);
            ps.setString(2, "%"+busca+"%");
            ps.setString(3, data);
            ResultSet rs = ps.executeQuery();

            Vector<MonitoraBean> lista = new Vector();
            while(rs.next()){
                 MonitoraBean monit = new MonitoraBean();
                 monit.setData(rs.getString("datahora"));
                 monit.setLocal(rs.getString("loccodigo"));
                 monit.setAlumatricula(rs.getInt("monmatricula"));
                 lista.add(monit);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public int retornaHorasMonitor(int mat, String semanaPosterior){
        String sql = "call spConsultarHorasMonitor(?, ?);";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, mat);
            ps.setString(2, semanaPosterior);
            ResultSet rs = ps.executeQuery();
            int horas = 0;
            while(rs.next()){
                horas = rs.getInt("horas");
            }  
            ps.close();
            connection.close();
            return horas;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public int login(String login, String senha){
        try{
            String sql = "select fnLoginMonitor(?, ?) as result";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            int result = 0;        
            if(rs.next()){
                result = rs.getInt("result");
                if(result != 0){
                    MonitoraBean.mat = Integer.parseInt(login);
                }
            }           
            ps.close();
            connection.close();
            return result;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
     public boolean encerrarMonitoria(MonitoraBean monitor){
        try{
            String sql = "call spEncerrarMonitoria(?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, monitor.getAlumatricula());
            ps.execute();
            ps.close();
            connection.close();
            return true;
        }catch(SQLException ex){           
            throw new RuntimeException(ex);
        }
    }
}
