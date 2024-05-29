package filmnow;

import java.util.Objects;

/**
 * Classe que modela a criação de filmes para o sistema.
 * 
 * @author Alexandre Campos
 */
public class Filme {
	private String nome;
	private String ano;
	private String local;
	private boolean hot;
	
	/**
	 * Construtor de Filme.
	 * @param nome Título do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local em que é possível assistir o filme.
	 */
	public Filme(String nome, String ano, String local) {
		this.nome = nome;
		this.ano = ano;
		this.local = local;
		this.hot = false;
	}
	
	public String nomeAno() {
		return nome + ", " + ano;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	public boolean getHot() {
		return this.hot;
	}
	public void setHot(boolean valor) {
		this.hot = valor;
	}

	/**
	 * Cria o hashcode do filme
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ano, nome);
	}

	/**
	 * Método Equals que sobrescreve o de Object. Compara pelo nome e ano.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return ano == other.ano && Objects.equals(nome, other.nome);
	}

	/**
	 * Método que sobrescreve o toString de Object. Retorna uma representação com nome, ano e local do Filme.
	 * Em caso do filme estar na HotList, recebe o emoji de fogo na frente para representar a condição de Hot.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (ano.equals("")) {		
			if (hot) {
				sb.append("\n\ud83d\udd25");
				sb.append(nome);
			}else {
				sb.append("\n" + nome);
			}
		} else {
			if (hot) {
				sb.append("\n\ud83d\udd25");
				sb.append(nome + ", " + ano);
			}else {
				sb.append("\n" + nome + ", " + ano);
			}
		}
		sb.append("\n" + local);
		return sb.toString();
	}
}
