package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Ta na Hora");
		restaurante1.setTaxaFrete(BigDecimal.valueOf(12.5d));
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("UnaGrill");
		restaurante2.setTaxaFrete(BigDecimal.valueOf(9.0d));
		
		restaurante1 = restauranteRepository.adicionar(restaurante1);
		restaurante2 = restauranteRepository.adicionar(restaurante2);
		
		System.out.printf("%d - %s - %f \n", restaurante1.getId(), restaurante1.getNome(), restaurante1.getTaxaFrete());
		System.out.printf("%d - %s - %f \n", restaurante2.getId(), restaurante2.getNome(), restaurante2.getTaxaFrete());
	}

}