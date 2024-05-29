package br.edu.ufcg.computacao.complementaccc.TestesUsuario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeInterface;
import br.edu.ufcg.computacao.complementaccc.Atividade.Estagio;
import br.edu.ufcg.computacao.complementaccc.Atividade.Monitoria;
import br.edu.ufcg.computacao.complementaccc.Relatorio.RelatorioAbstract;
import br.edu.ufcg.computacao.complementaccc.Relatorio.RelatorioDetalhado;
import br.edu.ufcg.computacao.complementaccc.Usuario.Estudante;

public class EstudanteTeste {
    private AtividadeInterface atv1;
    private AtividadeInterface atv2;
    private RelatorioAbstract relatorio1;
    private RelatorioAbstract relatorio2;

    @BeforeEach
    void setUp() {
        atv1 = new Estagio("Estágio", "P2", 300);
        atv2 = new Monitoria("Monitoria", 2, "Cálculo 1");
        ArrayList<AtividadeInterface> atividades = new ArrayList<>();
        atividades.add(atv1);
        atividades.add(atv2); 
        relatorio1 = new RelatorioDetalhado("Alex", "12345678901", "123", atividades);
    }

    @Test
    void construtorTest() {
        Estudante estudante = new Estudante("Alex", "12345678901", 31415926, "123");
    }

    @Test
    void construtorMatriculaNullTest() {
        try {
            Estudante estudante = new Estudante("Alex", "12345678901", 31415926, null);
        } catch (NullPointerException npe) {
            assertEquals("Matricula nula", npe.getMessage());
        }
    }

    @Test
    void construtorMatriculaVaziaTest() {
        try {
            Estudante estudante = new Estudante("Alex", "12345678901", 31415926, "");
        } catch (IllegalArgumentException iae) {
            assertEquals("Matricula inválida", iae.getMessage());
        }
    }

    @Test
    void toStringTest() {
        Estudante estudante = new Estudante("Alex", "12345678901", 31415926, "123"); 
        assertEquals("\nEstudante: Alex\nCPF: 12345678901\nMatrícula: 123\n", estudante.toString());
    }

    @Test
    void adicionaAtividadeTest() {
        Estudante estudante = new Estudante("Alex", "12345678901", 31415926, "123");
        assertEquals("12345678901_1", estudante.adicionaAtividade(atv1));
        assertEquals("12345678901_2", estudante.adicionaAtividade(atv2));
    }

    @Test
    void getAtividadeTest() {
        Estudante estudante = new Estudante("Alex", "12345678901", 31415926, "123");
        estudante.adicionaAtividade(atv1);
        assertEquals(atv1, estudante.getAtividade("12345678901_1"));
    }

    @Test
    void getAtividadeCodigoInvalidoTest() {
        Estudante estudante = new Estudante("Alex", "12345678901", 31415926, "123");
        estudante.adicionaAtividade(atv1);
        try {
            estudante.getAtividade("12345678901_2");
        } catch (IllegalArgumentException iae) {
            assertEquals("Código não existe", iae.getMessage());
        }
    }

    @Test
    void listaAtividadesTest() {
        Estudante estudante = new Estudante("Alex", "12345678901", 31415926, "123");
        ArrayList<AtividadeInterface> atividadeTeste = new ArrayList<>();
        atividadeTeste.add(atv1);
        estudante.adicionaAtividade(atv1);
        assertEquals(atividadeTeste, estudante.listaAtividades());
    }

    @Test
    void listaAtividadesVazioTest() {
        Estudante estudante = new Estudante("Alex", "12345678901", 31415926, "123");
        ArrayList<AtividadeInterface> atividadeTeste = new ArrayList<>();
        assertEquals(atividadeTeste, estudante.listaAtividades());
    }

    @Test
    void adicionaRelatorioTest() {
        Estudante estudante = new Estudante("Alex", "12345678901", 31415926, "123");
        assertEquals(0, estudante.adicionaRelatorio(relatorio1));
        assertEquals(1, estudante.adicionaRelatorio(relatorio2));
    }

    @Test
    void getRelatorioTest() {
        Estudante estudante = new Estudante("Alex", "12345678901", 31415926, "123");
        estudante.adicionaRelatorio(relatorio1);
        assertEquals(relatorio1, estudante.getRelatorio(0));
    }
}