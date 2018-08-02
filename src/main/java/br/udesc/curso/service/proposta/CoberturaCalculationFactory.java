package br.udesc.curso.service.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.service.proposta.calculation.CoberturaCalculation;
import br.udesc.curso.service.proposta.calculation.PerdaTotalCalculation;
import br.udesc.curso.service.proposta.calculation.VidroCalculation;

@Component
public class CoberturaCalculationFactory {

		@Autowired
		private PerdaTotalCalculation perdaTotalCalculation;
		
		@Autowired
		private VidroCalculation vidroCalculation;
		
		public CoberturaCalculation build(Cobertura cobertura) {
			switch (cobertura) {
			case PERDA_TOTAL:
				return perdaTotalCalculation;
			case VIDROS:
				return vidroCalculation;
			default:
				throw new IllegalArgumentException("Calculo para cobertura " + cobertura + " não implementado");
			}
		}
}
