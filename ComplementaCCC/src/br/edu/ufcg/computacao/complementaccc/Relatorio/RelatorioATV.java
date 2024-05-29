package br.edu.ufcg.computacao.complementaccc.Relatorio;

import java.util.ArrayList;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeInterface;
import br.edu.ufcg.computacao.complementaccc.Atividade.Estagio;
import br.edu.ufcg.computacao.complementaccc.Atividade.Monitoria;
import br.edu.ufcg.computacao.complementaccc.Atividade.PesquisaExtensao;
import br.edu.ufcg.computacao.complementaccc.Atividade.Publicacao;

/**
 * Classe para representar um relatório de atividades de um aluno.
 * Estende a classe abstrata RelatorioAbstract.
 * 
 * @author Alexandre Campos
 */
public class RelatorioATV extends RelatorioAbstract {
    /**
     * Tipo de atividade do relatório
     */
    private String tipoAtividade;

    /**
     * Construtor da classe RelatorioATV.
     *
     * @param nome o nome do aluno
     * @param cpf o CPF do aluno
     * @param matricula a matrícula do aluno
     * @param atividades a lista de atividades do aluno
     * @param tipoAtividade o tipo de atividade para o relatório
     * @throws NullPointerException se o tipo de atividade for nulo
     * @throws IllegalArgumentException se o tipo de atividade for uma string vazia ou contiver apenas espaços em branco
     */
    public RelatorioATV(String nome, String cpf, String matricula, ArrayList<AtividadeInterface> atividades, String tipoAtividade) {
        super(nome, cpf, matricula, atividades);
        if (tipoAtividade == null) throw new NullPointerException("Atividade nula");
        if (tipoAtividade.isBlank()) throw new IllegalArgumentException("Atividade inválida");
        this.tipoAtividade = tipoAtividade;
    }

    private int selecionaTipo(String tipoAtividade) {
        int creditos = 0;
        switch (tipoAtividade.toLowerCase()) {
            case "estágio":
                for (AtividadeInterface a : super.getAtividades()) {
                    if (a.getClass().equals(Estagio.class)) {
                        creditos += a.getCreditos();
                    }
                }
                break;
            case "monitoria":
                for (AtividadeInterface a : super.getAtividades()) {
                    if (a.getClass().equals(Monitoria.class)) {
                        creditos += a.getCreditos();
                    }
                }
                break;
            case "pesquisaextensão":
                for (AtividadeInterface a : super.getAtividades()) {
                    if (a.getClass().equals(PesquisaExtensao.class)) {
                        creditos += a.getCreditos();
                    }
                }
                break;
            case "publicação":
                for (AtividadeInterface a : super.getAtividades()) {
                    if (a.getClass().equals(Publicacao.class)) {
                        creditos += a.getCreditos();
                    }
                }
                break;
        }

        return creditos;
    }

    /**
     * Método para gerar uma representação em string do relatório de atividades.
     *
     * @return uma string representando o relatório de atividades
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aluno: ").append(super.getNome()).append("; CPF: ").append(super.getCPF()).append("; Matrícula: ").append(getMatricula());
        sb.append("\n").append(tipoAtividade).append(": ").append(this.selecionaTipo(tipoAtividade)).append("/");

        switch (tipoAtividade.toLowerCase()) {
            case "monitoria":
                sb.append("16");
                break;
            case "pesquisaextensão":
            case "estágio":
                sb.append("18");
                break;
            case "publicação":
                sb.append("16");
                break;
        }

        return sb.toString();
    }
}
