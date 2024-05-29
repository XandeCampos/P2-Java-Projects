package filmnow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilmNowTest {
	private FilmNow fn;
	
	@BeforeEach
	void setUp() {
		fn = new FilmNow();
	}
	
	
	@Test
	void testAdicionaFilmeConstrutor() {
		assertEquals("FILME ADICIONADO", fn.adicionaFilme(1, "Avatar", "2009", "Disney+")); // capta a String e compara
	}
	
	@Test
	void testAdicionaFilmePosicaoOcupada() {
		fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
		assertEquals("FILME ADICIONADO", fn.adicionaFilme(1, "20 dias em Mariupol", "2023", "Cinema"));
	}
	
	@Test
	void testAdicionaFilmeRepetido() {
		fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
		assertEquals("FILME JÁ ADICIONADO", fn.adicionaFilme(3, "Avatar", "2009", "Disney+"));
	}
	
	@Test
	void testAdicionaFilmeRepetidoLocalDiferente() {
		fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
		assertEquals("FILME JÁ ADICIONADO", fn.adicionaFilme(3, "Avatar", "2009", "Popcornflix"));
	}
	
	@Test
	void testAdicionaFilmePosicaoLimite() {
		assertEquals("FILME ADICIONADO", fn.adicionaFilme(100, "Avatar", "2009", "Disney+"));
	}
	
	@Test
	void testAdicionaFilmePosicaoSuperiorInvalida() {
		assertEquals("POSIÇÃO INVÁLIDA", fn.adicionaFilme(101, "Avatar", "2009", "Disney+"));
	}
	
	@Test
	void testAdicionaFilmePosicaoInferiorInvalida() {
		assertEquals("POSIÇÃO INVÁLIDA", fn.adicionaFilme(0, "Avatar", "2009", "Disney+"));
	}
	
	@Test
	void testAdicionaFilmeParametroInvalidoLocal() {
		assertEquals("FILME INVALIDO", fn.adicionaFilme(1, "20 dias em Mariupol", "2023", ""));
	}
	
	@Test
	void testAdicionaFilmeAnoVazio() {
		assertEquals("FILME ADICIONADO", fn.adicionaFilme(1, "20 dias em Mariupol", "", "Cinema"));
	}
	
	@Test
	void testAdicionaFilmeParametroInvalidoNome() {
		assertEquals("FILME INVALIDO", fn.adicionaFilme(1, "", "2023", "Cinema"));
	}
	
	@Test
	void testDetalharFilme() {
		fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
		assertEquals("\nAvatar, 2009\nDisney+", fn.detalharFilme(1));
	}
	
	@Test
	void testDetalharFilmeSemAno() {
		fn.adicionaFilme(1, "20 dias em Mariupol", "", "Cinema");
		assertEquals("\n20 dias em Mariupol\nCinema", fn.detalharFilme(1));
	}
	
	@Test
	void testDetalharFilmePosicaoVazia() {
		assertEquals("POSIÇÃO INVÁLIDA", fn.detalharFilme(100));
	}
	
	@Test
	void testDetalharFilmePosicaoInferiorInvalida() {
		assertEquals("POSIÇÃO INVÁLIDA", fn.detalharFilme(0));
	}
	
	@Test
	void testDetalharFIlmePosicaoSuperiorInvalida() {
		assertEquals("POSIÇÃO INVÁLIDA", fn.detalharFilme(101));
	}
	
	@Test
	void testDetalharFilmeHot() {
		fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
		fn.adicionaHot(1, 1);
		assertEquals("\n🔥Avatar, 2009\nDisney+",fn.detalharFilme(1));
	}
	
	@Test
	void testAdicionaHot() {
		fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
		fn.adicionaHot(1, 1);
		assertEquals("\n1 - Avatar", fn.getHotList());
	}
	
	@Test
	void testAdicionaHotMesmaPosicao() {
		fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
		fn.adicionaHot(1, 1);
		fn.adicionaFilme(2, "20 dias em Mariupol", "2024", "Cinema");
		fn.adicionaHot(2,1);
		assertEquals("\n1 - 20 dias em Mariupol", fn.getHotList());
	}
	
	@Test
	void testAdicioinaHotPosicaoInferiorInvalida() {
		fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
		assertEquals("POSIÇÃO INVÁLIDA", fn.adicionaHot(1, 0));
	}
	
	@Test
	void testAdicionaHotPosicaoSuperiorInvalida() {
		fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
		assertEquals("POSIÇÃO INVÁLIDA", fn.adicionaHot(1, 11));
	}
	
	@Test
	void testRemoveHot() {
		fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
		fn.adicionaHot(1, 1);
		fn.removeHot(1);
		assertEquals("", fn.getHotList());
		assertEquals("\nAvatar, 2009\nDisney+",fn.detalharFilme(1));
	}
}
