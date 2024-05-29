package filmnow;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilmeTest {
	private Filme filmeBase;
	
	@BeforeEach
	void preparaFilmes() {
		this.filmeBase = new Filme("Avatar", "2009", "Disney+");
	}

	@Test
	void testNomeAno() {
		String msg = "Esperando Nome e Ano";
	    assertEquals( "Avatar, 2009", this.filmeBase.nomeAno(), msg);
	}
	
	@Test
	void testFilme() {
		assertEquals("Avatar", filmeBase.getNome());
		assertEquals("2009", filmeBase.getAno());
		assertEquals("Disney+", filmeBase.getLocal());
		assertEquals(false, filmeBase.getHot());
	}

	@Test
	void testEqualsObjectfilmeDiferente() {
		Filme filme = new Filme("Carros", "2006", "Disney+");
		assertEquals(false, filmeBase.equals(filme));
	}
	
	@Test
	void testEqualsObjectfilmeIgual() {
		Filme filme = new Filme("Avatar", "2009", "Disney+");
		assertEquals(true, filmeBase.equals(filme));
	}
	
	@Test
	void testToString() {
		assertEquals("\nAvatar, 2009\nDisney+", filmeBase.toString());
	}
	
	@Test
	void testToStringHot() {
		filmeBase.setHot(true);
		assertEquals("\n\ud83d\udd25Avatar, 2009\nDisney+", filmeBase.toString());
	}
	
	@Test
	void testToStringAnoVazio() {
		Filme filme = new Filme("Avatar", "", "Disney+");
		assertEquals("\nAvatar\nDisney+", filme.toString());
	}

}
