package br.edu.ufcg.computacao.complementaccc.TestesAtividade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeController;
import br.edu.ufcg.computacao.complementaccc.Usuario.UsuarioController;

public class AtividadeControllerTeste {
    private AtividadeController ac;
    private UsuarioController uc;

    @BeforeEach
    void setUp() {
        ac = new AtividadeController();
        uc = new UsuarioController();
        uc.configuraNovoAdmin(null, 0, "adm", "12345678901", 12345678);
        uc.criaEstudante("est", "12345678901", 31415926, "123");
    }

    @Test
    void adicionaAtividadeMonitorEmEstudanteTest() {
        assertEquals("12345678901_1",ac.adicionaAtividadeMonitorEmEstudante("12345678901", 31415926, "Monitoria", 300, "P2", uc));
    }

    @Test
    void adicionaPesquisaExtensaoEmEstudanteTest() {
        assertEquals("12345678901_1",ac.adicionaPesquisaExtensaoEmEstudante("12345678901", 31415926, "Pesquisa", 12, "P2", uc));
    }

    @Test
    void adicionaEstagioEmEstudanteTest() {
        assertEquals("12345678901_1",ac.adicionaEstagioEmEstudante("12345678901", 31415926, "Estágio", 12, "P2", uc));
    }

    @Test
    void adicionaPublicacaoEmEstudanteTest() {
        assertEquals("12345678901_1",ac.adicionaPublicacaoEmEstudante("12345678901", 31415926, "Publicação", "Métodos de Object", "123", "Conferência Qualis a1", uc));
    }

    @Test
    void alteraDescricaoAtividadeControllerTest() {
        assertEquals("12345678901_1",ac.adicionaPublicacaoEmEstudante("12345678901", 31415926, "Publicação", "Métodos de Object", "123", "Conferência Qualis a1", uc));
        assert (ac.alteraDescricaoAtividadeController("12345678901", 31415926, "12345678901_1", "Publicação de P2", uc));
    }

    @Test
    void alteraComprovacaoAtividadeControllerTest() {
        assertEquals("12345678901_1",ac.adicionaPublicacaoEmEstudante("12345678901", 31415926, "Publicação", "Métodos de Object", "123", "Conferência Qualis a1", uc));
        assert (ac.alteraComprovacaoAtividadeController("12345678901", 31415926, "12345678901_1", "www.nothingreally.com", uc));
    }

    @Test
    void pegaCreditosAtividadeTest() {
        ac.adicionaPublicacaoEmEstudante("12345678901", 31415926, "Publicação", "Métodos de Object", "123", "Conferência Qualis a1", uc);
        assertEquals(3.0, ac.pegaCreditosAtividade("12345678901", 31415926, "12345678901_1", uc));
    }
    
}
