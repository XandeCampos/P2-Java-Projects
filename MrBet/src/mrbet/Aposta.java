package mrbet;

/**
 * Representação de uma aposta. Toda aposta tem um time, um campeonato, uma colocacao e um valor a ser apostado.
 */
public class Aposta {
	/**
	 * Time a qual a aposta se refere.
	 */
	private Time time;
	/**
	 * Campeonato a qual a aposta se refere.
	 */
	private Campeonato campeonato;
	/**
	 * Colocacao que se espera que o time termine o campeonato.
	 */
	private int colocacao;
	/**
	 * Valor que será apostado no time.
	 */
	private double valor;
	
	/**
	 * Constrói uma aposta a partir do time, do campeonato, da colocacao e do valor apostado.
	 * 
	 * @param time o time em que foi apostado.
	 * @param campeonato o campeonato a qual se refere a aposta.
	 * @param colocacao a colocação que se espera que o time termine o campeonato.
	 * @param valor o valor apostado no time.
	 */
	public Aposta(Time time,Campeonato campeonato, int colocacao, double valor) {
		this.time = time;
		this.campeonato = campeonato;
		this.colocacao = colocacao;
		this.valor = valor;
	}
	
	/**
	 * Retorna a representação textual da aposta.
	 * 
	 * @return representação textual da aposta no formato 
	 * "Representação do time
	 *  Nome do campeonato
	 *  ColocaçãoEsperada/ParticipantesMaximoDoCampeonato
	 *  R$ValorApostado"
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(time.toString());
		sb.append("\n" + campeonato.getNome());
		sb.append("\n" + colocacao + "/" + campeonato.getParticipantes());
		sb.append(String.format("\nR$ %.2f", valor));
		return sb.toString();
	}
}