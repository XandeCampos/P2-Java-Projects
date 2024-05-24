package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Registro do tempo que um aluno ficou online estudando uma disciplina remota.
 * Espera-se que ele dedique o dobro de horas da disciplina estudando.
 * 
 * @author Alexandre Campos
 */
public class RegistroTempoOnline {
	/**
	 * Nome da disciplina online que o aluno pagará.
	 */
	private String nomeDaDisciplina;
	/**
	 * Tempo que o aluno efetivamente passou estudando a matéria.
	 */
	private int tempoInvestido;
	/**
	 * Tempo que o aluno deveria passar estudando a matéria.
	 */
	private int tempoEsperado;
	
	/**
	 * Constrói uma disciplina a partir de seu nome. Por padrão, considera-se uma
	 * disciplina de 60 horas. Portanto, espera-se 120 de dedicação.
	 * 
	 * @param nomeDisciplina o nome que identifica a disciplina
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.tempoEsperado = 120;
	}
	
	/**
	 * Constrói uma disciplina a partir de seu nome e do tempo de dedicação que se espera
	 * do aluno. Esse construtor representa uma sobrecarga do anterior, adicionando a
	 * opção de definir o tempo online esperado do aluno
	 * 
	 * @param nomeDisciplina o nome que identifica a disciplina
	 * @param tempoOnlineEsperado o tempo que espera-se que o aluno passe estudando
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.tempoEsperado = tempoOnlineEsperado;
	}
	
	/**
	 * Método set genérico. Adiciona o tempo investido pelo aluno. É cumulativo para
	 * que possa ser incrementado conforme o aluno for estudando.
	 * 
	 * @param tempo o tempo de estudo que o aluno deseja adicionar ao tempo total
	 * acumulado
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoInvestido += tempo;
	}
	
	/**
	 * Verifica se o aluno atingiu a meta de tempo online de estudo que fora definida
	 * no construtor.
	 * 
	 * @return um valor booleano dizendo se o tempo acumulado já atingiu o esperado
	 */
	public boolean atingiuMetaTempoOnline() {
		return (tempoInvestido >= tempoEsperado);
	}
	
	/**
	 * Retorna a String que representa o tempo de estudo da disciplina. A representação
	 * segue o formato "nomeDaDisciplina tempoInvestido/tempoEsperado"
	 */
	@Override
	public String toString() {
		return this.nomeDaDisciplina + " " + this.tempoInvestido + "/" + this.tempoEsperado;
	}

}
