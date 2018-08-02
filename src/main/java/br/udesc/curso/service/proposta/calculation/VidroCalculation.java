package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import br.udesc.curso.model.Veiculo;
import br.udesc.curso.vo.PropostaVO;

public class VidroCalculation extends CoberturaCalculation {

	float calcularValor(PropostaVO proposta) {
		return (float) (0.5);
	}

	float calcularPercentualVeiculo(PropostaVO proposta) {
		Veiculo veiculo = proposta.getVeiculo();		
		int idadeVeiculo = (new Date()).getYear() - veiculo.getAnoFabricacao();
		double percentual = 0.0075;
		
		if (idadeVeiculo >= 3 && idadeVeiculo < 5) {
			percentual = 0.0055;
		} else if(idadeVeiculo < 10) {
			percentual = 0.0025;
		}
		
		if (veiculo.isBlindado()) {
			if (veiculo.isImportado()) {
				percentual += 0.0075;
			} else {
				percentual += 0.005;
			}
		} else {
			if (veiculo.isImportado()) {
				percentual += 0.0065;
			}
		}
		
		return veiculo.getValor() + (float) (veiculo.getValor() * percentual);
	}
}
