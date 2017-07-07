package br.ucsal.transporte.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conex {
	
	
	   private static String endereco = "jdbc:mysql://localhost:3306/roteiro";
	    private static String usuario = "root";
	    private static String senha = "admin";
	    private static String driver = "com.mysql.jdbc.Driver";
	
	
	public static Connection conectar() throws InstantiationException, IllegalAccessException{

Connection connection = null;
try {
    Class.forName(driver).newInstance();
    System.out.println("Entrando...");
    connection = DriverManager.getConnection(endereco, usuario, senha);
    System.out.println("Entrada OK");
    System.out.println("Conectado ao BD");
} catch (SQLException e) {
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
return connection;
}

public static void desconectar(Connection con) throws SQLException {
try {
    if (!con.isClosed()) {
        con.close();
    }
    System.out.println("Desconectado do BD!");
} catch (SQLException e) {
    e.printStackTrace();
}
}
	
	
	

}
