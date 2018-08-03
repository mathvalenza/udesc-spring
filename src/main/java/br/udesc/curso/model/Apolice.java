package br.udesc.curso.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.udesc.curso.enums.Cobertura;
import lombok.Data;

@Data
@Entity
public class Apolice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="clienteid", referencedColumnName="id")
	private Cliente cliente;
	
	@Embedded
	private Veiculo veiculo;
	
	@ElementCollection(targetClass=Cobertura.class)
	private Set<Cobertura> coberturas;
	
	private float preco;
	
	@Column(insertable=false)
	Date inicioVigencia;
	
	@Column(insertable=false)
	Date fimVigencia;
}
