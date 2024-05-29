package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeTest {
	private Campeonato brasileiro;
	
	@BeforeEach
	void setUp() {
		this.brasileiro = new Campeonato("Brasileirão", 20);
	}

	@Test
	void testConstrutor() {
		new Time("001_RJ", "Fluminense", "Guerreiro");
	}
	
	@Test
	void testEqualsTimesIguais() {
		Time time1 = new Time("001_RJ", "Fluminense", "Guerreiro");
		Time time2 = new Time("001_RJ", "Fluminense", "Guerreiro");
		assert time1.equals(time2);
	}
	
	@Test
	void testEqualsTimesDiferentes() {
		Time time1 = new Time("001_RJ", "Fluminense", "Guerreiro");
		Time time2 = new Time("001_BA", "Fluminense de Feira", "Touro");
		assert time1.equals(time2) == false;
	}
	
	@Test
	void testToString() {
		Time flu = new Time("001_RJ", "Fluminense", "Guerreiro");
		assertEquals("[001_RJ] Fluminense / Guerreiro", flu.toString());
	}
	
	@Test
	void testAdicionaCampeonato() {
		Time flu = new Time("001_RJ", "Fluminense", "Guerreiro");
		flu.adicionaCampeonato(brasileiro.toString());
	}
	
	@Test
	void testStringCampeonatosDoTime() {
		Time flu = new Time("001_RJ", "Fluminense", "Guerreiro");
		flu.adicionaCampeonato(brasileiro.toString());
		assertEquals("\nCampeonatos do Fluminense:\n* Brasileirão - 0/20", flu.stringCampeonatosDoTime());
	}
}