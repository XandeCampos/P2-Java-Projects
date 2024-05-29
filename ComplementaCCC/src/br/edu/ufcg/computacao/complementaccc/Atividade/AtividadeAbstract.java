package br.edu.ufcg.computacao.complementaccc.Atividade;

/**
 * Classe abstrata para representar uma atividade genérica.
 * Implementa a interface AtividadeInterface.
 * 
 * @author Alexandre Campos
 */
public abstract class AtividadeAbstract implements AtividadeInterface {
    /**
     * Tipo da atividade
     */
    private String tipo;
    /**
     * Descrição da atividade
     */
    private String descricao;
    /**
     * Código da atividade. É sua identificação única no sistema
     */
    private String codigo;
    /**
     * Link de comprovação da atividade
     */
    private String link;

    /**
     * Construtor da classe AtividadeAbstract.
     *
     * @param tipo o tipo da atividade
     * @throws NullPointerException se o tipo for nulo
     * @throws IllegalArgumentException se o tipo for uma string vazia ou contiver apenas espaços em branco
     */
    public AtividadeAbstract(String tipo) {
        if (tipo == null) throw new NullPointerException("Tipo nulo");
        if (tipo.isBlank()) throw new IllegalArgumentException("Tipo inválido");
        this.tipo = tipo;

        this.descricao = "";
    }

    /**
     * Altera a descrição da atividade.
     *
     * @param descricao a nova descrição da atividade
     * @throws NullPointerException se a descrição for nula
     * @throws IllegalArgumentException se a descrição for uma string vazia ou contiver apenas espaços em branco
     */
    public void alteraDescricaoAtividade(String descricao) {
        if (descricao == null) throw new NullPointerException("Descrição nula");
        if (descricao.isBlank()) throw new IllegalArgumentException("Descrição inválida");
        this.descricao = descricao;
    }

    /**
     * Altera a comprovação da atividade.
     *
     * @param linkComprovacao o link de comprovação da atividade
     * @throws NullPointerException se o link for nulo
     * @throws IllegalArgumentException se o link for uma string vazia ou contiver apenas espaços em branco
     */
    public void alteraComprovacaoAtividade(String linkComprovacao) {
        if (linkComprovacao == null) throw new NullPointerException("Link nulo");
        if (linkComprovacao.isBlank()) throw new IllegalArgumentException("Link inválido");
        this.link = linkComprovacao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código único da atividade.
     *
     * @param codigo o código único da atividade
     * @throws NullPointerException se o código for nulo
     * @throws IllegalArgumentException se o código for uma string vazia ou contiver apenas espaços em branco
     */
    public void setCodigo(String codigo) {
        if (codigo == null) throw new NullPointerException("Código nulo");
        if (codigo.isBlank()) throw new IllegalArgumentException("Código inválido");
        this.codigo = codigo;
    }

    /**
     * Método abstrato para obter a quantidade de créditos da atividade.
     *
     * @return a quantidade de créditos da atividade
     */
    public abstract double getCreditos();
}
