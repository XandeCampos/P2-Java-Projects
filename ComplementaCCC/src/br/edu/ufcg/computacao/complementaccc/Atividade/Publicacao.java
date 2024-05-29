package br.edu.ufcg.computacao.complementaccc.Atividade;

/**
 * Representa uma atividade de publicação.
 * 
 * @author Alexandre Campos
 */
public class Publicacao extends AtividadeAbstract {

    /**
     * Título da Publicação
     */
    private String titulo;
    /**
     * DOI da publicação
     */
    private String doi;
    /**
     * Qualis referência da publicação
     */
    private String qualis;
    /**
     * Número máximo de créditos que se pode acumular com publicações
     */
    private final int CREDITOS_MAX = 16;

    /**
     * Construtor para criar uma instância de Publicacao.
     *
     * @param tipo o tipo da atividade
     * @param titulo o título da publicação
     * @param doi o DOI (Digital Object Identifier) da publicação
     * @param qualis a classificação QUALIS da publicação
     * @throws NullPointerException se o título, o DOI ou a classificação QUALIS forem nulos
     * @throws IllegalArgumentException se o título, o DOI ou a classificação QUALIS estiverem em branco
     */
    public Publicacao(String tipo, String titulo, String doi, String qualis) {
        super(tipo);

        if (titulo == null) {
            throw new NullPointerException("TÍTULO NULO");
        } else if (titulo.isBlank()) {
            throw new IllegalArgumentException("TÍTULO INVÁLIDO");
        }
        if (doi == null) {
            throw new NullPointerException("DOI NULO");
        } else if (doi.isBlank()) {
            throw new IllegalArgumentException("DOI INVÁLIDO");
        }
        if (qualis == null) {
            throw new NullPointerException("QUALIS NULO");
        } else if (qualis.isBlank()) {
            throw new IllegalArgumentException("QUALIS INVÁLIDO");
        }

        this.titulo = titulo;
        this.doi = doi;
        this.qualis = qualis;
    }

    /**
     * Retorna a quantidade de créditos acumulados com base na classificação QUALIS da publicação.
     *
     * @return a quantidade de créditos acumulados
     */
    public double getCreditos() {
        double creditos = 0;
        if (qualis.toUpperCase().equals("PERIÓDICO QUALIS A1") || qualis.toUpperCase().equals("PERIÓDICO QUALIS A2")) {
            creditos = 4;
        } else if (qualis.toUpperCase().equals("PERIÓDICO QUALIS A3") || qualis.toUpperCase().equals("CONFERÊNCIA QUALIS A1") || qualis.toUpperCase().equals("CONFERÊNCIA QUALIS A2")) {
            creditos = 3;
        } else if (qualis.toUpperCase().equals("CONFERÊNCIA QUALIS A3")) {
            creditos = 2;
        } else if (qualis.toUpperCase().equals("CONFERÊNCIA QUALIS A4") || qualis.toUpperCase().equals("CONFERÊNCIA QUALIS B1") || qualis.toUpperCase().equals("PERIÓDICO QUALIS A4") || qualis.toUpperCase().equals("PERIÓDICO QUALIS B1")) {
            creditos = 1;
        }
        return creditos;
    }

    /**
     * Retorna uma representação em formato de string da Publicacao.
     *
     * @return uma string representando a Publicacao
     */
    @Override
    public String toString() {
        return super.getTipo() + ". " + super.getDescricao() + "\nCréditos acumulados: " + this.getCreditos();
    }
}
