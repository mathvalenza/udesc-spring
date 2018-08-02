package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import br.udesc.curso.model.Cliente;
import br.udesc.curso.vo.PropostaVO;

public class PerdaTotalCalculation extends CoberturaCalculation {
	
	float calcularValor(PropostaVO proposta) {
		return (float) 0;
	}

	float calcularPercentualVeiculo(PropostaVO proposta) {
		Cliente cliente = proposta.getCliente();
		@SuppressWarnings("deprecation")
		int idade = (new Date()).getYear() - cliente.getNascimento().getYear();
		double percentual = 0.01;
		
		if (idade < 24) {
			percentual = 0.05;
		} else if (idade < 40) {
			percentual = 0.03;
		}
		
		return (float) percentual;
	}
}
