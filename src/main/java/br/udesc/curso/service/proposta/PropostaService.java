package br.udesc.curso.service.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.model.Apolice;
import br.udesc.curso.model.Cliente;
import br.udesc.curso.repository.ApoliceRepository;
import br.udesc.curso.repository.ClienteRepository;
import br.udesc.curso.service.proposta.calculation.CoberturaCalculation;
import br.udesc.curso.vo.PropostaVO;

@Service
public class PropostaService {
	
	@Autowired
	private CoberturaCalculationFactory coberturaCalculationFactory;
	
	@Autowired
	ApoliceRepository apoliceRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public float getValorCobertura(PropostaVO propostaVO) {
		float valorTotal = 0;
		CoberturaCalculation coberturaCalculation = null;
		
		for (Cobertura cobertura : propostaVO.getCoberturas()) {
			coberturaCalculation = coberturaCalculationFactory.build(cobertura);
			valorTotal += coberturaCalculation.calcular(propostaVO);
		}
		
		Apolice apolice = new Apolice();
		
		Cliente cliente = clienteRepository.findByCpf(propostaVO.getCliente().getCpf());
		
		apolice.setCliente(cliente);
		apolice.setCoberturas(propostaVO.getCoberturas());
		apolice.setVeiculo(propostaVO.getVeiculo());
		apolice.setPreco(valorTotal);
		
		apoliceRepository.saveAndFlush(apolice);
		
		return valorTotal;
	}
}
