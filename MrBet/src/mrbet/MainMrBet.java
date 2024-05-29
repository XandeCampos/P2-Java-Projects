package mrbet;

import java.util.Scanner;

public class MainMrBet {

	public static void main(String[] args) {
		MrBetSistema bet = new MrBetSistema();
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, bet, scanner);
		}

	}
	
	private static String menu(Scanner scanner) {
		System.out.print( 
						"\n(M)Minha inclusão de times\n" + 
						"(R)Recuperar times\n" + 
						"(.)Adicionar campeonato\n" + 
						"(B)Bora incluir times no campeonato ou Verificar se o time está em campeonato\n" + 
						"(E)Exibir campeonatos que o time participa\n" +
						"(T)Tentar a sorte e status\n" +
						"(!)Já pode fechar o programa!\n" + 
						"(H) Histórico\n" + 
						"\n" + 
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}
	
	private static void comando(String opcao, MrBetSistema bet, Scanner scanner) {
		String decisaoIntermed;
		switch (opcao) {
		case "M":
			incluirTimes(bet, scanner);
			break;
		case "R":
			recuperarTimes(bet, scanner);
			break;
		case ".":
			adicionarCampeonato(bet, scanner);
			break;
		case "B":
			System.out.println("(I) Incluir times em campeonato ou (V) Verificar se o time está em campeonato? ");
			decisaoIntermed = scanner.nextLine().toUpperCase();
			if (decisaoIntermed.equals("I")) {
				incluirTimeCampeonato(bet, scanner);
			} else if (decisaoIntermed.equals("V")) {
				verificarTimeEmCampeonato(bet, scanner);
			}
			break;
		case "E":
			exibirCampeonatosTime(bet, scanner);
			break;
		case "T":
			System.out.println("(A) Apostar ou (S) Status das Apostas? ");
			decisaoIntermed = scanner.nextLine().toUpperCase();
			if (decisaoIntermed.equals("A")) {
				apostar(bet, scanner);
			} else if (decisaoIntermed.equals("S")) {
				statusApostas(bet);
			}
			break;
		case "H":
			exibirHistorico(bet);
			break;
		case "!":
			fechaPrograma();
			break;
			
	}
	}
	
	private static void incluirTimes(MrBetSistema bet, Scanner sc) {
		System.out.print("Código: ");
		String codigo = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Mascote: ");
		String mascote = sc.nextLine();
		System.out.println(bet.adicionaTime(codigo, nome, mascote));
	}
	
	private static void recuperarTimes(MrBetSistema bet, Scanner sc) {
		System.out.print("Código: ");
		String codigo = sc.nextLine();
		System.out.println(bet.getTime(codigo));
	}
	
	private static void adicionarCampeonato(MrBetSistema bet, Scanner sc) {
		System.out.print("Campeonato: ");
		String campeonato = sc.nextLine();
		System.out.print("Participantes: ");
		int participantes = sc.nextInt();
		sc.nextLine();
		System.out.println(bet.adicionaCampeonato(campeonato, participantes));
	}
	
	private static void incluirTimeCampeonato(MrBetSistema bet, Scanner sc) {
		System.out.print("Código: ");
		String idTime = sc.nextLine();
		System.out.print("Campeonato: ");
		String idCampeonato = sc.nextLine();
		System.out.println(bet.adicionaTimeEmCampeonato(idTime, idCampeonato));
	}
	
	private static void verificarTimeEmCampeonato(MrBetSistema bet, Scanner sc) {
		System.out.print("Código: ");
		String idTime = sc.nextLine();
		System.out.print("Campeonato: ");
		String idCampeonato = sc.nextLine();
		System.out.println(bet.verificaTimeEmCampeonato(idTime, idCampeonato));
	}
	
	private static void exibirCampeonatosTime(MrBetSistema bet, Scanner sc) {
		System.out.print("Time: ");
		String idTime = sc.nextLine();
		System.out.println(bet.exibeCampeonatosTime(idTime));
	}
	
	private static void apostar(MrBetSistema bet, Scanner sc) {
		System.out.print("Código: ");
		String idTime = sc.nextLine();
		System.out.print("Campeonato: ");
		String idCampeonato = sc.nextLine();
		System.out.print("Colocação: ");
		int colocacao = sc.nextInt();
		sc.nextLine();
		System.out.print("Valor da aposta: R$");
		float valor = sc.nextFloat();
		sc.nextLine();
		System.out.println(bet.criaAposta(idTime, idCampeonato, colocacao, valor));
	}
	
	private static void statusApostas(MrBetSistema bet) {
		System.out.println("Apostas: \n");
		System.out.println(bet.exibeStatusApostas());
	}
	
	private static void fechaPrograma() {
		System.out.println("Por hoje é só, pessoal!");
		System.exit(0);
	}
	
	private static void exibirHistorico(MrBetSistema bet) {
		System.out.println("Participação mais frequente em campeonatos: ");
		System.out.println(bet.maisFrequenteEmCampeonato());
		System.out.print("Ainda não pariticipou de campeonato: ");
		System.out.println(bet.naoParticipouCampeonato());
		System.out.print("Popularidade em apostas: ");
		System.out.println(bet.popularidadeApostas());
	}
}











