package br.edu.ufcg.computacao.complementaccc.TestesUsuario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Usuario.Admin;
import br.edu.ufcg.computacao.complementaccc.Usuario.Estudante;
import br.edu.ufcg.computacao.complementaccc.Usuario.UsuarioController;

public class UsuarioControllerTeste {
    private Admin adm;
    private Estudante est;
    private Estudante est2;

    @BeforeEach
    void setUp() {
        this.adm = new Admin("adm", "12345678901", 31415926);
        this.est = new Estudante("Alexandre", "12345678901", 12345678, "123");
        this.est2 = new Estudante("Xande","12345678902", 87654321, "321");
    }

    @Test
    void construtorTest() {
        UsuarioController uc = new UsuarioController();
    }

    @Test
    void configuraNovoAdminTest() {
        UsuarioController uc = new UsuarioController();
        assert uc.configuraNovoAdmin("12345678902", 0, "adm", "12345678901", 12345678);
    }

    @Test
    void configuraNovoAdminMudandoAdminTest() {
        UsuarioController uc = new UsuarioController();
        uc.configuraNovoAdmin("", 0, "adm", "12345678901", 12345678);
        assert uc.configuraNovoAdmin("12345678901", 12345678, "adm2", "12345678902", 31415926);
    }

    @Test
    void configuraNovoAdminCPFErradoTest() {
        UsuarioController uc = new UsuarioController();
        uc.configuraNovoAdmin("", 0, "adm", "12345678901", 12345678);
        try {
            uc.configuraNovoAdmin("12345678905", 12345678, "adm2", "12345678902", 31415926);
        } catch (IllegalArgumentException iae) {
            assertEquals("CPF incorreto!", iae.getMessage());
        }
    }

    @Test
    void configuraNovoAdminSenhaErradaTest() {
        UsuarioController uc = new UsuarioController();
        uc.configuraNovoAdmin("", 0, "adm", "12345678901", 12345678);
        try {
            uc.configuraNovoAdmin("12345678901", 12345677, "adm2", "12345678902", 31415926);
        } catch (IllegalArgumentException iae) {
            assertEquals("Senha Incorreta!", iae.getMessage());
        }
    }

    @Test
    void criaEstudanteTest() {
        UsuarioController uc = new UsuarioController();
        assert uc.criaEstudante("Alex", "12345678901", 12345678, "123");
    }

    @Test
    void exibeEstudantesTest() {
        UsuarioController uc = new UsuarioController();
        uc.criaEstudante("Alexandre", "12345678901", 12345678, "123");
        String[] tostrings = new String[1];
        tostrings[0] = est.toString();
        uc.configuraNovoAdmin("10987654321", 0, "adm", "10987654321", 12345678);
        assertEquals(tostrings[0], uc.exibeEstudantes("10987654321", 12345678)[0]);
    }

    @Test
    void alteraEstudantesNomeTest() {
        UsuarioController uc = new UsuarioController();
        uc.criaEstudante("Alexandre", "12345678901", 12345678, "123");
        assert uc.alteraEstudantes("12345678901", 12345678, "nome", "Xande");
    }

    @Test
    void alteraEstudantesSenhaTest() {
        UsuarioController uc = new UsuarioController();
        uc.criaEstudante("Alexandre", "12345678901", 12345678, "123");
        assert uc.alteraEstudantes("12345678901", 12345678, "senha", "87654321");
    }

    @Test
    void alteraEstudantesAlteracaoInvalida() { // Eu não faço a menor unidade de idéia do porque isso não quebra
        UsuarioController uc = new UsuarioController();
        uc.criaEstudante("Alexandre", "12345678901", 12345678, "123");
        try {
            uc.alteraEstudantes("12345678901", 12345678, "senh", "87654321");
            fail("Try deu certo");
        } catch (IllegalArgumentException e) {
            assertEquals("Alteração inválida", e.getMessage());
        }
    }

    @Test
    void alteraEstudantesSenhaInvalidaTest() {
        UsuarioController uc = new UsuarioController();
        uc.criaEstudante("Alexandre", "12345678901", 12345678, "123");
        try {
             uc.alteraEstudantes("12345678901", 12345678, "senha", "8765431");
        } catch (IllegalArgumentException iae) {
            assertEquals("Nova senha inválida", iae.getMessage());
        }
    }

    @Test
    void exibeAdminTest() {
        UsuarioController uc = new UsuarioController();
        uc.configuraNovoAdmin("", 0, "adm", "12345678901", 12345678);
        assertEquals(adm.toString(), uc.exibeAdmin("12345678901", 12345678));
    }

    @Test
    void configuraSenhaAdmin() {
        UsuarioController uc = new UsuarioController();
        uc.configuraNovoAdmin("", 0, "adm", "12345678901", 12345678);
        assert uc.configuraSenhaAdmin("12345678901", 12345678, 31415926);
    }
}
