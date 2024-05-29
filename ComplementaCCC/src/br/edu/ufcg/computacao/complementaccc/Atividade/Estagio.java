package br.edu.ufcg.computacao.complementaccc.Atividade;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * A classe Estagio representa uma atividade de estágio. Estende a classe AtividadeAbstract.
 * 
 * @author Alexandre Campos
 */
public class Estagio extends AtividadeAbstract {
    
    /** 
     * Número total de horas do estágio
    */
    private int horas;
    /**
     * Nome da disciplina do estágio
     */
    private String disciplina;
    /**
     * Número máximo de créditos que se pode acumular com estágios
     */
    private final int CREDITOS_MAX = 18;

    /**
     * Construtor para criar um objeto Estagio.
     * 
     * @param tipo String com o tipo de atividade.
     * @param disciplina String com o nome da disciplina associada ao estágio.
     * @param horas Int do número total de horas do estágio.
     * @throws NullPointerException se a disciplina for nula.
     * @throws IllegalArgumentException se a disciplina estiver vazia ou se o número de horas for negativo.
     */
    public Estagio(String tipo, String disciplina, int horas) {
        super(tipo);
        
        if (disciplina == null) throw new NullPointerException("Disciplina nula");
        if (disciplina.isBlank()) throw new IllegalArgumentException("Disciplina inválida");
        this.disciplina = disciplina;
        
        if (horas < 0) throw new IllegalArgumentException("Número de horas inválido");
        this.horas = horas; 
    }

    /**
     * Calcula e retorna o número de créditos acumulados para o estágio.
     * 
     * @return O número de créditos acumulados para o estágio. Caso o número exceda o máximo permitido, retorna o máximo.
     */
    public double getCreditos() {
        double creditos = (double) horas / 60.0;
        
        if (creditos > CREDITOS_MAX) {
            return (double) CREDITOS_MAX;
        }
        
        DecimalFormat df = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));
        return Double.parseDouble(df.format(creditos)); 
    }

    @Override
    public String toString() {
        return super.getTipo() + ". " + super.getDescricao() + "\nCréditos acumulados: " + this.getCreditos(); 
    }
}