package org.itstep.javaee.modelo;

public class Usuario {

	private String name;
	private String cpf;
	private String email;
	private String endereco;
	

	public Usuario(String name, String cpf, String email, String endereco) {
		super();
		name = null;
		cpf = null;
		email=null;
		endereco=null;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
