package br.com.devpleno.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devpleno.cadastro.domain.Cliente;
import br.com.devpleno.cadastro.repository.ClienteRepository;
import br.com.devpleno.cadastro.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + " Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente save(Cliente cliente) {
		cliente.setId(null);
		return repo.save(cliente);
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Cliente update(Cliente cliente) {
		Cliente newCliente = findById(cliente.getId());
		updateData(cliente, newCliente);
		return repo.save(newCliente);
	}
	
	private void updateData(Cliente cliente, Cliente newCliente) {
		newCliente.setNome(cliente.getNome());
		newCliente.setEmail(cliente.getEmail());
	}
	
	

}
