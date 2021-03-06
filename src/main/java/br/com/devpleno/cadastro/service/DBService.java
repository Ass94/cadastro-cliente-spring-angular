package br.com.devpleno.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devpleno.cadastro.domain.Cliente;
import br.com.devpleno.cadastro.repository.ClienteRepository;

@Service
public class DBService {
	
	@Autowired
	private ClienteRepository repo;
	
	public void inicializateDataBase() {
		Cliente cliente = new Cliente(null, "Alex De Souza Silva", "alex94tu@gmail.com");
		repo.save(cliente);
		
	}

}
