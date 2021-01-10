package br.com.projetoSefaz.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	//caminho_do_banco/porta/nome_do_banco&zona de tempo&login&senhadobanco
	private static final String URL = "jdbc:mysql://localhost:3306/projeto_cadastro?serverTimezone=UTC&user=root&password=";
	
	
	//Conex�o com o banco de dados
	public static Connection createConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//cria conex�o com bd
			 Connection con = DriverManager.getConnection(URL);
			 return con; 
			
		} catch (SQLException erro){
			JOptionPane.showMessageDialog(null,erro.getMessage());
			throw new RuntimeException();
		}catch (ClassNotFoundException e) {
			throw new RuntimeException();
			}
		
	}
	
	
	//todo user so pode ter 1 conexao ativa

	public static void main(String[] args) throws Exception {
		//Recuperar conexao com sql
		Connection con = createConnection();
		
		//se j� houver conex�o(con!=null) anterior, ent�o fecha a nova conex�o para n�o sobrecarregar a mem�ria
		if (con !=null) {
			System.out.println("Conectado com sucesso!");
			con.close();
		}
	} 
}