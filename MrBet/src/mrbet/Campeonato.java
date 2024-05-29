package mrbet;

import java.util.*;

/**
 * Representação de um campeonato. Todo campeonato tem um nome que o identifica unicamente no sistema
 * , uma quantidade máxima de participantes e um HashSet de times que participam dele.
 */
public class Campeonato {
	/**
	 * HashSet que guarda os times que foram adicionados ao campeonato.
	 * A escolha do HashSet se da pela necessidade de verificar a existência ou não de um time no campeonato, sem necessidade
	 * de saber a ordem de inserção ou de acessar propriamente o time.
	 */
	private HashSet<Time> times;
	/**
	 * Nome do campeonato.
	 */
	private String nome;
	/**
	 * Quantidade máxima de times que podem ser cadastrados no sistema.
	 */
	private int participantes;
	
	/**
	 * Constrói um campeonato a partir de seu nome e número máximo de participantes.
	 * 
	 * @param nome nome do campeonato.
	 * @param participantes número máximo de participantes.
	 */
	public Campeonato(String nome, int participantes) {
		this.nome = nome;
		this.participantes = participantes;
		this.times = new HashSet<>();
	}
	
	/**
	 * Adiciona um time ao campeonato. Verifica se o campeonato já cadastrou o número máximo de participantes antes de
	 * realizar a adição.
	 * 
	 * @param t time que será adicionado.
	 * @return mensagem que indica se o time foi corretamente incluído ao campeonato ou se o número máximo de participantes
	 * já havia sido atingido.
	 */
	public String adicionaTime(Time t) { 
		if (times.size() == participantes) {
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		} else {
			this.times.add(t);
			return "TIME INCLUÍDO NO CAMPEONATO!";
		}
	}
	
	/**
	 * Retorna uma representação textual do campeonato.
	 * 
	 * @return representação textual do campeonato no formato "* nome timesCadastrados/participantesTotais".
	 */
	@Override
	public String toString() {
		return "* " + nome + " - " + times.size() + "/" + participantes;
	}
	
	/**
	 * Verifica se um dado time foi está entre os participantes do campeonato.
	 * 
	 * @param t time que se procura no campeonato.
	 * @return mensagem que diz se o time está ou não no campeonato.
	 */
	public String verificaTime(Time t) {
		if (times.contains(t)) {
			return "O TIME ESTÁ NO CAMPEONATO!";
		} else {
			return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getParticipantes() {
		return participantes;
	}
}