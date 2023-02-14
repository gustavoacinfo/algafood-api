package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.assembler.ProdutoModelAssembler;
import com.algaworks.algafood.api.model.CozinhaModel;
import com.algaworks.algafood.api.model.ProdutoModel;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.service.CadastroProdutoService;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/produtos")
public class ProdutoController {
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@Autowired
	private ProdutoModelAssembler produtoModelAssembler;
	
	@Autowired
	private CadastroProdutoService cadastroProduto;
	
	@GetMapping
	public List<ProdutoModel> listar(@PathVariable Long restauranteId){
		Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);
		
		return produtoModelAssembler.toCollectionModel(restaurante.getProdutos());
	}
	
	@GetMapping("/{produtoId}")
	public ProdutoModel buscar(@PathVariable Long produtoId, @PathVariable Long restauranteId) {
		Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);
		
		Produto produto = cadastroProduto.buscarOuFalhar(produtoId, restaurante.getId());

		return produtoModelAssembler.toModel(produto);
	}

}
