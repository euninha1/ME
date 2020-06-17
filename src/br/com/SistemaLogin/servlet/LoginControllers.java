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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response); 
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void ValidaDadosRecebidos(HttpServletRequest req) throws ServletException {
		
		String idFuncionario = req.getParameter("txtId");
		String nome = req.getParameter("txtNome");
		
		
		 HttpSession session = req.getSession();
		 session.setAttribute("funcionarioautenticado", idFuncionario);
		}
	}


