package br.com.SistemaLogin.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ccom.SistemaLogin.conexao.CriarConexao;


@WebServlet("/CadastroFuncionario")
public class CadastroLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CadastroLoginServlet() {
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

}
