package com.edson.appchat.dominio;

/**
 * 
 * @author Edson Reis
 *
 */
public class Usuario {

	private String apelido;
	private String email;
	private String senha;
	
	public Usuario() {
		super();
	}
	public Usuario(String apelido, String email, String senha) {
		super();
		this.apelido = apelido;
		this.email = email;
		this.senha = senha;
	}
	
	public String getApelido() {
		return apelido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}
	
}
