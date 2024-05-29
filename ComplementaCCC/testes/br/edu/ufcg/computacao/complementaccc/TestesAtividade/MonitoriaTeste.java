package br.edu.ufcg.computacao.complementaccc.TestesAtividade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Atividade.Monitoria;

public class MonitoriaTeste {
    @Test
    void construtorTest() {
        Monitoria mon = new Monitoria("Monitoria", 2, "P2");
    }

    @Test
    void construtorUnidadeNegativaTest() {
        try {
            Monitoria mon = new Monitoria("Monitoria", -1, "P2");
        } catch (IllegalArgumentException iae) {
            assertEquals("Unidade Acumulada inválida!", iae.getMessage());
        }
    }

    @Test
    void construtorDisciplinaNullTest() {
        try {
            Monitoria mon = new Monitoria("Monitoria", 1, null);
        } catch (NullPointerException iae) {
            assertEquals("Disciplina nula", iae.getMessage());
        }
    }

    @Test
    void construtorDisciplinaBlankTest() {
        try {
            Monitoria mon = new Monitoria("Monitoria", 1, " ");
        } catch (IllegalArgumentException iae) {
            assertEquals("Disciplina inválida", iae.getMessage());
        }
    }

    @Test
    void getCreditosTest() {
        Monitoria mon = new Monitoria("Monitoria", 2, "P2");
        assertEquals(8.0, mon.getCreditos());
    }

    @Test
    void getCreditosMaiorQueMaxTest() {
        Monitoria mon = new Monitoria("Monitoria", 9, "P2");
        assertEquals(16.0, mon.getCreditos());
    }

    @Test
    void toStringTest() {
        Monitoria mon = new Monitoria("Monitoria", 9, "P2");
        assertEquals("Monitoria. \nCréditos acumulados: 16.0", mon.toString());
    }
}
