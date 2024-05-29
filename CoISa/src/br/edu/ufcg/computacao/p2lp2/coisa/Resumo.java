package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Representação de um resumo. Todo resumo possui um título e um conteúdo.
 * 
 * @author Alexandre Campos
 */
public class Resumo {
	/**
	 * String que diz o título do resumo.
	 */
	private String titulo;
	/**
	 * String que diz o conteúdo do resumo.
	 */
	private String conteudo;
	
	/** 
	 * Constrói um resumo a partir de seu título e conteúdo.
	 * 
	 * @param titulo o título do resumo a ser cadastrado
	 * @param conteudo o conteúdo do resumo a ser cadastrado
	 */
	public Resumo(String titulo, String conteudo) {
		this.titulo = titulo;
		this.conteudo = conteudo;
	}
	
	/**
	 * Método get genérico.
	 * 
	 * @return Devolve o título do resumo
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Método get genérico.
	 * 
	 * @return Devolve o conteúdo do resumo
	 */
	public String getConteudo() {
		return conteudo;
	}
}
