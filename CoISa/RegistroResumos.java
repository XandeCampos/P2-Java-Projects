package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Arrays;

/**
 * Classe que guarda os resumos das matérias e opera sobre eles.
 */
public class RegistroResumos {
	/**
	 * Array de Resumos que guarda os resumos registrados pelo aluno.
	 */
	private Resumo[] resumos;
	/**
	 * Variável de controle para guardar o local em que deve ser guardado no array o
	 * próximo resumo registrado.
	 */
	private int indexNovoResumo = 0;
	 /**
	  * Constrói um array com a quantidade de resumos que o aluno pretende cadastrar.
	  * 
	  * @param numeroDeResumos o número de resumos que o aluno pretende cadastrar.
	  */
	public RegistroResumos(int numeroDeResumos) {
		this.resumos = new Resumo[numeroDeResumos];
	}
	 /**
	  * Método que cria um objeto da classe Resumo e adiciona esse ao array de resumos
	  * na posição indicada pela variável de controle indexNovoResumo, que é atualizada
	  * ao final do processo.
	  *   
	  * @param tema o título do resumo que será criado
	  * @param resumo o conteúdo do resumo que será criado
	  */
	public void adiciona(String tema, String resumo) {
		Resumo mid = new Resumo(tema, resumo);
		resumos[indexNovoResumo] = mid;
		atualizaIndex();
	}
	
	private void atualizaIndex() {
		if ((indexNovoResumo + 1) == resumos.length) {
			indexNovoResumo = 0;
		} else {
			indexNovoResumo++;
		}
	}
	
	/**
	 * Método que une o título e o conteúdo de um resumo em uma só String, e retorna
	 * um array de Strings com esses resumos concatenados.
	 * 
	 * @return um Array de Strings, no qual cada String é a concatenização do título
	 * com o conteúdo dos resumos guardados no Array de resumos
	 */
	public String[] pegaResumos() {
		String[] resumosCompletos = new String[conta()];
		for (int i = 0; i < conta(); i++) {
			resumosCompletos[i] = resumos[i].getTitulo() + ": " + resumos[i].getConteudo();
		}
		return resumosCompletos;
	}
	
	/**
	 * Conta a quantidade de resumos guardados no Array resumos.
	 * 
	 * @return a quantidade de resumos cadastrados
	 */
	public int conta() {
		int qtdResumosValidos = 0;
		for (int i = 0; i < resumos.length; i++) {
			if (!(resumos[i] == null)) {
				qtdResumosValidos++;
			} else {
				break;
			}
		}
		return qtdResumosValidos;
	}
	
	private String constroiStringTitulos() {
		String stringTitulos = resumos[0].getTitulo();
		if (conta() > 1) {
			for (int i = 1; i < conta(); i++) {
				stringTitulos += " | " + resumos[i].getTitulo();
			}
		}
		return stringTitulos;
	}
	
	/**
	 * Concatena e organiza uma String que diz o número de resumos cadastrados e seus
	 * títulos elencados.
	 * 
	 * @return Representação em String no formato "- Número de resumos resumo(s)
	 * cadastrados
	 * - títulos dos resumos"
	 */
	public String imprimeResumos() {
		return "- " + conta() + " resumo(s) cadastrado(s) \n"
				+ "- " + constroiStringTitulos();
	}
	
	/**
	 * Recebe um título e procura no Array de resumos se existe um resumo com esse
	 * título.
	 * 
	 * @param titulo o título do resumo que se procura
	 * @return Valor verdade se existe um resumo com esse título ou não
	 */
	public boolean temResumo(String titulo) {
		for (int i = 0; i < conta(); i++) {
			if (resumos[i].getTitulo().equals(titulo)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Recebe uma String e procura entre os conteudos dos resumos quais tem essa
	 * String em seu conteúdo.
	 * 
	 * @param chaveDeBusca a String a ser procurada entre os conteudos dos resumos
	 * @return Array contendo todos os resumos em que foi encontrada aquela String
	 */
	public String[] busca(String chaveDeBusca) {
		int qtdTemasCorrespondentes = 0;
		int[] indexTemasCorrespondentes = new int[resumos.length];
		for (int i = 0; i < conta(); i++) {
			if (resumos[i].getConteudo() == null) {
				break;
			}
			
			if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
				indexTemasCorrespondentes[qtdTemasCorrespondentes] = i;
				qtdTemasCorrespondentes++;
			}
		}
		
		String[] arrayTemasCorrespondentes = new String[qtdTemasCorrespondentes];
		for (int i = 0; i < qtdTemasCorrespondentes; i++) {
			arrayTemasCorrespondentes[i] = resumos[indexTemasCorrespondentes[i]].getTitulo();
			}
		
		Arrays.sort(arrayTemasCorrespondentes);
		
		return arrayTemasCorrespondentes;	
	}
}
