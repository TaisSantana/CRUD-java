package br.com.projetoSefaz.aplicacao;

import java.util.List;

import br.com.projetoSefaz.dao.CadastroDAO;
import br.com.projetoSefaz.model.Cadastro;



public class Main {
	
	public static void main(String[] args) {
		//testeListar();
		//testeCadastro();
		//testeExcluir();
		//testeBuscapEmail();
		//testeup();
	}
	public static void testeup(){
		CadastroDAO usuDAO = new CadastroDAO();
		Cadastro user = new Cadastro();
		user.setId(29);
		user.setNome("pedro henrique");
		user.setTelefone("81222334321");
		user.setEmail("pedro1234@hotmail.com");
		user.setSenha("1234");
		usuDAO.salvar(user);
		
	}
	public static void testeCadastro(){
		CadastroDAO usuDAO = new CadastroDAO();
		
		Cadastro user = new Cadastro();
	
		user.setNome("pedro joaquim");
		user.setTelefone("81222334321");
		user.setEmail("pedro123@hotmail.com");
		user.setSenha("1234");
		
	
		usuDAO.cadastrar(user);
		
	}
	public static void testeBuscapEmail(){
		CadastroDAO usuDAO = new CadastroDAO();
		Cadastro cad = usuDAO.buscarPorEmail("j@hotmail.com");
		System.out.println(cad);
		
	}
	public static void testeExcluir(){
		Cadastro user = new Cadastro();
		user.setNome("pedro joaquim");
		user.setTelefone("81222334321");
		user.setEmail("pedro123@hotmail.com");
		user.setSenha("1234");
		CadastroDAO usuDAO = new CadastroDAO();
		usuDAO.excluir(user);
		
	}
	public static void testeListar(){
		
		CadastroDAO usuDAO = new CadastroDAO();
		List<Cadastro> list = usuDAO .buscar();
		for (Cadastro c: list) {
			System.out.println(c.getEmail());
		}
	
	}
}
