package br.udesc.curso.service.proposta.calculation;

import br.udesc.curso.vo.PropostaVO;

public class TerceiroCalculation extends CoberturaCalculation {

	float calcularValor(PropostaVO proposta) {
		return 100;
	}

	float calcularPercentualVeiculo(PropostaVO proposta) {
		return 100;
	}
}
