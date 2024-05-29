package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MrBetSistemaTest {
	private MrBetSistema bet;
	
	@BeforeEach
	void setUp() {
	this.bet = new MrBetSistema();
	bet.adicionaTime("001_RJ", "Fluminense", "Guerreiro");
	bet.adicionaTime("002_PB", "Treze", "Galo");
	bet.adicionaTime("003_MC", "Manchester City", "Veleiro");
	bet.adicionaCampeonato("Brasileirão Série A 2024", 20);
	bet.adicionaCampeonato("Campeonato Paraibano 2024", 2);
	}
	
	@Test
	void testAdicionaTime() {
		assertEquals("INCLUSÃO REALIZADA!", bet.adicionaTime("004_RJ", "Volta Redonda", "Voltasso"));
	}
		
	@Test
	void testAdicionaTimeRepeticao() {
		assertEquals("TIME JÁ EXISTE!", bet.adicionaTime("001_RJ", "Fluminense", "Guerreiro"));
	}
	
	@Test
	void testGetTime() {
		assertEquals("[001_RJ] Fluminense / Guerreiro", bet.getTime("001_RJ"));
	}
	
	@Test
	void testGetTimeNaoExiste() {
		assertEquals("TIME NÃO EXISTE!", bet.getTime("[002_RJ]"));
	}
	
	@Test
	void testAdicionaCampeonato() {
		assertEquals("CAMPEONATO ADICIONADO!", bet.adicionaCampeonato("Premier League", 18));
	}
	
	@Test
	void testAdicionaCampeonatoRepeticao() {
		assertEquals("CAMPEONATO JÁ EXISTE!", bet.adicionaCampeonato("Brasileirão Série A 2024", 20));
		assertEquals("CAMPEONATO JÁ EXISTE!", bet.adicionaCampeonato("brasileirão série a 2024", 10));
	}
	
	@Test
	void testAdicionaTimeEmCampeonato() {
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", bet.adicionaTimeEmCampeonato("001_RJ", "Brasileirão Série A 2024"));	
	}
	
	@Test
	void testAdicionaTimeEmCampeonatoTimeNaoExiste() {
		try {
			bet.adicionaTimeEmCampeonato("123_ES", "brasileirão Série A 2024");
	}
		catch (NullPointerException npe) {
			assertEquals("O TIME NÃO EXISTE!", npe.getMessage());
		}
	}

	@Test
	void testAdicionaTimeEmCampeonatoCampeonatoNaoExiste() {
		try {
			bet.adicionaTimeEmCampeonato("001_RJ", "brasileirão Série B 2024");
	}
		catch (NullPointerException npe) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", npe.getMessage());
		}
	}
	
	@Test
	void testAdicionaTimeEmCampeonatoPreenchido() {
		bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024");
		bet.adicionaTimeEmCampeonato("002_PB", "Campeonato Paraibano 2024");
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", bet.adicionaTimeEmCampeonato("003_MC", "Campeonato Paraibano 2024"));
	}
	
	@Test
	void testAdicionaTimeEmCampeonatoTimeRepetido() {
		bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024");
		String participantesCampeonatoAntes = bet.getTime("001_RJ").toString();
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024"));
		assertEquals(participantesCampeonatoAntes, bet.getTime("001_RJ").toString());
	}
	
	@Test
	void testVerificaTime() {
		bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024");
		assertEquals("O TIME ESTÁ NO CAMPEONATO!", bet.verificaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024"));
	}
	
	@Test
	void testVerificaTimeNaoEsta() {
		bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024");
		assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", bet.verificaTimeEmCampeonato("002_PB", "Campeonato Paraibano 2024"));
	}
	
	@Test
	void testVerificaTimeCampeonatoNaoExiste() {
		try {
			bet.verificaTimeEmCampeonato("001_RJ", "Campeonato Catarinense 2024");
		}
		catch (NullPointerException npe) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", npe.getMessage());
		}
	}
	
	@Test
	void testVerificaTimeNaoExiste() {
		try {
			bet.verificaTimeEmCampeonato("054_RJ", "Campeonato Paraibano 2024");
		}
		catch (NullPointerException npe) {
			assertEquals("O TIME NÃO EXISTE!", npe.getMessage());
		}
	}
	
	@Test
	void testExibeCampeonatosTime() {
		bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024");
		bet.adicionaTimeEmCampeonato("001_RJ", "Brasileirão Série A 2024");
		assertEquals("\nCampeonatos do Fluminense:\n* Campeonato Paraibano 2024 - 1/2\n* Brasileirão Série A 2024 - 1/20", bet.exibeCampeonatosTime("001_RJ"));
	}
	
	@Test
	void testExibeCampeonatosTimeNaoExiste() {
		try {
			bet.exibeCampeonatosTime("142_DF");
		}
		catch (NullPointerException npe) {
			assertEquals("O TIME NÃO EXISTE!", npe.getMessage());
		}
	}
	
	@Test
	void testCriaAposta() {
		bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024");
		assertEquals("APOSTA REGISTRADA!", bet.criaAposta("001_RJ", "Campeonato Paraibano 2024", 1, 15.00));
	}
	
	@Test
	void testCriaApostaTimeNaoExiste() {
		try {
			bet.criaAposta("024_RJ", "Campeonato Paraibano 2024", 1, 15.00);
		}
		catch (NullPointerException npe) {
			assertEquals("O TIME NÃO EXISTE!", npe.getMessage());
		}
	}
	
	@Test
	void testCriaApostaCampeonatoNaoExiste() {
		try {
			bet.criaAposta("001_RJ", "Campeonato Paraibano Série B 2024", 1, 15.00);
		}
		catch (NullPointerException npe) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", npe.getMessage());
		}
	}
	
	@Test
	void testCriaApostaColocacaoInvalida() {
		assertEquals("APOSTA NÃO REGISTRADA!", bet.criaAposta("001_RJ", "Campeonato Paraibano 2024", 4, 15.00));
	}
	
	@Test
	void testExibeStatusApostas() {
		bet.criaAposta("001_RJ", "Campeonato Paraibano 2024", 1, 15.00);
		assertEquals("\n1. [001_RJ] Fluminense / Guerreiro\nCampeonato Paraibano 2024\n1/2\nR$ 15,00", bet.exibeStatusApostas());
	}
	
	@Test
	void testMaisFrequenteEmCampeonatoUmMaior() {
		bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024");
		assertEquals("[001_RJ] Fluminense / Guerreiro 1\n", bet.maisFrequenteEmCampeonato());
	}
	
	@Test
	void testMaisFrequenteEmCampeonatoEmpate() {
		bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024");
		bet.adicionaTimeEmCampeonato("002_PB", "Campeonato Paraibano 2024");
		assertEquals("[001_RJ] Fluminense / Guerreiro 1\n[002_PB] Treze / Galo 1\n", bet.maisFrequenteEmCampeonato());
	}
	
	@Test
	void testMaisFrequenteEmCampeonatoEmpateEm0() {
		assertEquals("[001_RJ] Fluminense / Guerreiro 0\n[003_MC] Manchester City / Veleiro 0\n[002_PB] Treze / Galo 0\n", bet.maisFrequenteEmCampeonato());
	}
	
	@Test
	void testNaoParticipouCampeonato() {
		assertEquals("\n[001_RJ] Fluminense / Guerreiro\n[003_MC] Manchester City / Veleiro\n[002_PB] Treze / Galo", bet.naoParticipouCampeonato());
	}
	
	@Test
	void testNaoParticipouCampeonatoVazio() {
		bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024");
		bet.adicionaTimeEmCampeonato("002_PB", "Campeonato Paraibano 2024");
		bet.adicionaTimeEmCampeonato("003_MC", "Brasileirão Série A 2024");
		assertEquals("", bet.naoParticipouCampeonato());
	}
	
	@Test
	void testPopularidadeApostas() {
		bet.adicionaTimeEmCampeonato("001_RJ", "Campeonato Paraibano 2024");
		bet.adicionaTimeEmCampeonato("002_PB", "Campeonato Paraibano 2024");
		bet.adicionaTimeEmCampeonato("003_MC", "Campeonato Paraibano 2024");
		bet.adicionaTimeEmCampeonato("003_MC", "Brasileirão Série A 2024");
		bet.criaAposta("001_RJ", "Campeonato Paraibano 2024", 1, 43.50);
		bet.criaAposta("002_PB", "Campeonato Paraibano 2024", 2, 43.50);
		bet.criaAposta("003_MC", "Campeonato Paraibano 2024", 1, 43.30);
		bet.criaAposta("003_MC", "Brasileirão Série A 2024", 1, 43.70);
		assertEquals("\nFluminense / 1\nManchester City / 2", bet.popularidadeApostas());
	}
 }