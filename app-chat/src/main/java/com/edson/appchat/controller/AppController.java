package com.edson.appchat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.edson.appchat.dominio.Usuario;

public class AppController {

	List<Usuario> usuariosCadastrados = new ArrayList<>();

	public List<Usuario> getUsuariosCadastrados(HttpServletRequest request) {
		return (List<Usuario>) request.getSession().getAttribute("usuarios");
	}

	public List<Usuario> getUsuariosOnline(HttpServletRequest request) {
		return (List<Usuario>) request.getSession().getAttribute("usuariosOnline");
	}

	public void setUsuariosCadastrados(List<Usuario> usuariosCadastrados) {
		this.usuariosCadastrados = usuariosCadastrados;
	}
}
