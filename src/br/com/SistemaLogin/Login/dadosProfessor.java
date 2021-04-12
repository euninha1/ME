package br.com.SistemaLogin.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;
import br.ccom.SistemaLogin.conexao.CriarConexao;

@WebServlet("/CadastroProfessor")
public class dadosProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		Connection con;  
		
		public dadosProfessor() { 
			super(); 
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response, String disciplinas) throws ServletException, IOException {
			
			
			String nome = request.getParameter("txtNome");
			String salario = request.getParameter("txtSalario");
			String rg = request.getParameter("txtRg");
			String cpf = request.getParameter("txtCpf");
			String cargo = request.getParameter("txtCargo");
			String disciplina = request.getParameter("txtDisciplina");
			String areasInteresse = request.getParameter("txtAreasInteresss");
		
			Connection con;
			try { 
				con = CriarConexao.getConexao(); 
				
				Professor p = new Professor(); 
			
				p.setNome(nome);
				p.setSalario(salario);
				p.setRg(rg);
				p.setCpf(cpf); 
				p.setCargo(cargo);
				p.setDisciplinas(disciplinas);
				p.setAreasInteresse(areasInteresse);
			
				LoginDAO dao = new LoginDAO(con);
				dao.adicionar(p);
				
				request.setAttribute("msg", "Cadastrado com sucesso!");
			
			}catch (SQLException e) { 
				e.printStackTrace();
			}
	
		}
}