package br.edu.ufcg.computacao.complementaccc.TestesAtividade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Atividade.PesquisaExtensao;

public class PesquisaExtensaoTeste {
    @Test
    void construtorTest() {
        PesquisaExtensao pe = new PesquisaExtensao("Pesquisa e Extensão", 6, "P2");
    }

    @Test
    void construtorUnidadeNegativaTest() {
        try {
            PesquisaExtensao pe = new PesquisaExtensao("Pesquisa e Extensão", -6, "P2");
        } catch (IllegalArgumentException iae) {
            assertEquals("Unidade Acumulada inválida!", iae.getMessage());
        }
    }

    @Test
    void construtorDisciplinaNullTest() {
        try {
            PesquisaExtensao pe = new PesquisaExtensao("Pesquisa e Extensão", 6, null);
        } catch (NullPointerException iae) {
            assertEquals("Disciplina nula", iae.getMessage());
        }
    }

    @Test
    void construtorDisciplinaBlankTest() {
        try {
            PesquisaExtensao pe = new PesquisaExtensao("Pesquisa e Extensão", 6, "");
        } catch (IllegalArgumentException iae) {
            assertEquals("Disciplina inválida", iae.getMessage());
        }
    }

    @Test
    void getCreditosTest() {
        PesquisaExtensao pe = new PesquisaExtensao("Pesquisa e Extensão", 6, "P2");
        assertEquals(5.0, pe.getCreditos());
    }

    @Test
    void getCreditosMaiorQueMaxTest() {
        PesquisaExtensao pe = new PesquisaExtensao("Pesquisa e Extensão", 24, "P2");
        assertEquals(18.0, pe.getCreditos());
    }

    @Test
    void toStringTest() {
        PesquisaExtensao pe = new PesquisaExtensao("Pesquisa e Extensão", 12, "P2");
        assertEquals("Pesquisa e Extensão. \nCréditos acumulados: 10.0", pe.toString());
    }
}
