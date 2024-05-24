package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Classe Coisa que representa a interface de uso do aluno
 */
public class Coisa {
	
	/**
	 * Main que registra as informações do aluno.
	 * 
	 * @param args parâmetro genérico de um main
	 */
	public static void main(String[] args) {
		registrarDescanso();
		System.out.println("-----");
		registrarTempoOnline();
		System.out.println("-----");
		controlarDisciplina();
		System.out.println("-----");
		registrarResumos();
	}
	
	/**
	 * Método static que cria e manipula o estado um objeto da classe Descanso
	 */
	public static void registrarDescanso() {
		Descanso descanso = new Descanso();
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(30);
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(2);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());
	}
	
	/**
	 * Método static que cria e manipula o estado um objeto da classe RegistroTempoOnline
	 */
	private static void registrarTempoOnline() {
		RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
		tempoLP2.adicionaTempoOnline(10);
		System.out.println(tempoLP2.atingiuMetaTempoOnline());
		tempoLP2.adicionaTempoOnline(10);
		tempoLP2.adicionaTempoOnline(10);
		System.out.println(tempoLP2.atingiuMetaTempoOnline());
		tempoLP2.adicionaTempoOnline(2);
		System.out.println(tempoLP2.atingiuMetaTempoOnline());
		System.out.println(tempoLP2.toString());
		RegistroTempoOnline tempoP2 = new RegistroTempoOnline("P2");
		System.out.println(tempoP2.toString());
	}
	
	/**
	 * Método static que cria e manipula o estado um objeto da classe Disciplina
	 */
	private static void controlarDisciplina() {
		Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
		prog2.cadastraHoras(4);
		prog2.cadastraNota(1, 5.0);
		prog2.cadastraNota(2, 6.0);
		prog2.cadastraNota(3, 7.0);
		System.out.println(prog2.aprovado());
		prog2.cadastraNota(4, 10.0);
		System.out.println(prog2.aprovado());
		System.out.println(prog2.toString());
	}
	
	/**
	 * Método static que cria e manipula o estado um objeto da classe RegistroResumos
	 */
	private static void registrarResumos() {
		RegistroResumos meusResumos = new RegistroResumos(100);
		meusResumos.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
		meusResumos.adiciona("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");
		String[] resumos = meusResumos.pegaResumos();
		for (int i = 0; i < meusResumos.conta(); i++) {
			System.out.println(resumos[i]);
		}
		System.out.println();
		System.out.println("Resumos: ");
		System.out.println(meusResumos.imprimeResumos());
		System.out.println(meusResumos.temResumo("Classes"));
		System.out.println(meusResumos.temResumo("Objetos"));
	}
	
}
