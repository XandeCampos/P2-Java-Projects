package br.edu.ufcg.computacao.complementaccc.TestesUsuario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Usuario.Admin;
import br.edu.ufcg.computacao.complementaccc.Usuario.Estudante;
import br.edu.ufcg.computacao.complementaccc.Usuario.UsuarioAbstract;

public class UsuarioAbstractTeste {
    @Test
    void construtorEstudanteTest() {
        UsuarioAbstract usuario = new Estudante("alex", "12345678901", 12345678, "123");
    }
    
    @Test
    void construtorAdminTest() {
        UsuarioAbstract admin = new Admin("alex", "12345678901", 12345678);
    }


    @Test
    void senhaTamanhoErradoTest() {
        try {
            UsuarioAbstract estudante = new Estudante("Alex", "12345678901", 1234567, "tostes");
        } catch (IllegalArgumentException iae) {
            assertEquals("SENHA INVÁLIDA", iae.getMessage());
        }

        try {
            UsuarioAbstract estudante = new Estudante("Alex", "12345678901", 123456789, "tostes");
        } catch (IllegalArgumentException iae) {
            assertEquals("SENHA INVÁLIDA", iae.getMessage());
        }
    }

    @Test
    void nomeNullTest() {
        try {
            UsuarioAbstract estudante = new Estudante(null, "12345678901", 12345678, "tostes");    
        } catch (NullPointerException npe) {
            assertEquals("NOME NULO", npe.getMessage());
        }
    }

    @Test
    void nomeVazioTest() {
        try {
            UsuarioAbstract estudante = new Estudante("", "12345678901", 12345678, "tostes");    
        } catch (IllegalArgumentException npe) {
            assertEquals("NOME INVÁLIDO", npe.getMessage());
        }
    }

    @Test
    void cpfNuloTest() {
        try {
            UsuarioAbstract estudante = new Estudante("Alex", null, 12345678, "tostes");    
        } catch (NullPointerException npe) {
            assertEquals("CPF NULO", npe.getMessage());
        }
    }

    @Test
    void cpfVazioTest() {
        try {
            UsuarioAbstract estudante = new Estudante("Alex", "", 12345678, "tostes");    
        } catch (IllegalArgumentException npe) {
            assertEquals("CPF INVÁLIDO", npe.getMessage());
        }
    }

    @Test
    void cpfTamnhoDiferenteTest() {
        try {
            UsuarioAbstract estudante = new Estudante("Alex", "123", 12345678, "tostes");    
        } catch (IllegalArgumentException npe) {
            assertEquals("CPF INVÁLIDO", npe.getMessage());
        }

        try {
            UsuarioAbstract estudante = new Estudante("Alex", "31415926535897932384626433", 12345678, "tostes");    
        } catch (IllegalArgumentException npe) {
            assertEquals("CPF INVÁLIDO", npe.getMessage());
        }
    }

    @Test
    void setNomeTest() {
        UsuarioAbstract estudante = new Estudante("Alex", "12345678901", 12345678, "tostes");
        estudante.setNome("Xande");
        assertEquals("Xande", estudante.getNome());        
    }

    @Test
    void setNomeNullTest() {
        UsuarioAbstract estudante = new Estudante("Alex", "12345678901", 12345678, "tostes");
        try {
            estudante.setNome(null);
        } catch (NullPointerException npe) {
            assertEquals("NOME NULO", npe.getMessage());
        }
    }

    @Test
    void setNomeVazioTest() {
        UsuarioAbstract estudante = new Estudante("Alex", "12345678901", 12345678, "tostes");
        try {
            estudante.setNome("");
        } catch (IllegalArgumentException iae) {
            assertEquals("NOME INVALIDO", iae.getMessage());
        }
    }

    @Test
    void setSenhaTest() {
        UsuarioAbstract estudante = new Estudante("Alex", "12345678901", 12345678, "tostes");
        estudante.setSenha(31415926);
        assertEquals(31415926, estudante.getSenha());
    }

    @Test
    void setSenhaTamanhoDiferenteTest() {
        UsuarioAbstract estudante = new Estudante("Alex", "12345678901", 12345678, "tostes");
        try {
            estudante.setSenha(3141592);
        } catch (IllegalArgumentException iae) {
            assertEquals("SENHA INVÁLIDA", iae.getMessage());
        }

        try {
            estudante.setSenha(314159265);
        } catch (IllegalArgumentException iae) {
            assertEquals("SENHA INVÁLIDA", iae.getMessage());
        }
    }
}
