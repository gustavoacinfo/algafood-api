package com.algaworks.algafood.infrastructure.service.report;

import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.filter.VendasDiariasFilter;
import com.algaworks.algafood.domain.service.VendaReportService;

@Service
public class PdfVendasReportService implements VendaReportService{

	@Override
	public byte[] emitirVendasDiarias(VendasDiariasFilter filtro, String timeOffset) {
		return null;
	}

	
}
