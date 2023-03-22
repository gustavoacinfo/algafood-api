package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.filter.VendasDiariasFilter;
import com.algaworks.algafood.domain.model.dto.VendaDiaria;
import com.algaworks.algafood.domain.service.VendaQueryService;

@RestController
@RequestMapping(path = "/estatisticas")
public class EstatisticasController {
	
	private VendaQueryService vendaQueryService;
	
	@GetMapping
	public List<VendaDiaria> consultarVendasDiarias(VendasDiariasFilter filtro){
		return vendaQueryService.consultarVendasDiarias(filtro);
	}

}
