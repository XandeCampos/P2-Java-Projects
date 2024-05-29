package br.edu.ufcg.computacao.complementaccc.TestesUsuario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Usuario.Admin;

public class AdminTeste {
    @Test
    void construtorTest() {
        Admin adm = new Admin("Alex", "12345678901", 31415926);
    }

    @Test
    void toStringTest() {
        Admin adm = new Admin("Alex", "12345678901", 31415926);
        assertEquals("\nAdmin: Alex\nCPF: 12345678901\n", adm.toString());
    }
}
