package com.qbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.qbo.model.Cliente;
import com.qbo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente obtenerClientePorDocumento(String documento){
		return clienteRepository.obtenerClientePorDocumento(documento);
	}

	public List<Cliente> buscarClientesPorNombre(String nombre){
		/*return clienteRepository.buscarClientePorNombreJPQL(
				nombre, Sort.by("idcliente"));
		return clienteRepository.buscarClientePorNombreNativeQuery(
				nombre);*/
		return clienteRepository.buscarClientePorNombreJPQL(
				nombre);
		
	}
	
	
}
