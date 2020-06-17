package br.ccom.SistemaLogin.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {
		
	public static Connection getConexao() throws SQLException { 
		
		try {
				Class.forName("com.mysql.jdbc.Driver"); 
				System.out.println("Conectado");
				
				//sofrerá mudanças quando o projeto for hospedado na web
				return DriverManager.getConnection("jdbc:mysql://databasetest.ctaato9ab42d.us-east-1.rds.amazonaws.com", "root", "natan5613");
			
		}catch(SQLException e) {  
			throw new SQLException(e);	
			
		}catch(ClassNotFoundException e1) {
			throw new SQLException(e1);		
			}
		}
}
