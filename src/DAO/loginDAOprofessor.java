package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.SistemaLogin.Login.Professor;

public class loginDAOprofessor {
	private Connection con;

	public void LoginDAO(Connection con) {
		this.con = con;
	}

	public void adicionar(Professor p) throws SQLException {

		String sql = "insert into sistemaPP.funcionario(nome,salario,rg,cpf,cargo,disciplina,areaInteresse)values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getSalario());
			stmt.setString(3, p.getRg());
			stmt.setString(4, p.getCpf());
			stmt.setString(5, p.getCargo());
			stmt.setString(6, p.getDisciplinas());
			stmt.setString(7, p.getAreasInteresse());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
