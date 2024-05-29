package br.edu.ufcg.computacao.complementaccc.Relatorio;

import java.util.ArrayList;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeInterface;

/**
 * Classe abstrata para representar um relatório de atividades de um aluno.
 * 
 * @author Alexandre Campos
 */
public abstract class RelatorioAbstract {
    /**
     * Nome do Aluno ao qual o relatório foi gerado
     */
    private String nome;
    /**
     * CPF do aluno
     */
    private String cpf;
    /**
     * matrícula do aluno
     */
    private String matricula;
    /**
     * Lista de atividades do aluno
     */
    private ArrayList<AtividadeInterface> atividades;

    /**
     * Construtor da classe RelatorioAbstract.
     *
     * @param nome o nome do aluno
     * @param cpf o CPF do aluno
     * @param matricula a matrícula do aluno
     * @param atividades a lista de atividades do aluno
     * @throws NullPointerException se algum dos parâmetros (nome, cpf, matricula) for nulo
     * @throws IllegalArgumentException se algum dos parâmetros (nome, cpf, matricula) for uma string vazia
     * @throws IllegalArgumentException se a lista de atividades estiver vazia
     */
    public RelatorioAbstract(String nome, String cpf, String matricula, ArrayList<AtividadeInterface> atividades) {
        if (nome == null) throw new NullPointerException("Nome nulo");
        if (nome.isBlank()) throw new IllegalArgumentException("Nome inválido");
        this.nome = nome;

        if (cpf == null) throw new NullPointerException("CPF nulo");
        if (cpf.isBlank()) throw new IllegalArgumentException("CPF inválido");
        this.cpf = cpf;

        if (matricula == null) throw new NullPointerException("Matrícula nula");
        if (matricula.isBlank()) throw new IllegalArgumentException("Matrícula inválida");
        this.matricula = matricula;

        if (atividades.isEmpty()) throw new IllegalArgumentException("Lista de atividades inválida");
        this.atividades = atividades;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCPF() {
        return this.cpf;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public ArrayList<AtividadeInterface> getAtividades() {
        return this.atividades;
    }
}
