package br.edu.ufcg.computacao.complementaccc.Atividade;

/**
 * Representa uma atividade de pesquisa ou extensão.
 * 
 * @author Alexandre Campos
 */
public class PesquisaExtensao extends AtividadeAbstract {

    /**
     * Número de meses que durou a pesquisa
     */
    private int meses;
    /**
     * Disciplina a qual a pesquisa se refere
     */
    private String disciplina;
    /**
     * Número máximo de créditos que se pode acumular com pesquisas
     */
    private final int CREDITOS_MAX = 18;

    /**
     * Construtor para criar uma instância de PesquisaExtensao.
     *
     * @param tipo o tipo da atividade
     * @param unidadeAcumulada o número de meses de pesquisa ou extensão acumulados
     * @param disciplina a disciplina associada à atividade
     * @throws IllegalArgumentException se a unidade acumulada for negativa ou se a disciplina estiver em branco
     * @throws NullPointerException se a disciplina for nula
     */
    public PesquisaExtensao(String tipo, int unidadeAcumulada, String disciplina) {
        super(tipo);

        if (unidadeAcumulada < 0) throw new IllegalArgumentException("Unidade Acumulada inválida!");
        this.meses = unidadeAcumulada;

        if (disciplina == null) throw new NullPointerException("Disciplina nula");
        if (disciplina.isBlank()) throw new IllegalArgumentException("Disciplina inválida");
        this.disciplina = disciplina;
    }

    /**
     * Retorna a quantidade de créditos acumulados com base nos meses de pesquisa ou extensão.
     *
     * @return a quantidade de créditos acumulados. Caso o número de créditos acumulados exceda o máximo, retorna o máximo
     */
    public double getCreditos() {
        double creditos = (5 * meses) / 6;
        if (creditos > CREDITOS_MAX) {
            return CREDITOS_MAX;
        }
        return creditos;
    }

    /**
     * Retorna uma representação em formato de string da PesquisaExtensao.
     *
     * @return uma string representando a PesquisaExtensao
     */
    @Override
    public String toString() {
        return super.getTipo() + ". " + super.getDescricao() + "\nCréditos acumulados: " + this.getCreditos();
    }
}
