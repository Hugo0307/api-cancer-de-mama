package com.api.devweek.service;

import com.api.devweek.entity.IncidenciaExame;
import com.api.devweek.exception.ElementNotFoundException;
import com.api.devweek.exception.ListNoContentException;
import com.api.devweek.repository.IncidenciaExamesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IncidenciaExameServiceTest {

    private static final Long ID = 0L;
    @InjectMocks
    IncidenciaExameService incidenciaExameService;

    @Mock
    IncidenciaExamesRepository incidenciaExamesRepository;

    @Mock
    private List<IncidenciaExame> incidenciaExameList;

    private IncidenciaExame incidenciaExame;

    private Optional<IncidenciaExame> incidenciaExameOptional;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startIncidenciaExame();
    }

    @Test
    void deveRetornarListaDeIncidenciaExame() {

        when(incidenciaExamesRepository.findAll()).thenReturn(incidenciaExameList);

        assertNotNull(incidenciaExameService.findAllIncidencia());

        assertEquals(incidenciaExameList, incidenciaExameService.findAllIncidencia());

    }

    @Test
    void deveLancarExceptionSeListaVaziaDeIncidenciaExame() {

        assertThrows(ListNoContentException.class, () -> incidenciaExameService.findAllIncidencia());

    }

    @Test
    void deveRetornarIncidenciaExamePorId() {

        when(incidenciaExamesRepository.findById(anyLong())).thenReturn(incidenciaExameOptional);

        assertNotNull(incidenciaExameService.findIncidenciaById(incidenciaExame.getId()));
        assertEquals(incidenciaExame.getClass(), incidenciaExameService.findIncidenciaById(incidenciaExame.getId()).getClass());

    }

    @Test
    void deveLancarExceptionQuandoNaoEncontrarPorId() {

        assertThrows(ElementNotFoundException.class, () -> incidenciaExameService.findIncidenciaById(ID));

    }

    private void startIncidenciaExame() {
        incidenciaExame = new IncidenciaExame(1L, 1, 3, 30L,1000);
        incidenciaExameOptional = Optional
                .of(new IncidenciaExame(1L, 1, 3, 30L,1000));
    }

}