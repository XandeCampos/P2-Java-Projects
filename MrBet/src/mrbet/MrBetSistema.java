package mrbet;

import java.util.*;

/**
 * Sistema Controller do MrBet. Recebe as interações do Main e devolve o que precisa ser retornado ao usuário, evitando que
 * o Main tenha conhecimento das classes de lógica e/ou guarde informações.
 * 
 * @author Alexandre Campos
 */
public class MrBetSistema {
	/**
	 * HashMap que guarda os times cadastrados no sistema no formato String com o código do time(chave) - Objeto da classe Time(valor).
	 * O uso do HashMap se da devido a necessidade de fazer acessos frequentes ao time recebendo seu código como parâmetro.
	 */
	private HashMap<String, Time> mapaCodigoTime;
	/**
	 * HashMap que guarda os campeonatos cadastrados no sistema no formato String com o nome do campeonato(chave) - Objeto da classe Campeonato(valor).
	 * O uso do HashMap se da devido a necessidade de fazer acessos frequentes ao time recebendo seu nome como parâmetro.
	 */
	private HashMap<String, Campeonato> mapaNomeCampeonato;
	/**
	 * ArrayList que guarda as apostas registradas pelo usuário na ordem em que foram feitas.
	 * O uso do ArrayList se da devido a necessidade de saber a ordem de inserção das apostas e da não existência de um limite
	 * no número de apostas.
	 */
	private ArrayList<Aposta> listaApostas;
	
	/**
	 * Construtor da classe MrBetSistema, invocado apenas no Main. Instancia as coleções que serão usadas.
	 */
	public MrBetSistema() {
		this.mapaCodigoTime = new HashMap<>();
		this.mapaNomeCampeonato = new HashMap<>();
		this.listaApostas = new ArrayList<>();
	}
	
	/**
	 * Adiciona um time ao sistema a partir de seu código, do seu nome e do seu mascote.
	 * Antes de adicicionar, verifica se o time já foi previamente adicionado ao sistema, a fim de evitar repetições.
	 * 
	 * @param idTime código de identificação do time no formato XXX_UF (onde XXX é um código numérico e UF é o Estado em que se baseia o time).
	 * @param nome nome do clube.
	 * @param mascote mascote do clube.
	 * @return mensagem que indica se o time foi adicionado ou se já existia.
	 */
	public String adicionaTime(String idTime, String nome, String mascote) {
		if (timeJaExiste(idTime)) {
			return "TIME JÁ EXISTE!";
		} else {
			Time time = new Time(idTime, nome, mascote);
			this.mapaCodigoTime.put(idTime, time);
			return "INCLUSÃO REALIZADA!"; 
		}
	}
	
	/**
	 * Método get padrão, com o adicional de verificar se o time não existe e retornar uma mensagem ao invés de um NullPointerException.
	 * 
	 * @param idTime código do time a ser acessado.
	 * @return mensagem avisando que o time não existe ou a representação em String do time acessado.
	 */
	public String getTime(String idTime) {
		if (!timeJaExiste(idTime)) {
			return "TIME NÃO EXISTE!";
		} else {
			return mapaCodigoTime.get(idTime).toString();
		}
	}
	
	/**
	 * Adiciona um campeonato ao sistema a partir do seu nome e número de participantes máximo.
	 * Antes de adicicionar, verifica se o campeonato já foi previamente adicionado ao sistema, a fim de evitar repetições.
	 * O nome do campeonato é salvo como chave no HashMap mapaNomeCampeonato com todos os caracteres minúsculos a fim de evitar que o
	 * método de acesso ao campeonato se torne case-sensitive. O objeto, por outro lado, é guardado conforme fora escrito na entrada pelo
	 * usuário para fins de representações textuais.
	 * 
	 * @param idCampeonato nome do campeonato.
	 * @param participantes número máximo de times diferentes que poderá ser cadastrado nesse campeonato.
	 * @return mensagem avisando que o campeonato foi corretamente adicionado ao sistema ou se já existia previamente.
	 */
	public String adicionaCampeonato(String idCampeonato, int participantes) {
		if (campeonatoJaExiste(idCampeonato)) {
			return "CAMPEONATO JÁ EXISTE!";
		} else {
			Campeonato campeonato = new Campeonato(idCampeonato, participantes);
			this.mapaNomeCampeonato.put(idCampeonato.toLowerCase(), campeonato);
			return "CAMPEONATO ADICIONADO!";
		}
	}
	
	private boolean timeJaExiste(String idTime) {
		return (mapaCodigoTime.containsKey(idTime));
	}
	
	private boolean campeonatoJaExiste(String idCampeonato) {
		return (mapaNomeCampeonato.containsKey(idCampeonato.toLowerCase()));
	}
	
	private Time pegaTime(String idTime) throws NullPointerException {
		if (timeJaExiste(idTime)) {
			return mapaCodigoTime.get(idTime);
		} else {
			throw new NullPointerException("O TIME NÃO EXISTE!");
		}
	}
	
	private Campeonato pegaCampeonato(String idCampeonato) throws NullPointerException {
		if (campeonatoJaExiste(idCampeonato)) {
			return mapaNomeCampeonato.get(idCampeonato.toLowerCase());
		} else {
			throw new NullPointerException("O CAMPEONATO NÃO EXISTE!");
		}
	}
	
