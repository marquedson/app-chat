package com.edson.appchat.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<?> getIdentificacao(HttpServletRequest request) throws Exception {
		
		String mensagem = "Login efetuado com sucesso!";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mensagem", mensagem);
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
