package com.algaworks.algafood.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Produto;

@Repository
public interface ProdutoRepository extends CustomJpaRepository<Produto, Long> {
	
	Optional<Produto> findByIdAndRestauranteId(Long produtoId, Long restauranteId);
	
}
