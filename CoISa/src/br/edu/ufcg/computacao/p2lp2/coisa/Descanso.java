package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 *  Classe que guarda o tempo de descanso do estudante e opera sobre ele. 
 *  
 *  @author Alexandre Campos
 */
public class Descanso {
	/**
	 * Quantidade de horas totais que o aluno descansou, guardado como um inteiro.
	 */
	private int horasDescanso;
	/**
	 * Quantidade total de semanas. Serve para definir o escopo do calculo de descanso
	 * do aluno.
	 */
	private int numeroDeSemanas;
	/**
	 * Emoji que o usuario definiu para expressar sua ultima sensação em geral. Será
	 * impresso junto ao estado de descanso.
	 */
	private String emoji;
	/**
	 * Estado geral de descanso do aluno, pode ser "cansado" ou "descansado" a depender
	 * dos valores dos atributos.
	 */
	private String estadoDescanso;
	
	/**
	 * Constrói um objeto descanso com valores padrões de quantidade de descanso e
	 * numero de semanas. Não recebe parâmetros no momento da construção.
	 */
	public Descanso() {
		this.horasDescanso = 0;
		this.numeroDeSemanas = 1;
	}
	
	/**
	 * Método set genérico. Define a quantidade de horas de descanso do objeto.
	 * 
	 * @param horas quantidade de horas em valores inteiros.
	 */
	public void defineHorasDescanso(int horas) {
		this.horasDescanso = horas;
	}
	
	/**
	 * Método set genérico. Define a quantidade de semanas para o escopo do objeto.
	 * 
	 * @param semanas quantidade de semanas a serem analisadas.
	 */
	public void defineNumeroSemanas(int semanas) {
		this.numeroDeSemanas = semanas;
	}
	
	/**
	 * Método get genérico. Chama o método privado calculaStatusGeral() que atualiza o
	 * estadoDescanso e retorna o estado.
	 * 
	 * @return a representação em String do estado de descanso de um aluno.
	 */
	public String getStatusGeral() {
		calculaStatusGeral();	
		return estadoDescanso;
	}
	
	
	private void calculaStatusGeral() {
		String novoEstadoDescanso;
		if ((this.horasDescanso / this.numeroDeSemanas) < 26) {
			novoEstadoDescanso = "cansado";
		} else {
			novoEstadoDescanso = "descansado";
		}
		
		if (emoji == null) {
			estadoDescanso = novoEstadoDescanso;
		} else if (novoEstadoDescanso.equals(estadoDescanso)) {
			estadoDescanso += " - " + emoji;
		} else {
			estadoDescanso = novoEstadoDescanso;
		}
	}
	
	/**
	 * Método set genérico. Define o emoji.
	 * 
	 * @param valor a String que representa o emoji.
	 */
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
}