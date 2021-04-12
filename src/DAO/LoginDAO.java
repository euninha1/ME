package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.SistemaLogin.Login.Funcionario;

import java.sql.PreparedStatement;

import java.sql.Connection;

public class LoginDAO {

	private Connection con;

	public LoginDAO(Connection con) {
		this.con = con;
	}

	public void adicionar(Funcionario f) throws SQLException {

		String sql = "insert into sistemaPP.funcionario(nome,salario,rg,cpf,cargo)values(?,?,?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getSalario());
			stmt.setString(3, f.getRg());
			stmt.setString(4, f.getCpf());
			stmt.setString(5, f.getCargo());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}
