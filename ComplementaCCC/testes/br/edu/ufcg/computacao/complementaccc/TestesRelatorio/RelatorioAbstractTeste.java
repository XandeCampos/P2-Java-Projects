package br.edu.ufcg.computacao.complementaccc.TestesRelatorio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeAbstract;
import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeInterface;
import br.edu.ufcg.computacao.complementaccc.Atividade.Estagio;
import br.edu.ufcg.computacao.complementaccc.Atividade.Monitoria;
import br.edu.ufcg.computacao.complementaccc.Atividade.PesquisaExtensao;
import br.edu.ufcg.computacao.complementaccc.Atividade.Publicacao;
import br.edu.ufcg.computacao.complementaccc.Relatorio.RelatorioAbstract;
import br.edu.ufcg.computacao.complementaccc.Relatorio.RelatorioResumido;

public class RelatorioAbstractTeste {
    private ArrayList<AtividadeInterface> atividadesTest;
    
    @BeforeEach
    void setUp() {
        this.atividadesTest = new ArrayList<>();
        Estagio est = new Estagio("Estágio", "P2", 300);
        this.atividadesTest.add(est);
        Monitoria mon = new Monitoria("Monitoria", 2, "P2");
        this.atividadesTest.add(mon);
        PesquisaExtensao pes = new PesquisaExtensao("Pesquisa", 6, "P2");
        this.atividadesTest.add(pes);
        Publicacao pub = new Publicacao("Publicação", "Métodos", "1234", "Conferência qualis a1");
        this.atividadesTest.add(pub);
    }

    @Test
    void construtorTest() {
        RelatorioAbstract rel = new RelatorioResumido("Test", "12345678901", "123", atividadesTest);
    }

    @Test
    void construtorNomeNullTest() {
        try {
            RelatorioAbstract rel = new RelatorioResumido(null, "12345678901", "123", atividadesTest);   
        } catch (NullPointerException npe) {
            assertEquals("Nome nulo", npe.getMessage());
        }
    }

    @Test
    void construtorNomeBlankTest() {
        try {
            RelatorioAbstract rel = new RelatorioResumido("", "12345678901", "123", atividadesTest);   
        } catch (IllegalArgumentException iae) {
            assertEquals("Nome inválido", iae.getMessage());
        }
    }

    @Test
    void construtorCPFNullTest() {
        try {
            RelatorioAbstract rel = new RelatorioResumido("Test", null, "123", atividadesTest);   
        } catch (NullPointerException npe) {
            assertEquals("CPF nulo", npe.getMessage());
        }
    }

    @Test
    void construtorCPFBlankTest() {
        try {
            RelatorioAbstract rel = new RelatorioResumido("Test", "", "123", atividadesTest);   
        } catch (IllegalArgumentException iae) {
            assertEquals("CPF inválido", iae.getMessage());
        }
    }

    @Test
    void construtorMatriculaNullTest() {
        try {
            RelatorioAbstract rel = new RelatorioResumido("Test", "12345678901", null, atividadesTest);   
        } catch (NullPointerException npe) {
            assertEquals("Matrícula nula", npe.getMessage());
        }
    }

    @Test
    void construtorMatriculaBlankTest() {
        try {
            RelatorioAbstract rel = new RelatorioResumido("Test", "12345678901", "", atividadesTest);   
        } catch (IllegalArgumentException iae) {
            assertEquals("Matrícula inválida", iae.getMessage());
        }
    }

    @Test
    void construtorAtividadeVazioTest() { 
        ArrayList<AtividadeInterface> vazio = new ArrayList<>();
        try {
            RelatorioAbstract rel = new RelatorioResumido("Test", "12345678901", "123", vazio);   
        } catch (IllegalArgumentException iae) {
            assertEquals("Lista de atividades inválida", iae.getMessage());
        }
    }
}
