package br.udesc.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.service.proposta.PropostaService;
import br.udesc.curso.vo.PropostaVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("proposta")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropostaController {
	
	@Autowired
	PropostaService propostaService;
	
	@PostMapping("/orcamento")
	public float getOrcamento(@RequestBody PropostaVO propostaVO) {		
		return propostaService.getValorCobertura(propostaVO);
	}
}
