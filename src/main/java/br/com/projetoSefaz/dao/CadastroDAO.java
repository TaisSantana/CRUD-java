package br.com.projetoSefaz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.jdbc.PreparedStatement;
import br.com.projetoSefaz.factory.ConnectionFactory;
import br.com.projetoSefaz.model.Cadastro;


public class CadastroDAO {
	
	//tenta criar conexão com o bd
	private Connection con = ConnectionFactory.createConnection();
	
	public void cadastrar(Cadastro cadastro) {
		 
		try (PreparedStatement prsm = con.prepareStatement("SELECT email FROM usuario WHERE email=?")){
			
			//substitui interrogações
			prsm.setString(1,cadastro.getEmail());
			
			//executa comando sql no banco
			ResultSet rset = prsm.executeQuery();
			
			
		if(rset.next()){
			System.out.println("Email já cadastrado no sistema!!");
			
		}
		//se não, cadastra
		else {
			PreparedStatement prsm2 = con.prepareStatement("INSERT INTO usuario(nome, telefone, email, senha) VALUES (?,?,?,md5(?))");
			//substitui interrogações
			prsm2.setString(1,cadastro.getNome());
			prsm2.setString(2,cadastro.getTelefone());
			prsm2.setString(3,cadastro.getEmail());
			prsm2.setString(4,cadastro.getSenha());
			
			//executa comando sql no banco
			prsm2.execute();
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
		
	}

	public void alterar(Cadastro cadastro) {
		 
		try (PreparedStatement prsm = con.prepareStatement("UPDATE usuario SET nome=?, telefone=?, email=?, senha=md5(?) WHERE id=? ")){
			//substitui interrogações
			prsm.setString(1,cadastro.getNome());
			prsm.setString(2,cadastro.getTelefone());
			prsm.setString(3,cadastro.getEmail());
			prsm.setString(4,cadastro.getSenha());
			prsm.setInt(5,cadastro.getId());
			
			//executa comando sql no banco
			prsm.execute();
			
			System.out.println("Alteração realizada com sucesso!!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void salvar(Cadastro cad){
		Integer id =  cad.getId();
		if ( id != null & id != 0){
			alterar(cad);
		}else {
			cadastrar(cad);
		}
	}
	/**
	 * Realiza a exclusão do registro alvo
	 *  
	 * @return 
	 */
	public void excluir(Cadastro cadastro) {
		 
		try (PreparedStatement prsm = con.prepareStatement("DELETE FROM usuario WHERE email=?")){
			//substitui interrogações
			prsm.setString(1,cadastro.getEmail());
			
			//executa comando sql no banco
			prsm.execute();
			
			System.out.println("Excluido com sucesso!!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Realiza a busca de todos os registros da tabela usuário
	 *  
	 * @return Retorna uma lista de objetos Cadastro ,com todos os usuários cadastrados.
	 */
	
	public List<Cadastro> buscar(){
		
		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try(PreparedStatement prsm = con.prepareStatement("SELECT * FROM usuario")) {

			//Como o preparedStatement não retorna nada, então é necessário usar o ResultSet para recuperar os dados da consulta.
			ResultSet rset = prsm.executeQuery();
			
			//enqnt tiver dado p percorrer executa(posiciona o ponteiro no próximo registo(começa apontando p nenhum registro))
			while(rset.next()) {
				Cadastro cadastro = new Cadastro();
			
				//coloca em um objeto cadastro o que está em resultSet
				cadastro.setNome(rset.getString("nome"));
				//recupera telefone
				cadastro.setTelefone(rset.getString("telefone"));
				//recupera email
				cadastro.setEmail(rset.getString("email"));
				//recupera senha
				cadastro.setSenha(rset.getString("senha"));
				//adicionando dados do cadastro do usuario na lista
				cadastros.add(cadastro);}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cadastros;
		
	}
	
	public Cadastro buscarPorEmail(String email){
		
		Cadastro cadastro = null;
		
		try(PreparedStatement prsm = con.prepareStatement("SELECT * FROM usuario WHERE id = ?")) {
			prsm.setString(1, email);
			
			//Como o preparedStatement não retorna nada, então é necessário usar o ResultSet para recuperar os dados da consulta.
			ResultSet rset = prsm.executeQuery();
			
			//enqnt tiver dado p percorrer executa(posiciona o ponteiro no próximo registo(começa apontando p nenhum registro))
			if (rset.next()) {
				cadastro = new Cadastro();
			
				//coloca em um objeto cadastro o que está em resultSet
				cadastro.setNome(rset.getString("nome"));
				//recupera telefone
				cadastro.setTelefone(rset.getString("telefone"));
				//recupera email
				cadastro.setEmail(rset.getString("email"));
				//recupera senha
				cadastro.setSenha(rset.getString("senha"));
				//adicionando dados do cadastro do usuario na lista
				}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cadastro;
		
	}


	public Cadastro autenticar(Cadastro user) {
		try(PreparedStatement prsm = con.prepareStatement("SELECT * FROM usuario WHERE email=? AND senha=md5(?)")){
			prsm.setString(1,user.getEmail());
			prsm.setString(2,user.getSenha());
			
			ResultSet rset = prsm.executeQuery();
				
			//Se existir registro, loga
			if (rset.next()) {
				Cadastro cadastro = new Cadastro();
				//coloca em um objeto cadastro o que está em resultSet
				cadastro.setNome(rset.getString("nome"));
				//recupera telefone
				cadastro.setTelefone(rset.getString("telefone"));
				//recupera email
				cadastro.setEmail(rset.getString("email"));
				
				return cadastro;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
