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
		String mensagem = "";
		boolean isLoginValido = usuarioService.isLoginValido(login, getUsuariosCadastrados(request));
		if (!isLoginValido) {			
			mensagem = "Login ou Senha inválido!";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mensagem", mensagem);
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
