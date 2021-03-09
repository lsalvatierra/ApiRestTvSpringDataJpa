package com.qbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qbo.model.Cliente;
import com.qbo.service.ClienteService;

@RestController
@RequestMapping("apiqbo/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	
	@GetMapping("/dni")
	public ResponseEntity<Cliente> listarClientePorDocumento
			(@RequestParam("documento") String documento){
		return new ResponseEntity<>(
				clienteService.obtenerClientePorDocumento(documento),
				HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Cliente>> buscarClientePorNombre
			(@RequestParam("nombre") String nombre){
		return new ResponseEntity<>(
				clienteService.buscarClientesPorNombre(nombre),
				HttpStatus.OK);
	}
	
}
