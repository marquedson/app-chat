package com.edson.appchat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edson.appchat.dominio.LoginUsuario;
import com.edson.appchat.dominio.Usuario;
import com.edson.appchat.service.UsuarioService;

@RestController
@RequestMapping("/api/chat")
public class LoginController extends AppController {
	
	@Inject
	private UsuarioService usuarioService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> efetuarLogin(@RequestBody LoginUsuario login, HttpServletRequest request) throws Exception {
		
		if (getUsuariosOnline(request) == null) {			
			List<Usuario> usuariosOnline = new ArrayList<>();
			request.getSession().setAttribute("usuariosOnline", usuariosOnline);
		}
		
		if (getUsuariosCadastrados(request) == null) {
			List<Usuario> usuarios = new ArrayList<>();
			request.getSession().setAttribute("usuarios", usuarios);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		String mensagemSucesso = "";
		String mensagemErro = "";
		Usuario usuario = usuarioService.isLoginValido(login, getUsuariosCadastrados(request));
		if (usuario == null) {			
			mensagemErro = "Login ou Senha inválido!";
			map.put("mensagemErro", mensagemErro);
		} else {
			getUsuariosOnline(request).add(usuario);
			mensagemSucesso = "Login efetuado com sucesso!";
			map.put("mensagemSucesso", mensagemSucesso);
		}
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuarios-online", method = RequestMethod.GET)
	public ResponseEntity<?> init(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usuariosOnline", getUsuariosOnline(request));
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
