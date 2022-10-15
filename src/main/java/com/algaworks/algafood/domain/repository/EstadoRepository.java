package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Estado;

@RestController
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
