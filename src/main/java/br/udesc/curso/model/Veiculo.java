package br.udesc.curso.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Veiculo {
	
	private int anoFabricacao;
	@Column(length=8)
	private String placa;
	private float valor;
	private boolean blindado;
	private boolean importado;
}
