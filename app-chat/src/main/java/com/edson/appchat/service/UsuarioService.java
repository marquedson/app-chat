package com.edson.appchat.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.edson.appchat.dominio.LoginUsuario;
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
		Predicate<Usuario> usuario = usu -> !usu.getApelido().equals(apelido);
		return usuariosCadastrados.stream().allMatch(usuario);
	}

	public boolean isLoginValido(LoginUsuario login, List<Usuario> usuariosCadastrados) throws Exception {
		for (Usuario usuario : usuariosCadastrados) {
			if (isEmailESenhaValido(login, usuario)) {
				return true; 
			}
		}
		return false;
	}

	private boolean isEmailESenhaValido(LoginUsuario login, Usuario usuario) {
		return login.getEmail().equals(usuario.getEmail()) && login.getSenha().equals(usuario.getSenha());
	}
}
