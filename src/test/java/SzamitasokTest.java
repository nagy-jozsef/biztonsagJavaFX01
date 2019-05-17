import model.Szamitasok;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SzamitasokTest {

	private Szamitasok szamolas;

	@BeforeEach
	void setUp() {
		szamolas = new Szamitasok();
	}

	@AfterEach
	void tearDown() {
		szamolas = null;
	}

	@Test
	void lnko() {
		assertEquals(21, szamolas.lnko(1785,546 ));
		assertEquals(4, szamolas.lnko(1220,516 ));
		assertEquals(12, szamolas.lnko(60,36 ));
		//assertEquals(10, szamolas.lnko(60,20 ));
	}

	@Test
	void lnkoExt() {
		assertEquals(21, szamolas.lnkoExt(1785,546 ));
		assertEquals(4, szamolas.lnkoExt(1220,516 ));
		assertEquals(12, szamolas.lnkoExt(60,36 ));
	}

}
