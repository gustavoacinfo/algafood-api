package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.ProdutoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.ProdutoRepository;

@Service
public class CadastroProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@Transactional
	public Produto salvar(Produto produto, Long restauranteId) {
		
		Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);
		
		produto.setRestaurante(restaurante);
		
		return produtoRepository.save(produto);
	}
	
	public Produto buscarOuFalhar(Long produtoId, Long restauranteId) {
		return produtoRepository.findByIdAndRestauranteId(produtoId, restauranteId)
				.orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId, restauranteId));
	}

}
