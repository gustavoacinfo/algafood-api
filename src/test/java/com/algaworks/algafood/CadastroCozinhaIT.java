package com.algaworks.algafood;


import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@SpringBootTest
class CadastroCozinhaIT {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	
	@Test
	public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
		//cenario
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
		//açao
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		
		//validacao
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}
	
	@Test
	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		
		ConstraintViolationException erroEsperado =
			      Assertions.assertThrows(ConstraintViolationException.class, () -> {
			         cadastroCozinha.salvar(novaCozinha);
			      });
			   
			   assertThat(erroEsperado).isNotNull();		
		
	}
	
	@Test
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
		
		EntidadeEmUsoException erroEsperado =
			      Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
			         cadastroCozinha.excluir(1L);
			      });
			   
			   assertThat(erroEsperado).isNotNull();
		
		
	}
	
	@Test
	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
		
		CozinhaNaoEncontradaException erroEsperado =
			      Assertions.assertThrows(CozinhaNaoEncontradaException.class, () -> {
			         cadastroCozinha.excluir(100L);
			      });
			   
			   assertThat(erroEsperado).isNotNull();
	}
	

}
