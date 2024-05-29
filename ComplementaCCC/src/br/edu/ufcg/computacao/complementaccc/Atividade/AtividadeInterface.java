package br.edu.ufcg.computacao.complementaccc.Atividade;

/**
 * Interface que define os métodos para uma atividade.
 * 
 * @author Alexandre Campos
 */
public interface AtividadeInterface {

    /**
     * Altera a descrição da atividade.
     *
     * @param descricao a nova descrição da atividade
     */
    public void alteraDescricaoAtividade(String descricao);

    /**
     * Altera a comprovação da atividade.
     *
     * @param linkComprovacao o link de comprovação da atividade
     */
    public void alteraComprovacaoAtividade(String linkComprovacao);

    /**
     * Obtém a quantidade de créditos da atividade.
     *
     * @return a quantidade de créditos da atividade
     */
    public double getCreditos();

    /**
     * Obtém o tipo da atividade.
     *
     * @return o tipo da atividade
     */
    public String getTipo();

    /**
     * Obtém a descrição da atividade.
     *
     * @return a descrição da atividade
     */
    public String getDescricao();

    /**
     * Retorna uma representação em formato de string da atividade.
     *
     * @return uma string representando a atividade
     */
    @Override
    public String toString();
}

