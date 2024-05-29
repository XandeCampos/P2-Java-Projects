package br.edu.ufcg.computacao.complementaccc.TestesRelatorio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeController;
import br.edu.ufcg.computacao.complementaccc.Relatorio.RelatorioController;
import br.edu.ufcg.computacao.complementaccc.Usuario.UsuarioController;

public class RelatorioControllerTeste {
    private RelatorioController rc;
    private UsuarioController uc;
    private AtividadeController ac;

    @BeforeEach
    void setUp() {
        this.rc = new RelatorioController();
        this.uc = new UsuarioController();
        this.ac = new AtividadeController();
        uc.criaEstudante("Test", "12345678901", 12345678, "123");
        ac.adicionaEstagioEmEstudante("12345678901", 12345678, "Estágio", 300, "P2", uc);
    }

    @Test
    void criaRelatorioCompletoTest() {
        assertEquals(0, rc.criaRelatorioCompleto("12345678901", 12345678, uc));
    }

    @Test
    void criaRelatorioResumidoTest() {
        assertEquals(0, rc.criaRelatorioResumido("12345678901", 12345678, uc));
    }

    @Test
    void criaRelatorioPorATVTest() {
        assertEquals(0, rc.criaRelatorioPorATV("12345678901", 12345678, "Estágio", uc));
    }

    @Test
    void exibeRelatorioTest() {
        rc.criaRelatorioPorATV("12345678901", 12345678, "Estágio",  uc);
        assertEquals("Aluno: Test; CPF: 12345678901; Matrícula: 123\nEstágio: 5/18", rc.exibeRelatorio("12345678901", 12345678, 0, uc));
    }
}
