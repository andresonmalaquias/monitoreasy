package conexao;

import java.sql.*;

public class FabricaConexao {
    public static Connection getConnection() throws Exception{
        try{
            String host = "jdbc:mysql://localhost/monitoreasy?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(host, user, password);
            return connection;
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
}
