package com.edson.appchat.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edson.appchat.dominio.Usuario;
import com.edson.appchat.service.UsuarioService;

@RestController
@RequestMapping("/api/chat")
public class CadastroController extends AppController {

	@Inject
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario, HttpServletRequest request) throws Exception {
		
		this.usuarioService.salvar(usuario, getUsuariosCadastrados());
		
		String mensagem = "Usuário cadastrado com sucesso!";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mensagem", mensagem);
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/validar-apelido/{apelido}", method = RequestMethod.POST)
	public ResponseEntity<?> validarApelido(@PathVariable("apelido") String apelido, HttpServletRequest request) throws Exception {
		
		String mensagem = "";
		boolean isApelidoValido = this.usuarioService.validarApelido(apelido, getUsuariosCadastrados());
		if(!isApelidoValido){
			mensagem = "Apelido em uso por outro usuário";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mensagem", mensagem);
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
