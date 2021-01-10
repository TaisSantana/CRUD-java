package br.com.projetoSefaz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoSefaz.dao.CadastroDAO;
import br.com.projetoSefaz.model.Cadastro;
import br.com.projetoSefaz.model.Telefone;
//http://localhost:8080/projCadastro/usucontroller.do
@WebServlet("/usucontroller.do")
public class UserController extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("iniciou..");
	}
	
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	 		throws ServletException, IOException {
		String acao = req.getParameter("acao");
	 	CadastroDAO cadDAO = new CadastroDAO();
	 	//se a ação for excluir alguém
	 	 if(acao.equals("exc")) {
	 		 String email = req.getParameter("email");
	 		 Cadastro cad = new Cadastro();
	 		 if(email != null) {
	 			 cad.setEmail(email);
	 		 }
	 		
	 		 cadDAO.excluir(cad);
	 		 
	 		 resp.sendRedirect("usucontroller.do?acao=lis");
	 		
	 	//implementa lista de todos usuário no Area privada
	 	 }else if (acao.equals("lis")){
	 		 
	 		 
	 		 List<Cadastro> lista = cadDAO.buscar();
	 		 
	 		 //"(chave,valor)" no .jsp precisa ter a chave "list" para obter os dados de lista
	 		 req.setAttribute("list",lista);
	 		 
	 		 //encaminhamento de um servlet para outro(.jsp)
	 		 RequestDispatcher dispatcher =  req.getRequestDispatcher("WEB-INF/AreaPrivada.jsp");
	 		 dispatcher.forward(req,resp);
	 		 
	 	 }else if (acao.equals("alt")){
	 		 String email = req.getParameter("email");
	 		 Cadastro cad = cadDAO.buscarPorEmail(email);
	 		 req.setAttribute("cad",cad);
	 		req.getRequestDispatcher("editar.jsp").forward(req,resp);
	 		 
	 	 }
	 			 


	 }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String nome= req.getParameter("nome");
		String telefone= req.getParameter("telefone");
		String email= req.getParameter("email");
		String senha= req.getParameter("senha");
		 
		Cadastro cad = new Cadastro();
		cad.setNome(nome);
		cad.setTelefone(telefone);
		cad.setEmail(email);
		cad.setSenha(senha);
		
		CadastroDAO cadDAO = new CadastroDAO();
		cadDAO.salvar(cad);
		
		
		req.getRequestDispatcher("index.jsp").forward(req,resp);
	}
	

}
