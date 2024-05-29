package br.edu.ufcg.computacao.complementaccc.TestesAtividade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Atividade.Estagio;

public class EstagioTeste {
    @Test
    void construtorTest() {
        Estagio estagio = new Estagio("Estágio", "P2", 300);
    }

    @Test
    void construtorDisciplinaNullTest() {
        try {
            Estagio estagio = new Estagio("Estágio", null, 300);
        } catch (NullPointerException npe) {
            assertEquals("Disciplina nula", npe.getMessage());
        }
    }

    @Test
    void construtorDisciplinaBlankTest() {
        try {
            Estagio estagio = new Estagio("Estágio", "", 300);
        } catch (IllegalArgumentException npe) {
            assertEquals("Disciplina inválida", npe.getMessage());
        }
    }

    @Test
    void construtorHorasNegativasTest() {
        try {
            Estagio estagio = new Estagio("Estágio", "P2", -2);
        } catch (IllegalArgumentException npe) {
            assertEquals("Número de horas inválido", npe.getMessage());
        }
    }

    @Test
    void getCreditosTest() {
        Estagio estagio = new Estagio("Estágio", "P2", 300);
        Estagio estagio2 = new Estagio("Estágio", "P2", 333);
        estagio.getCreditos();
        assertEquals(5.0, estagio.getCreditos());
        assertEquals(5.55, estagio2.getCreditos());        
    }

    @Test
    void toStringTest() {
        Estagio estagio = new Estagio("Estágio", "P2", 300);
        estagio.alteraDescricaoAtividade("Estágio não obrigatório");
        assertEquals("Estágio. Estágio não obrigatório\nCréditos acumulados: 5.0", estagio.toString());
    }

}
