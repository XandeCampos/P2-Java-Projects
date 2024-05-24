package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Arrays;

/**
 * Representação de uma disciplina, com seu nome, as notas do aluno nela,
 * a média final e a quantidade de horas dedicadas a ela.
 * 
 * @author Alexandre Campos
 */
public class Disciplina {
	/**
	 * Nome que identifica a disciplina.
	 */
	private String disciplina;
	/**
	 * Array de doubles que guarda as notas do aluno. Por padrão, considera-se que
	 * ele fará quatro provas.
	 */
	private double[] notas;
	/**
	 * Número de horas que o aluno dedicou ao estudo daquela disciplina. A quantidade
	 * começa como 0 e as adições são cumulativas.
	 */
	private int horas = 0;
	/**
	 * Array de inteiros que guarda o peso de cada prova. Tem o mesmo tamanho do array
	 * de notas e as posições se relacionam (notas[x] tem peso pesos[x]).
	 */
	private int[] pesos;
	
	/**
	 * Constrói um objeto disciplina a partir do nome dela. Cria o array de notas com
	 * o tamanho padrão (4) e preenche todas as posições com a nota 0. Também cria o
	 * array de pesos com o tamanho padrão, preenchendo todos os pesos como 1.
	 * 
	 * @param nomeDisciplina o nome que identifica a disciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.disciplina = nomeDisciplina;
		
		this.notas = new double[4];
		for (int i = 0; i < 4; i++) {
			this.notas[i] = 0;
		}
		
		this.pesos = new int[4];
		for (int i = 0; i < 4; i++) {
			this.pesos[i] = 1;
		}
	}
	 /**
	 * Constrói um objeto disciplina a partir do nome dela e a quantidade de notas. 
	 * Cria o array de notas com o tamanho dado como parâmetro e preenche todas 
	 * as posições com a nota 0. Também cria o array de pesos com o tamanho indicado,
	 * preenchendo todos os pesos como 1.
	 * 
	 * @param nomeDisciplina o nome que identifica a disciplina
	 * @param numeroNotas o número de provas que serão feitas e, portanto, o número
	 * de notas que devem ser cadastradas
	 */
	public Disciplina(String nomeDisciplina, int numeroNotas) {
		this.disciplina = nomeDisciplina;
		
		this.notas = new double[numeroNotas];
		for (int i = 0; i < numeroNotas; i++) {
			this.notas[i] = 0;
		}
		
		this.pesos = new int[numeroNotas];
		for (int i = 0; i < numeroNotas; i++) {
			this.pesos[i] = 1;
		}
	}
	
	/**
	 * Constrói um objeto disciplina a partir do nome dela, a quantidade de notas e
	 * um array contendo os pesos de cada prova. Cria o array de notas com o tamanho
	 * dado como parâmetro e preenche todas as posições com a nota 0. Também cria o
	 * array de pesos com o tamanho indicado, preenchendo todos os pesos conforme 
	 * os valores dados como parâmetro.
	 * 
	 * @param nomeDisciplina o nome que identifica a disciplina
	 * @param numeroNotas o número de provas que serão feitas e, portanto, o número
	 * de notas que devem ser cadastradas
	 * @param pesosNotas um array contento os pesos de cada prova em ordem
	 */
	public Disciplina(String nomeDisciplina, int numeroNotas, int[] pesosNotas) {
		this.disciplina = nomeDisciplina;
		
		this.notas = new double[numeroNotas];
		for (int i = 0; i < numeroNotas; i++) {
			this.notas[i] = 0;
		}
		
		this.pesos = new int[numeroNotas];
		for (int i = 0; i < numeroNotas; i++) {
			this.pesos[i] = pesosNotas[i];
		}
	}
	
	/**
	 * Método set genérico. Atualiza o número de horas dedicadas de forma cumulativa.
	 * 
	 * @param Horas o número de horas a ser adicionada ao montante já acumulado
	 */
	public void cadastraHoras(int Horas) {
		this.horas += Horas;
	}
	
	/**
	 * Método set genérico. Cadastra a nota na posição indicada.
	 * 
	 * @param nota a posição da nota a ser cadastra. Devido ao array começar no index
	 * 0, retira-se uma unidade da posição para guardá-lo no local correto dentro do
	 * array
	 * @param valorNota a nota a ser guardada
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	/**
	 * Método que chama um método privado para fazer a conta da média e devolve um
	 * valor verdade se o aluno foi aprovado ou não, considerando a média igual a 7.
	 * 
	 * @return Valor verdade se o aluno foi aprovado ou não
	 */
	public boolean aprovado() {
		return (calculaMedia() >= 7);
	}
	
	private double calculaMedia() {
		double totalNotas = 0;
		int totalPesos = 0;
		for (int i = 0; i < this.notas.length; i++) {
			totalNotas += this.notas[i] * this.pesos[i];
			totalPesos += this.pesos[i];
		}
		return totalNotas / totalPesos;
	}
	
	/**
	 * Retorna a String que representa a disciplina. A representação segue o formato
	 * "Nome da disciplina Horas dedcicadas Valor verdade da aprovação Array de notas"
	 */
	@Override
	public String toString() {
		return this.disciplina + " " + this.horas + " " + calculaMedia() + " " + Arrays.toString(this.notas);
	}
}