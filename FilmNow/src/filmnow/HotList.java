package filmnow;

/**
 * Classe que cria e gerencia a HotList, bem como lida com adições e remoções desta.
 * 
 * @author Alexandre Campos
 */
public class HotList {
	private static final int TAMANHO = 10;
	private Filme[] hotList;
	
	/**
	 * Cria a HotList com array de filmes com tamanho predeterminado em 10.
	 */
	public HotList() {
		this.hotList = new Filme[TAMANHO]; 
	}
	
	/**
	 * Devolve uma copia do array de filmes que compoem a HotList.
	 * @return Copia do Array de Filmes.
	 */
	public Filme[] getHotList() {
		return this.hotList.clone();
	}
	
	/**
	 * Adiciona um filme à a HotList na posição escolhida pelo usuário. Antes de adicionar, verifica se o filme já fora adicionado ou se a posição
	 * de adição na HotList é maior que o tamanho desta.
	 * @param filme O filme a ser adicionado na HotList.
	 * @param posicaoHot Posição da HotList que o filme será adicionado.
	 * @return Uma String que diz se o filme já estava na HotList, ou se a posição dada é inválida ou se o filme foi corretamente adicionado.
	 */
	public String adicionaFilmeHot(Filme filme, int posicaoHot) {
		boolean filmeRepetido = false;
		for (Filme e: hotList) {
			if (filme.equals(e)) {
				filmeRepetido = true;
				return "FILME JÁ ESTÁ NA HOTLIST!";
			}
		}
		
		if (verificaPosicaoInvalidaHot(posicaoHot)) {
			return "POSIÇÃO INVÁLIDA";
		}
		
		if (!filmeRepetido) {
			if (this.hotList[posicaoHot - 1] != null) {
				this.hotList[posicaoHot - 1].setHot(false);
			}
			this.hotList[posicaoHot - 1] = filme;
			filme.setHot(true);
		}
		return "ADICIONADO À HOTLIST NA POSIÇÃO " + (posicaoHot) + "!";
	}
	
	private boolean verificaPosicaoInvalidaHot(int posicao) {
		if (posicao > 10 || posicao < 1) {
			return true;	
		}
		return false;
	}
	
	/**
	 * Remove um filme da HotList e tira o status de Hot deste.
	 * @param posicaoHot Posição do filme que deve ser retirado da HotList.
	 */
	public void removeFilmeHot(int posicaoHot) {
		this.hotList[posicaoHot - 1].setHot(false);
		this.hotList[posicaoHot - 1] = null;
	}
}