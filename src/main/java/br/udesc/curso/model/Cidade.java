package br.udesc.curso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cidade {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;	
}
