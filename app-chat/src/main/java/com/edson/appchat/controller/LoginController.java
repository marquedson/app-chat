package com.edson.appchat.controller;

import java.util.HashMap;
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
import com.edson.appchat.service.UsuarioService;

@RestController
@RequestMapping("/api/chat")
public class LoginController extends AppController {
	
	@Inject
	private UsuarioService usuarioService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> efetuarLogin(@RequestBody LoginUsuario login, HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String mensagemSucesso = "";
		String mensagemErro = "";
		boolean isLoginValido = usuarioService.isLoginValido(login, getUsuariosCadastrados(request));
		if (!isLoginValido) {			
			mensagemSucesso = "Login ou Senha inválido!";
			map.put("mensagemErro", mensagemSucesso);
		} else {
			mensagemErro = "Login efetuado com sucesso!";
			map.put("mensagemSucesso", mensagemErro);
		}
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
