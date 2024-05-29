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
import br.edu.ufcg.computacao.complementaccc.Relatorio.RelatorioDetalhado;

public class RelatorioDetalhadoTeste {
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
    void toStringTest() {
        RelatorioDetalhado rd = new RelatorioDetalhado("Test", "12345678901", "123", atividadesTest);
        StringBuilder sb = new StringBuilder();
        sb.append("Aluno: Test; CPF: 12345678901; Matrícula: 123");
        for (AtividadeInterface a : atividadesTest) {
            sb.append("\n" + a.toString());
        }
        assertEquals(sb.toString(), rd.toString());
    }
}
