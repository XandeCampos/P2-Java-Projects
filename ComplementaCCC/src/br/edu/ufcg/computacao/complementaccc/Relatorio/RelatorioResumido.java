package br.edu.ufcg.computacao.complementaccc.Relatorio;

import java.util.ArrayList;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeInterface;
import br.edu.ufcg.computacao.complementaccc.Atividade.Estagio;
import br.edu.ufcg.computacao.complementaccc.Atividade.Monitoria;
import br.edu.ufcg.computacao.complementaccc.Atividade.PesquisaExtensao;
import br.edu.ufcg.computacao.complementaccc.Atividade.Publicacao;

/**
 * Classe para representar um relatório resumido das atividades de um aluno.
 * Estende a classe abstrata RelatorioAbstract.
 * 
 * @author Alexandre Campos
 */
public class RelatorioResumido extends RelatorioAbstract {

    /**
     * Construtor da classe RelatorioResumido.
     *
     * @param nome o nome do aluno
     * @param cpf o CPF do aluno
     * @param matricula a matrícula do aluno
     * @param atividades a lista de atividades do aluno
     */
    public RelatorioResumido(String nome, String cpf, String matricula, ArrayList<AtividadeInterface> atividades) {
        super(nome, cpf, matricula, atividades);
    }

    private double calculaCreditosMonitoria() {
        double creditosMonitoria = 0;
        for (AtividadeInterface a : super.getAtividades()) {
            if (a.getClass().equals(Monitoria.class)) {
                creditosMonitoria += a.getCreditos();
            }
        }
        return creditosMonitoria;
    }

    private double calculaCreditosEstagio() {
        double creditosEstagio = 0;
        for (AtividadeInterface a : super.getAtividades()) {
            if (a.getClass().equals(Estagio.class)) {
                creditosEstagio += a.getCreditos();
            }
        }
        if (creditosEstagio >= 5) {
            return creditosEstagio;
        } else {
            return -1.0;
        }
    }

    private double calculaCreditosPesquisa() {
        double creditosPesquisa = 0;
        for (AtividadeInterface a : super.getAtividades()) {
            if (a.getClass().equals(PesquisaExtensao.class)) {
                creditosPesquisa += a.getCreditos();
            }
        }
        if (creditosPesquisa >= 1) {
            return creditosPesquisa;
        } else {
            return -1.0;
        }
    }

    private double calculaCreditosPublicacao() {
        double creditosPublicacao = 0;
        for (AtividadeInterface a : super.getAtividades()) {
            if (a.getClass().equals(Publicacao.class)) {
                creditosPublicacao += a.getCreditos();
            }
        }
        return creditosPublicacao;
    }

    /**
     * Método para gerar uma representação em string do relatório resumido de atividades.
     *
     * @return uma string representando o relatório resumido de atividades
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aluno: ").append(super.getNome()).append("; CPF: ").append(super.getCPF()).append("; Matrícula: ").append(getMatricula());

        if (calculaCreditosEstagio() > 0) {
            sb.append("\nEstágio: ").append(calculaCreditosEstagio()).append("/18");
        } else {
            sb.append("\nEstágio: NÃO ATINGIU AINDA O VALOR MÍNIMO");
        }

        if (calculaCreditosPesquisa() > 0) {
            sb.append("\nPesquisa: ").append(calculaCreditosPesquisa()).append("/18");
        } else {
            sb.append("\nPesquisa: NÃO ATINGIU AINDA O VALOR MÍNIMO");
        }

        sb.append("\nMonitoria: ").append(calculaCreditosMonitoria()).append("/16");
        sb.append("\nPublicação: ").append(calculaCreditosPublicacao()).append("/16");

        return sb.toString();
    }
}
