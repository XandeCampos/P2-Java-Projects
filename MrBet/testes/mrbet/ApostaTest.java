package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApostaTest {
	private Time flu;
	private Campeonato brasileiro;
	
	@BeforeEach
	void setUp() {
		this.flu = new Time("001_RJ", "Fluminense", "Guerreiro");
		this.brasileiro = new Campeonato("Brasileirão", 20);
	}

	@Test
	void testConstrutor() {
		new Aposta(flu, brasileiro, 1, 15.00);
	}
	
	@Test
	void testToString() {
		Aposta aposta = new Aposta(flu,brasileiro, 1, 15.00);
		assertEquals("[001_RJ] Fluminense / Guerreiro\nBrasileirão\n1/20\nR$ 15,00", aposta.toString());
	}
}