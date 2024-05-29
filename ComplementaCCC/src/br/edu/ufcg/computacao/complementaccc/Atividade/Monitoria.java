package br.edu.ufcg.computacao.complementaccc.Atividade;

/**
 * Representa uma atividade de monitoria.
 * 
 * @author Alexandre Campos
 */
public class Monitoria extends AtividadeAbstract {

    /**
     * int com o número de semestres que a monitoria durou
     */
    private int semestres;
    /**
     * String com a disciplina referente a monitoria
     */
    private String disciplina;
    /**
     * Número máximo de créditos que um aluno pode acumular com monitorias
     */
    private final int CREDITOS_MAX = 16;

    /**
     * Construtor para criar uma instância de Monitoria.
     *
     * @param tipo o tipo da atividade
     * @param unidadeAcumulada o número de semestres de monitoria acumulados
     * @param disciplina a disciplina associada à monitoria
     * @throws IllegalArgumentException se a unidade acumulada for negativa ou se a disciplina estiver em branco
     * @throws NullPointerException se a disciplina for nula
     */
    public Monitoria(String tipo, int unidadeAcumulada, String disciplina) throws IllegalArgumentException, NullPointerException{
        super(tipo);

        if (unidadeAcumulada < 0) throw new IllegalArgumentException("Unidade Acumulada inválida!");
        this.semestres = unidadeAcumulada;

        if (disciplina == null) throw new NullPointerException("Disciplina nula");
        if (disciplina.isBlank()) throw new IllegalArgumentException("Disciplina inválida");
        this.disciplina = disciplina;
    }

    /**
     * Retorna a quantidade de créditos acumulados com base nos semestres de monitoria.
     *
     * @return a quantidade de créditos acumulados. Caso o número de créditos exceda o máximo, retorna o máximo
     */
    public double getCreditos() {
        double creditos = 4 * semestres;
        if (creditos > CREDITOS_MAX) {
            return CREDITOS_MAX;
        }
        return creditos;
    }

    /**
     * Retorna uma representação em formato de string da Monitoria.
     *
     * @return uma string representando a Monitoria
     */
    @Override
    public String toString() {
        return super.getTipo() + ". " + super.getDescricao() + "\nCréditos acumulados: " + this.getCreditos();
    }
}

