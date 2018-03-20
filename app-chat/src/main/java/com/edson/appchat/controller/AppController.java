package com.edson.appchat.controller;

import java.util.ArrayList;
import java.util.List;

import com.edson.appchat.dominio.Usuario;

public class AppController {

	List<Usuario> usuariosCadastrados = new ArrayList<>();

	public List<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}

	public void setUsuariosCadastrados(List<Usuario> usuariosCadastrados) {
		this.usuariosCadastrados = usuariosCadastrados;
	}
}
