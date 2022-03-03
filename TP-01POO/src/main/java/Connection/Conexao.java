package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConexao(){
        Connection conn = null;
        try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp01poo?user=root&password=root");
            System.out.println("conectado com sucesso");
        }catch(SQLException e){
            System.out.println("falha na conexão"+e);
        }
        return conn;
    }
}
