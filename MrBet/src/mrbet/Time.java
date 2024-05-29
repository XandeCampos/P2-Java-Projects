package mrbet;

import java.util.*;

/**
 * Representação de um time. Todo time tem um código que o identifica unicamente no sistema
 * , um nome, um mascote, um ArrayList de campeonatos que participa e um contador de quantas
 * vezes foi apostado como o favorito em um campeonato.
 */
public class Time {
	/**
	 * Código que identifica unicamente o time no sistema. No formato XXX_UF (onde XXX é um código numérico e UF é o Estado em que se baseia o time).
	 */
	private String id;
	/**
	 * Nome do time.
	 */
	private String nome;
	/**
	 * Mascote do time.
	 */
	private String mascote;
	/**
	 * ArrayList que guarda a representação textual dos campeonatos que o time participa.
	 * O uso do ArrayList se da devido à necessidade de saber a ordem cronológica de inserção do time nos campeonatos
	 * e à inexistência de um número máximo de campeonatos que um time pode participar.
	 */
	private ArrayList<String> campeonatos;
	/**
	 * Contador que guarda a quantidade de vezes que um time foi o favorito em uma aposta.
	 */
	private int favoritoAposta;
	
	/**
	 * Constrói um time a partir do código, nome e mascote.
	 * Todo time começa com o contador de favoritos zerado.
	 * 
	 * @param id código que identifica o time.
	 * @param nome nome do time.
	 * @param mascote mascote do time.
	 */
	public Time(String id, String nome, String mascote) {
		this.id = id;
		this.nome = nome;
		this.mascote = mascote;
		this.campeonatos = new ArrayList<>();
		this.favoritoAposta = 0;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getNomeMascote() {
		return nome + " | " + mascote;
	}
	
	/**
	 * Método equals padrão. Compara os objetos pelo id.
	 * 
	 * @return boolen que indica se os objetos são iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}
	
	/**
	 * Retorna a representação textual do time.
	 * 
	 * @return a representação textual no formato "[codigo] nome / mascote".
	 */
	@Override
	public String toString() {
		return "[" + id + "] " + nome + " / " + mascote;
	}
	
	/**
	 * Adiciona a representação textual de um campeonato ao ArrayList.
	 * @param campeonato
	 */
	public void adicionaCampeonato(String campeonato) {
		this.campeonatos.add(campeonato);
	}
	
	/**
	 * Monta e devolve a representação textual dos campeonatos que o time participa.
	 * 
	 * @return representação textual dos campeonatos que o time participa.
	 */
	public String stringCampeonatosDoTime() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nCampeonatos do " + nome + ":");
		for (String c : campeonatos) {
			sb.append("\n" + c);
		}
		return sb.toString();
	}
	
	public int qtdCampeonatosDoTime() {
		return campeonatos.size();
	}
	
	public void atualizaFavoritoAposta() {
		this.favoritoAposta++;
	}
	
	public int getFavoritoAposta() {
		return this.favoritoAposta;
	}
}