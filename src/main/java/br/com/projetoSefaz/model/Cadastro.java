package br.com.projetoSefaz.model;

public class Cadastro {
	
	private int id;
	private String nome;
	private String telefone;
	private String email;
	private String senha;
	
	@Override
	public String toString() {
		return "Cadastro [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", senha=" + senha + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
