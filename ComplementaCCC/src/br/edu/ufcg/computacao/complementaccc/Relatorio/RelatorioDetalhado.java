package br.edu.ufcg.computacao.complementaccc.Relatorio;

import java.util.ArrayList;
import java.util.Collections;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeInterface;

/**
 * Classe para representar um relatório detalhado das atividades de um aluno.
 * Estende a classe abstrata RelatorioAbstract.
 */
public class RelatorioDetalhado extends RelatorioAbstract {

    /**
     * Construtor da classe RelatorioDetalhado.
     *
     * @param nome o nome do aluno
     * @param cpf o CPF do aluno
     * @param matricula a matrícula do aluno
     * @param listaAtividades a lista de atividades do aluno
     */
    public RelatorioDetalhado(String nome, String cpf, String matricula, ArrayList<AtividadeInterface> listaAtividades) {
        super(nome, cpf, matricula, listaAtividades);
    }

    /**
     * Método para gerar uma representação em string do relatório detalhado de atividades.
     *
     * @return uma string representando o relatório detalhado de atividades
     */
    @Override
    public String toString() {
        ArrayList<String> representacaoAtividades = new ArrayList<>();
        for (AtividadeInterface a : super.getAtividades()) {
            representacaoAtividades.add(a.toString());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Aluno: ").append(super.getNome()).append("; CPF: ").append(super.getCPF()).append("; Matrícula: ").append(getMatricula());
        Collections.sort(representacaoAtividades);
        for (String s : representacaoAtividades) {
            sb.append("\n").append(s);
        }
        return sb.toString();
    }
}
