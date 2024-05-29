package filmnow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HotListTest {
	private Filme filmeBase;
	private HotList hot;
	
	@BeforeEach
	void setUp() throws Exception {
		this.filmeBase = new Filme("Avatar", "2009", "Disney+");
		this.hot = new HotList();
	}

	@Test
	void testConstrutor() {
		HotList hottie = new HotList();
	}
	
	@Test
	void testAdicionaFilmeHot() {
		assertEquals("ADICIONADO À HOTLIST NA POSIÇÃO 1!", hot.adicionaFilmeHot(filmeBase, 1));
	}
	
	@Test
	void testAdicionarFilmeHotRepetido() {
		hot.adicionaFilmeHot(filmeBase, 1);
		assertEquals("FILME JÁ ESTÁ NA HOTLIST!", hot.adicionaFilmeHot(filmeBase, 3));
	}

}
