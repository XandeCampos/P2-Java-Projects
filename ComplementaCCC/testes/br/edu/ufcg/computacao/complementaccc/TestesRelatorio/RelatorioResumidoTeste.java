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
import br.edu.ufcg.computacao.complementaccc.Relatorio.RelatorioResumido;

public class RelatorioResumidoTeste {
    private ArrayList<AtividadeInterface> atividades;
    
    @BeforeEach
    void setUp() {
        this.atividades = new ArrayList<>();
        Estagio est = new Estagio("Estágio", "P2", 200);
        this.atividades.add(est);
        Monitoria mon = new Monitoria("Monitoria", 2, "P2");
        this.atividades.add(mon);
        PesquisaExtensao pes = new PesquisaExtensao("Pesquisa", 6, "P2");
        this.atividades.add(pes);
        Publicacao pub = new Publicacao("Publicação", "Métodos", "1234", "Conferência qualis a1");
        this.atividades.add(pub);
    }

    @Test
    void toStringTest() {
        RelatorioResumido rr = new RelatorioResumido("Test", "12345678901", "123", atividades);
        assertEquals("Aluno: Test; CPF: 12345678901; Matrícula: 123\nEstágio: NÃO ATINGIU AINDA O VALOR MÍNIMO\nPesquisa: 5.0/18\nMonitoria: 8.0/16\nPublicação: 3.0/16", rr.toString());
    }
}
