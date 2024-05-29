package br.edu.ufcg.computacao.complementaccc.TestesAtividade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Atividade.PesquisaExtensao;
import br.edu.ufcg.computacao.complementaccc.Atividade.Publicacao;

public class PublicacaoTeste {
    @Test
    void construtorTest() {
        Publicacao pu = new Publicacao("Publicação", "Paradigmas de POO", "123", "Periódico qualis a1");
    }

    @Test
    void construtorTituloNull() {
        try{ 
            Publicacao pu = new Publicacao("Publicação", null, "123", "Periódico qualis a1");
        } catch (NullPointerException npe) {
            assertEquals("TÍTULO NULO", npe.getMessage());
        }
    }

    @Test
    void construtorTituloBlankTest() {
        try{ 
            Publicacao pu = new Publicacao("Publicação", "", "123", "Periódico qualis a1");
        } catch (IllegalArgumentException iae) {
            assertEquals("TÍTULO INVÁLIDO", iae.getMessage());
        }
    }

    @Test
    void construtorDoiNull() {
        try{ 
            Publicacao pu = new Publicacao("Publicação", "Paradigmas de POO", null, "Periódico qualis a1");
        } catch (NullPointerException npe) {
            assertEquals("DOI NULO", npe.getMessage());
        }
    }

    @Test
    void construtorDoiBlankTest() {
        try{ 
            Publicacao pu = new Publicacao("Publicação", "Paradigmas de POO", "", "Periódico qualis a1");
        } catch (IllegalArgumentException iae) {
            assertEquals("DOI INVÁLIDO", iae.getMessage());
        }
    }

    @Test
    void construtorQualisNull() {
        try{ 
            Publicacao pu = new Publicacao("Publicação", "Paradigmas de POO", "123", null);
        } catch (NullPointerException npe) {
            assertEquals("QUALIS NULO", npe.getMessage());
        }
    }

    @Test
    void construtorQualisBlankTest() {
        try{ 
            Publicacao pu = new Publicacao("Publicação", "Paradigmas de POO", "123", "");
        } catch (IllegalArgumentException iae) {
            assertEquals("QUALIS INVÁLIDO", iae.getMessage());
        }
    }

    @Test
    void getCreditos4Test() {
        Publicacao pu = new Publicacao("Publicação", "Paradigmas de POO", "123", "Periódico qualis a1");
        Publicacao pu2 = new Publicacao("Publicação", "Paradigmas de POO", "123", "Periódico qualis a2");
        assertEquals(4,pu.getCreditos());
        assertEquals(4,pu2.getCreditos());
    }

    @Test
    void getCreditos3Test() {
        Publicacao pu = new Publicacao("Publicação", "Paradigmas de POO", "123", "Periódico qualis a3");
        Publicacao pu2 = new Publicacao("Publicação", "Paradigmas de POO", "123", "Conferência qualis a1");
        Publicacao pu3 = new Publicacao("Publicação", "Paradigmas de POO", "123", "Conferência qualis a2");
        assertEquals(3,pu.getCreditos());
        assertEquals(3,pu2.getCreditos());
        assertEquals(3,pu3.getCreditos());
    }

    @Test
    void getCreditos2Test() {
        Publicacao pu = new Publicacao("Publicação", "Paradigmas de POO", "123", "Conferência qualis a3");
        assertEquals(2,pu.getCreditos());
    }

    @Test
    void getCreditos1Test() {
        Publicacao pu = new Publicacao("Publicação", "Paradigmas de POO", "123", "Conferência qualis a4");
        Publicacao pu2 = new Publicacao("Publicação", "Paradigmas de POO", "123", "Conferência qualis b1");
        Publicacao pu3 = new Publicacao("Publicação", "Paradigmas de POO", "123", "Periódico qualis a4");
        Publicacao pu4 = new Publicacao("Publicação", "Paradigmas de POO", "123", "Periódico qualis b1");
        assertEquals(1,pu.getCreditos());
        assertEquals(1,pu2.getCreditos());
        assertEquals(1,pu3.getCreditos());
        assertEquals(1,pu4.getCreditos());
    }

     @Test
    void toStringTest() {
        Publicacao pu = new Publicacao("Publicação", "Paradigmas de POO", "123", "Conferência qualis a4");
        assertEquals("Publicação. \nCréditos acumulados: 1.0", pu.toString());
    }
}
