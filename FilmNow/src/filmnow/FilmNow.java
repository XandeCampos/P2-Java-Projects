package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author eliane
 *
 */
public class FilmNow {
	
	private static final int TAMANHO = 100;
	
	private Filme[] filmes;
	private HotList hotlist;

	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
		this.hotlist = new HotList();
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return O array de filmes.
	 */
	public Filme[] getFilmes() {
		return this.filmes.clone();
	}
	
	/**
	 * Acessa a classe HotList e devolve a lista de filmes adicionados formatados com "posição - nome".
	 * @return Uma String com os filmes da HotList.
	 */
	public String getHotList() {
		String listagemHot = "";
		for (int i = 0; i < hotlist.getHotList().length; i++) {
			if (hotlist.getHotList()[i] != null) {
				listagemHot += ("\n" + formataHot(i, hotlist.getHotList()[i]));
			}
		}
		return listagemHot;
	}
	
	private static String formataHot(int posicao, Filme filme) {
		return (posicao + 1) + " - " + filme.getNome();
	}

	/**
	 * Acessa os dados de um filme específico.
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 */
	public String detalharFilme(int posicao) {
		if (verificaPosicaoInvalida(posicao)) {
			return "POSIÇÃO INVÁLIDA";
		} else if (filmes[posicao - 1] == null) {
			return "POSIÇÃO INVÁLIDA";
		}
		return filmes[posicao - 1].toString();
	}
	
	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior. 
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme pode ser assitido.
	 */
	public String adicionaFilme(int posicao, String nome, String ano, String local) {
		Filme filme = new Filme(nome, ano, local);
		if (verificaPosicaoInvalida(posicao)) {
			return "POSIÇÃO INVÁLIDA";
		} else if (verificaFilmeRepetido(filme)) {
			return "FILME JÁ ADICIONADO";
		} else if (verificaNomeOuLocalVazio(nome, local)) {
			return "FILME INVALIDO";
		} else {
		this.filmes[posicao - 1] = filme;
		return "FILME ADICIONADO";
		}
	}
	
	private boolean verificaPosicaoInvalida(int posicao) {
		if (posicao > 100 || posicao < 1) {
			return true;	
		}
		return false;
	}

	private boolean verificaFilmeRepetido(Filme filme) {
		for (int i = 0; i < TAMANHO; i++) {
			if (filme.equals(filmes[i])) {
				return true;
			}
		}
		return false;
	}
	
	private boolean verificaNomeOuLocalVazio(String nome, String local) {
		if (nome == "" || local == "") {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Adiciona filmes na HotList.
	 * @param posicaoFilme Posição no Array de Filmes do filme que será adicionado na HotList.
	 * @param posicaoHot Posição da HotList que o filme será adicionado.
	 * @return String que indica o resultado da tentativa de adição do filme.
	 */
	public String adicionaHot(int posicaoFilme, int posicaoHot) {
		Filme filme = filmes[posicaoFilme - 1];
		return hotlist.adicionaFilmeHot(filme, posicaoHot);
	}
	
	/**
	 * Remove um filme da HotList.
	 * @param posicaoHot Posição na HotList do filme que deve ser removido.
	 */
	public void removeHot(int posicaoHot) {
		this.hotlist.removeFilmeHot(posicaoHot);		
	}
}
