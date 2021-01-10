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
		//tentar achar sessão, mas se não encontrar, não cria outra.
		HttpSession session = req.getSession(false);
		
		//se houver sessão, invalida ela
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
		
		//Coloca dados em objeto usuário
		Cadastro cad = new Cadastro();		
		cad.setEmail(email);
		cad.setSenha(senha);
		
		//consulta se existe as credenciais no banco
		CadastroDAO cadDAO = new CadastroDAO();
		Cadastro usuAut = cadDAO.autenticar(cad);
		
		//se encontrou user no banco(não retornou nulo, então executa)
		if (usuAut != null) {
			
			//recupera sessão já criada ou cria sessão nova.
			HttpSession session = req.getSession();
			
			session.setAttribute("usu", usuAut);
			
			
			req.getRequestDispatcher("TelaInicial.jsp").forward(req,resp); 
		
		//se não encontrou, redireciona user para tela de login(principal)
		}else {
			JOptionPane.showMessageDialog(null,  "Email ou Senha está(ão) incorreto(s)");
			resp.sendRedirect("index.jsp");
		}
	}
}
