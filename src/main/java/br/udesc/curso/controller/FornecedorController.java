package br.udesc.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.model.Fornecedor;
import br.udesc.curso.repository.FornecedorRepository;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository repository;
	
	@PostMapping("/salvar")
	public Fornecedor salvar(@RequestBody Fornecedor fornecedor) {
		return repository.saveAndFlush(fornecedor);
	}
	
	@GetMapping("encontrar/{id}")
	public Fornecedor find(@PathVariable("id") long id) {
		return repository.findById(id).get();
	}
	
	@GetMapping("listar")
	public List<Fornecedor> listar() {
		return repository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(long id) {
		repository.deleteById(id);
	}
}
