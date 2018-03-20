package com.edson.appchat.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.edson.appchat.dominio.Usuario;

@Service
public class UsuarioService {

	public void salvar(Usuario usuario, List<Usuario> usuarios) {
		usuarios.add(usuario);
	}

	/**
	 * Validar se o apelido a ser cadastrado já existe. 
	 * @param apelido
	 * @param usuariosCadastrados
	 * @return
	 */
	public boolean validarApelido(String apelido, List<Usuario> usuariosCadastrados) {
		Predicate<Usuario> usuario = e -> !e.getApelido().equals(apelido);
		return usuariosCadastrados.stream().allMatch(usuario);
	}
}
