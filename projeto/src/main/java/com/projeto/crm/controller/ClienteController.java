package com.projeto.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.crm.model.Cliente;
import com.projeto.crm.repository.ClienteRepository;

@RestController //classe que recebe requisições
@RequestMapping("/clientes") //iniciar na hora da requisição
@CrossOrigin(origins="*")//todos dominios
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping //traz o metodo na requisição 
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	                       
	@PostMapping             //converter JSON converte para tipo java
	@ResponseStatus(HttpStatus.CREATED) 
	public Cliente adicionar(@RequestBody Cliente cliente) {
	    return clienteRepository.save(cliente);
	
	}
	
	@DeleteMapping   
	public void deleteCliente(@RequestBody Cliente cliente) {
	     clienteRepository.delete(cliente);
	
	}
	@PutMapping   
	public Cliente atualizarCliente(@RequestBody Cliente cliente) {
	     return clienteRepository.save(cliente);
	
	}

}
