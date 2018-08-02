package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import org.junit.Test;

import br.udesc.curso.model.Cliente;
import br.udesc.curso.model.Veiculo;
import br.udesc.curso.vo.PropostaVO;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PerdaTotalCalculationTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testVidaLoka() {
		Cliente cliente = new Cliente();
		cliente.setNascimento(new Date(2000-1900, 10, 1));
		Veiculo veiculo = new Veiculo();
		veiculo.setAnoFabricacao(1995);
		veiculo.setImportado(false);
		veiculo.setBlindado(false);
		veiculo.setValor(10000);
		PropostaVO proposta = new PropostaVO();
		proposta.setCliente(cliente);
		proposta.setVeiculo(veiculo);
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		
		float valor = calculation.calcular(proposta);
		
		Assert.assertEquals(501, valor, 0);
	}
	
	@Test
	public void testTiozao() {
		Cliente cliente = new Cliente();
		cliente.setNascimento(new Date(1980, 10, 10));
		Veiculo veiculo = new Veiculo();
		veiculo.setAnoFabricacao(2010);
		veiculo.setImportado(false);
		veiculo.setBlindado(true);
		veiculo.setValor(18000);
		
		PropostaVO proposta = new PropostaVO();
		proposta.setCliente(cliente);
		proposta.setVeiculo(veiculo);
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		
		float valor = calculation.calcular(proposta);
		
		Assert.assertEquals(500, valor, 0);
	}
	
	@Test
	public void testVovo() {
		Cliente cliente = new Cliente();
		cliente.setNascimento(new Date(1940, 10, 10));
		Veiculo veiculo = new Veiculo();
		veiculo.setAnoFabricacao(2018);
		veiculo.setImportado(true);
		veiculo.setBlindado(false);
		veiculo.setValor(65000);
		
		PropostaVO proposta = new PropostaVO();
		proposta.setCliente(cliente);
		proposta.setVeiculo(veiculo);
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		
		float valor = calculation.calcular(proposta);
		
		Assert.assertEquals(1500, valor, 0);
	}
}
