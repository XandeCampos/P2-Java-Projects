package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CampeonatoTest {
	private Time fluminense;
	private Time manchesterCity;
	private Time treze;
	
	@BeforeEach
	void setUp() {
		this.fluminense = new Time("001_RJ", "Fluminense", "Guerreiro");
		this.manchesterCity = new Time("002_MC", "Manchester City", "Veleiro");
		this.treze = new Time("013_PB", "Treze", "Galo");
	}

	@Test
	void testConstrutor() {
		new Campeonato("Brasileirão 2024" , 2);
	}
	
	@Test
	void testAdicionaTime() {
		Campeonato brasileiro = new Campeonato("Brasileirão 2024" , 2);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", brasileiro.adicionaTime(fluminense));	
	}
	
	@Test
	void testAdicionaTimeCampeonatoPreenchido() {
		Campeonato brasileiro = new Campeonato("Brasileirão 2024" , 2);
		brasileiro.adicionaTime(fluminense);
		brasileiro.adicionaTime(manchesterCity);
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", brasileiro.adicionaTime(treze));	
	}
	
	@Test
	void testToString() {
		Campeonato brasileiro = new Campeonato("Brasileirão 2024" , 2);
		brasileiro.adicionaTime(fluminense);
		assertEquals("* Brasileirão 2024 - 1/2", brasileiro.toString());
	}
	
	@Test
	void testVerificaTimeExiste() {
		Campeonato brasileiro = new Campeonato("Brasileirão 2024" , 2);
		brasileiro.adicionaTime(fluminense);
		assertEquals("O TIME ESTÁ NO CAMPEONATO!", brasileiro.verificaTime(fluminense));
	}
	
	@Test
	void testVerificaTimeNaoExiste() {
		Campeonato brasileiro = new Campeonato("Brasileirão 2024" , 2);
		brasileiro.adicionaTime(fluminense);
		assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", brasileiro.verificaTime(treze));
	}
	
	@Test
	void testVerificaTimeArgumentoInvalido() {
		
	}
}