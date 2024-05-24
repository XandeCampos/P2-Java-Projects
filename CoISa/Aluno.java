package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Representação de um estudante, especificamente de computação, matriculado da * UFCG. Todo aluno precisa ter uma matrícula e é identificado unicamente
* por esta matrícula.
* 
* @author Alexandre Campos
*/
public class Aluno {
	/**
	* Nome do aluno. Guardado como uma única String contendo os espaços entre os nomes.
	*/
	private String nome;
	/**
	 * Ano de Nascimento do aluno. Guardado como um inteiro.
	 */
	private int anoNascimento;
	/**
	 * Coeficiente de Rendimento do Aluno. Guarda a média das notas do aluno, indica seu aproveitamento.
	 */
	private double cra;
	
	/**
	* Constrói um aluno a partir de seu nome e ano de nascimento.
	* Todo aluno começa com o campo CRA como nulo.
	*
	* @param matricula a matrícula do aluno, no formato “0000000000”
	* @param nome o nome do aluno
	*/
	public Aluno(String nome, int anoNascimento) {
		this.nome = nome;
		this.cra = 0.0;
		this.anoNascimento = anoNascimento;
	}
	
	/**
	 * Modifica o cra do aluno. Método público, de forma que a variável cra é privada, mas o main consegue alterá-la
	 * por esse método.
	 * Todo aluno comeca com o cra igual a 0.0
	 * @param cra o Coeficiente de Rendimento do Aluno.
	 */
	public void setCra(double cra) {
		this.cra = cra;
	}
	
	/**
	 * Retorna o int que representa a idade do aluno, através da subtracao do ano atual com o ano de nascimento fornecido
	 * @return a representacao em int da idade do aluno
	 */
	public int getIdade() {
		return 2024 - anoNascimento;
	}

	/**
	 * Retorna a String que representa o nome do aluno.
	 * @return a representacao em String de um aluno.
	 */
	public String toString() {
		return "Aluno - "  + this.nome;
	}
}