	/**
	 * Adiciona um time aos participantes de um campeonato. Verifica a existência do time e do campeonato no sistema antes de tentar realizar a adição.
	 * 
	 * @param idTime código que identifica o time no sistema.
	 * @param idCampeonato nome do campeonato (identificação única deste no sistema).
	 * @return mensagem que avisa se o time foi corretamente adicionado ao campeonato ou se o campeonato já preencheu todos as suas vagas.
	 * @throws NullPointerException caso o time ou o campeonato não existam no sistema. Tanto o time quanto o campeonato inexistentes tem sua própria mensagem de erro.
	 */
	public String adicionaTimeEmCampeonato(String idTime, String idCampeonato) throws NullPointerException {
		Time time = pegaTime(idTime);
		Campeonato campeonato = pegaCampeonato(idCampeonato);
		String mensagem = campeonato.adicionaTime(time);
		if (mensagem.equals("TIME INCLUÍDO NO CAMPEONATO!")) {
			time.adicionaCampeonato(campeonato.toString());
		}
		return mensagem;
	}
	
	/**
	 * Verifica se um time está entre os participantes de um campeonato. Verifica antes se o time existe no sistema.
	 * 
	 * @param idTime código que identifica um time no sistema.
	 * @param idCampeonato nome do campeonato (identificação única deste no sistema).
	 * @return mensagem que diz se o time está ou não no campeonato.
	 * @throws NullPointerException caso o time ou o campeonato não existam no sistema. Tanto o time quanto o campeonato inexistentes tem sua própria mensagem de erro.
	 */
	public String verificaTimeEmCampeonato(String idTime, String idCampeonato) throws NullPointerException {
		Time time = pegaTime(idTime);
		Campeonato campeonato = pegaCampeonato(idCampeonato);
		
		return campeonato.verificaTime(time);
	}
	
	/**
	 * Exibe os campeonatos nos quais dado time participa.
	 * @param idTime código que identifica um time no sistema.
	 * @return representação em String dos campeonatos que o time participa.
	 */
	public String exibeCampeonatosTime(String idTime) throws NullPointerException {
		Time time = pegaTime(idTime);
		return time.stringCampeonatosDoTime();
	}
	
	/**
	 * Adiciona uma aposta ao sistema. Verifica a existência do time e do campeonato no sistema antes de realizar a adição.
	 * Se o usuário tentar apostar que um time terminará em uma colocação menor ou igual a 0, ou maior que o total de participantes
	 * possíveis do campeonato, a aposta não é registrada.
	 * Se o usuário apostar que um time terminará em primeiro colocado, o número de favoritoAposta é atualizado no time em questão.
	 * 
	 * @param idTime código que identifica um time no sistema.
	 * @param idCampeonato nome do campeonato (identificação única deste no sistema).
	 * @param colocacao a colocação que usuário aposta que o time terminará o campeonato.
	 * @param valor o valor que o usuário deseja apostar.
	 * @return mensagem que indica se a aposta foi registrada ou não.
	 * @throws NullPointerException caso o time ou o campeonato não existam no sistema. Tanto o time quanto o campeonato inexistentes tem sua própria mensagem de erro.
	 */
	public String criaAposta(String idTime, String idCampeonato, int colocacao, double valor) throws NullPointerException {
		Time time = pegaTime(idTime);
		Campeonato campeonato = pegaCampeonato(idCampeonato);
		
		if (colocacao > campeonato.getParticipantes() || colocacao <= 0) {
			return "APOSTA NÃO REGISTRADA!";
		} else {
			Aposta aposta = new Aposta(time, campeonato, colocacao, valor);
			this.listaApostas.add(aposta);
			if (colocacao == 1) {
				time.atualizaFavoritoAposta();
			}
			return "APOSTA REGISTRADA!";
		}
	}
	
	/**
	 * Exibe as apostas feitas pelo usuário na ordem em que foram inseridas no sistema.
	 * 
	 * @return representação em String das apostas registradas.
	 */
	public String exibeStatusApostas() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < listaApostas.size(); i++) {
			Aposta a = listaApostas.get(i);
			sb.append("\n" + (i + 1) + ". " + a.toString());
		}
		return sb.toString();
	}
	
	/**
	 * Calcula e exibe o time que participa de mais campeonatos.
	 * Em caso de empate na quantidade, são exibidos todos os times que pariticipam daquela quantidade de campeonatos.
	 * 
	 * @return representação em String do(s) time(s) que participa(m) de mais campeonatos junto a quantidade destes.
	 */
	public String maisFrequenteEmCampeonato() {
		int maiorQtd = 0;
		for (Time t : mapaCodigoTime.values()) {
			if (t.qtdCampeonatosDoTime() > maiorQtd) {
				maiorQtd = t.qtdCampeonatosDoTime();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Time t : mapaCodigoTime.values()) {
			if (t.qtdCampeonatosDoTime() == maiorQtd) {
				sb.append(t.toString() + " " + maiorQtd + "\n");
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * Procura e exibe qual time não participa de nenhum campeonato.
	 * Em caso de mais de um time não participar de nenhum, são exibidos todos os que não participam.
	 * 
	 * @return representação em String dos times achados.
	 */
	public String naoParticipouCampeonato() {
		StringBuilder sb = new StringBuilder();
		for (Time t : mapaCodigoTime.values()) {
			if (t.qtdCampeonatosDoTime() == 0) {
				sb.append("\n" + t.toString());
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * Calcula e exibe quais time receberam apostas como favoritos (isto é, apostas com colocacao == 1).
	 * 
	 * @return representação em String dos times junto a quantidade de apostas em que são favoritos.
	 */
	public String popularidadeApostas() {
		StringBuilder sb = new StringBuilder();
		for (Time t : mapaCodigoTime.values()) {
			if (t.getFavoritoAposta() >= 1) {
				sb.append("\n" + t.getNome() + " / " + t.getFavoritoAposta());
			}
		}
		return sb.toString();
	}
}