package br.com.SistemaLogin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {

	}

	private void ValidaDadosRecebidos(HttpServletRequest req) throws ServletException {

		String nome = req.getParameter("txtNome");
		String salario = req.getParameter("txtSalario");
		String rg = req.getParameter("txtRg");
		String cpf = req.getParameter("txtCpf");
		String cargo = req.getParameter("txtCargo");

		HttpSession session = req.getSession();
		session.setAttribute("funcionarioautenticado", nome);
	}


	private void validarDadosProfessor(HttpServletRequest req) throws ServletException {

		String nome = req.getParameter("txtNome");
		String salario = req.getParameter("txtSalario");
		String rg = req.getParameter("txtRg");
		String cpf = req.getParameter("txtCpf");
		String cargo = req.getParameter("txtCargo");
		String disciplina = req.getParameter("txtDisciplina");
		String areaInteresse = req.getParameter("txtAreaInteresseO");
		
		HttpSession session = req.getSession();
		session.setAttribute("professorautenticado", nome);
	}
}
