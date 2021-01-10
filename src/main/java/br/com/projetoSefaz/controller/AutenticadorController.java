package br.com.projetoSefaz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.com.projetoSefaz.dao.CadastroDAO;
import br.com.projetoSefaz.model.Cadastro;

@WebServlet("/autenticador.do")
public class AutenticadorController extends	HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//tentar achar sess�o, mas se n�o encontrar, n�o cria outra.
		HttpSession session = req.getSession(false);
		
		//se houver sess�o, invalida ela
		if(session!=null) {
			session.invalidate();
		}
		resp.sendRedirect("index.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Pega dados da tela
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		//Coloca dados em objeto usu�rio
		Cadastro cad = new Cadastro();		
		cad.setEmail(email);
		cad.setSenha(senha);
		
		//consulta se existe as credenciais no banco
		CadastroDAO cadDAO = new CadastroDAO();
		Cadastro usuAut = cadDAO.autenticar(cad);
		
		//se encontrou user no banco(n�o retornou nulo, ent�o executa)
		if (usuAut != null) {
			
			//recupera sess�o j� criada ou cria sess�o nova.
			HttpSession session = req.getSession();
			
			session.setAttribute("usu", usuAut);
			
			
			req.getRequestDispatcher("TelaInicial.jsp").forward(req,resp); 
		
		//se n�o encontrou, redireciona user para tela de login(principal)
		}else {
			JOptionPane.showMessageDialog(null,  "Email ou Senha est�(�o) incorreto(s)");
			resp.sendRedirect("index.jsp");
		}
	}
}
