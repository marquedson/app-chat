package com.edson.appchat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ResponseEntity<?> init(HttpServletRequest request) throws Exception {
		
		if (getUsuariosCadastrados(request) == null) {
			List<Usuario> usuarios = new ArrayList<>();
			request.getSession().setAttribute("usuarios", usuarios);
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario, HttpServletRequest request) throws Exception {
		
		this.usuarioService.salvar(usuario, getUsuariosCadastrados(request));
		
		String mensagemSucesso = "Usuário cadastrado com sucesso!";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mensagemSucesso", mensagemSucesso);
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/validar-apelido/{apelido}", method = RequestMethod.POST)
	public ResponseEntity<?> validarApelido(@PathVariable("apelido") String apelido, HttpServletRequest request) throws Exception {
		
		String mensagemErro = "";
		boolean isApelidoValido = this.usuarioService.validarApelido(apelido, getUsuariosCadastrados(request));
		if(!isApelidoValido){
			mensagemErro = "Apelido em uso por outro usuário";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mensagemErro", mensagemErro);
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
