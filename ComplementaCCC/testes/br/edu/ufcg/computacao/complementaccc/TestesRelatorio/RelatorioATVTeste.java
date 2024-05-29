package br.edu.ufcg.computacao.complementaccc.TestesRelatorio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeInterface;
import br.edu.ufcg.computacao.complementaccc.Atividade.Estagio;
import br.edu.ufcg.computacao.complementaccc.Atividade.Monitoria;
import br.edu.ufcg.computacao.complementaccc.Atividade.PesquisaExtensao;
import br.edu.ufcg.computacao.complementaccc.Atividade.Publicacao;
import br.edu.ufcg.computacao.complementaccc.Relatorio.RelatorioATV;

public class RelatorioATVTeste {
    private ArrayList<AtividadeInterface> atividades;
    
    @BeforeEach
    void setUp() {
        this.atividades = new ArrayList<>();
        Estagio est = new Estagio("Estágio", "P2", 300);
        this.atividades.add(est);
        Monitoria mon = new Monitoria("Monitoria", 2, "P2");
        this.atividades.add(mon);
        PesquisaExtensao pes = new PesquisaExtensao("Pesquisa", 6, "P2");
        this.atividades.add(pes);
        Publicacao pub = new Publicacao("Publicação", "Métodos", "1234", "Conferência qualis a1");
        this.atividades.add(pub);
    }

    @Test
    void construtorTest() {
        RelatorioATV atv = new RelatorioATV("Test", "12345678901", "123", atividades, "Estágio");
    }

    @Test
    void construtorAtividadeNullTest() {
        try {
            RelatorioATV atv = new RelatorioATV("Test", "12345678901", "123", atividades, null);
        } catch (NullPointerException npe) {
            assertEquals("Atividade nula", npe.getMessage());
        }
    }

    @Test
    void construtorAtividadeBlankTest() {
        try {
            RelatorioATV atv = new RelatorioATV("Test", "12345678901", "123", atividades, "");
        } catch (IllegalArgumentException iae) {
            assertEquals("Atividade inválida", iae.getMessage());
        }
    }

    @Test
    void toStringEstagioTest() {
        RelatorioATV atv = new RelatorioATV("Test", "12345678901", "123", atividades, "Estágio");
        assertEquals("Aluno: Test; CPF: 12345678901; Matrícula: 123\nEstágio: 5/18", atv.toString());
    }

    @Test
    void toStringMonitoriaTest() {
        RelatorioATV atv = new RelatorioATV("Test", "12345678901", "123", atividades, "Monitoria");
        assertEquals("Aluno: Test; CPF: 12345678901; Matrícula: 123\nMonitoria: 8/16", atv.toString());
    }

    @Test
    void toStringPesquisaTest() {
        RelatorioATV atv = new RelatorioATV("Test", "12345678901", "123", atividades, "PesquisaExtensão");
        assertEquals("Aluno: Test; CPF: 12345678901; Matrícula: 123\nPesquisaExtensão: 5/18", atv.toString());
    }

    @Test
    void toStringPublicacaoTest() {
        RelatorioATV atv = new RelatorioATV("Test", "12345678901", "123", atividades, "Publicação");
        assertEquals("Aluno: Test; CPF: 12345678901; Matrícula: 123\nPublicação: 3/16", atv.toString());
    }
}
