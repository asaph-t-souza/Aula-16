import java.sql.*;
import java.util.Properties;

public class App {
public static void main(String[] args) throws Exception {

    //Conexão Inicio
    Connection conn;
    String url = "jdbc:postgresql://localhost:5432/meu_banco";
    Properties props = new Properties();
    props.setProperty("user", "postgres");
    props.setProperty("password", "jaqueta");
    props.setProperty("ssl", "false");
    conn = DriverManager.getConnection(url, props);
    System.out.println("Conectado");
    //Conexão Fim

    Statement sttt = conn.createStatement();

    // Cria uma tabela chamada clients
    // String mySqlCode = "CREATE TABLE clients " +
    //                 "(" +
    //                     "username CHAR(20) PRIMARY KEY NOT NULL, " +
    //                     "fullname TEXT NOT NULL, " +
    //                     "email CHAR(50) NOT NULL, " +
    //                     "phone CHAR(15) NOT NULL, " +
    //                     "age INT NOT NULL " +
    //                 ")";
    
    // sttt.executeUpdate(mySqlCode);
    // System.out.println("Tabela Criada");

    //Insere uma linha na tabela clients
    // String mySqlCode = "INSERT INTO clients VALUES ('batata', 'batata tuberculo', 'batata@sharklasers.com', '98454518', 109)";
    // sttt.executeUpdate(mySqlCode);
    // System.out.println("Linha Inserida");

    String mySqlCode = "SELECT * FROM clients";
    ResultSet tableResult = sttt.executeQuery(mySqlCode);
    System.out.println("Query Executado");

    while(tableResult.next()){
        String username = tableResult.getString("username");
        System.out.println("Nome de usuario: " + username);
    } 


    sttt.close();
    conn.close();                

    }
}
