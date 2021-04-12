package br.com.SistemaLogin.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;
import br.ccom.SistemaLogin.conexao.CriarConexao;


	

@WebServlet("/CadastroFuncionario")
public class dadosFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
    
	
	public dadosFuncionario() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nome = request.getParameter("txtNome");
		String salario = request.getParameter("txtSalario");
		String rg = request.getParameter("txtRg");
		String cpf = request.getParameter("txtCpf");
		String cargo = request.getParameter("txtCargo");
		
		Connection con;
		try {
			
			con = CriarConexao.getConexao();
			
			Funcionario f = new Funcionario();
			
			f.setNome(nome);
			f.setSalario(salario);
			f.setRg(rg);
			f.setCpf(cpf); 
			f.setCargo(cargo);
			
			LoginDAO dao = new LoginDAO(con);
			dao.adicionar(f);
			
			request.setAttribute("msg", "Cadastrado com sucesso!");		
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	} 	
	public void listarTodosOsFuncionarios()  {
	        Statement stm;
	        try {
	            stm = con.createStatement();
	            String sql = "select * from sistemaPP.funcionario";
	            ResultSet rs = stm.executeQuery(sql);
	            while (rs.next()) {
	                System.out.println(rs.getString("nome"));
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	 public void buscarPorNome(String nome){
	        String sql = "select nome,salario,rg,cpf,cargo from sistemaPP.funcionario where nome like ?";
	        PreparedStatement psm;
	        try {
	            psm = con.prepareStatement(sql);
	            psm.setString(2, nome);
	            ResultSet rs = psm.executeQuery();
	            while (rs.next()) {
	                System.out.println(rs.getString("nome"));
	                System.out.println(rs.getString("salario"));
	                System.out.println(rs.getString("rg"));
	                System.out.println(rs.getString("cpf"));
	                System.out.println(rs.getString("cargo"));
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
	        }
	
	 } 
	 public void buscarPorId(String Id){
	        String sql = "select id from sistemaPP.funcionario where id like  ?";
	        PreparedStatement psm;
	        try {
	            psm = con.prepareStatement(sql);
	            psm.setString(1, Id);
	            ResultSet rs = psm.executeQuery();
	            while (rs.next()) {
	                System.out.println(rs.getString("nome"));
	                System.out.println(rs.getString("salario"));
	                System.out.println(rs.getString("rg"));
	                System.out.println(rs.getString("cpf"));
	                System.out.println(rs.getString("cargo"));
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
	        }
	 }

}