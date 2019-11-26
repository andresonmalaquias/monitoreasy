package model.dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.bean.AlunoBean;
import model.bean.DisciplinaBean;
import model.bean.MonitoraBean;

public class RankDao {
    private Connection connection;

    public RankDao() throws Exception{
        connection = FabricaConexao.getConnection();
    }
    
    public Vector<DisciplinaBean> rankDisciplinaComMaiorNumeroAtendimento(){
        try{
            String sql = "call spRankDisciplinaComMaiorNumeroAtendimento()";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Vector<DisciplinaBean> lista = new Vector();
            while(rs.next()){
                DisciplinaBean disciplina = new DisciplinaBean();
                disciplina.setCodigo(rs.getString("codigo"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setQtd(rs.getInt("qtdvezes"));
                lista.add(disciplina);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Vector<MonitoraBean> RankMonitorQueMaisDisponibilizouAtendimento(){
        try{
            String sql = "call spRankMonitorQueMaisDisponibilizouAtendimento()";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Vector<MonitoraBean> lista = new Vector();
            while(rs.next()){
                MonitoraBean monitor = new MonitoraBean();
                monitor.setNomeAluno(rs.getString("nome"));
                monitor.setDiscodigo(rs.getString("disciplina"));
                monitor.setAlumatricula(rs.getInt("qtdvezes"));
                lista.add(monitor);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Vector<DisciplinaBean> RankDisciplinaMaisFrequentada(){
        try{
            String sql = "call spRankDisciplinaMaisFrequentada()";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Vector<DisciplinaBean> lista = new Vector();
            while(rs.next()){
                DisciplinaBean disciplina = new DisciplinaBean();
                disciplina.setCodigo(rs.getString("codigo"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setQtd(rs.getInt("qtdvezes"));
                lista.add(disciplina);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Vector<AlunoBean> RankAlunoMaisParticipativo(String local){
        try{
            String sql = "call spRankAlunoMaisParticipativo(?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, local);
            ResultSet rs = ps.executeQuery();
            
            Vector<AlunoBean> lista = new Vector();
            while(rs.next()){
                AlunoBean aluno = new AlunoBean();
                aluno.setNome(rs.getString("nome"));
                aluno.setPeriodo(rs.getInt("qtdvezes"));
                lista.add(aluno);
            }  
            ps.close();
            connection.close();
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
