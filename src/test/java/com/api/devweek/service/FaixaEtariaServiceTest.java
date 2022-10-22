package com.api.devweek.service;

import com.api.devweek.entity.FaixaEtaria;
import com.api.devweek.exception.ElementNotFoundException;
import com.api.devweek.repository.FaixaEtariaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FaixaEtariaServiceTest {

	private static final Long ID = 0L;

	@InjectMocks
	private FaixaEtariaService faixaEtariaService;
	
	@Mock
	private FaixaEtariaRepository faixaEtariaRepository;

	@Mock
	private List<FaixaEtaria> faixaEtariaList;

	private FaixaEtaria faixaEtaria;

	private Optional<FaixaEtaria> faixaEtariaOptional;


	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startFaixaEtaria();
	}

	@Test
	void deveRetornarListaDeFaixaEtaria() {
		
		when(faixaEtariaRepository.findAll()).thenReturn(faixaEtariaList);

		assertNotNull(faixaEtariaService.findAllFaixaEtaria());

		assertEquals(faixaEtariaList, faixaEtariaService.findAllFaixaEtaria());

	}

	@Test
	void deveRetornarFaixaEtariaPorId() {

		when(faixaEtariaRepository.findById(anyLong())).thenReturn(faixaEtariaOptional);

		assertNotNull(faixaEtariaService.findFaixaEtariaById(faixaEtaria.getId()));
		assertEquals(faixaEtaria.getClass(), faixaEtariaService.findFaixaEtariaById(faixaEtaria.getId()).getClass());

	}

	@Test
	void deveLancarExceptionQuandoNaoEncontrarPorId() {

		when(faixaEtariaRepository.findById(ID)).thenReturn(Optional.empty());

		assertThrows(ElementNotFoundException.class,
				() -> faixaEtariaService.findFaixaEtariaById(ID),
				String.format("Não foi possível encontrar o registro %d", ID));

	}

	private void startFaixaEtaria() {
		faixaEtaria = new FaixaEtaria(1L, 15L, 30L,"entre 15 e 30 anos");
		faixaEtariaOptional = Optional
				.of(new FaixaEtaria(1L, 15L, 30L,"entre 15 e 30 anos"));
	}

}
