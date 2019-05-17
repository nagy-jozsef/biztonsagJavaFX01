import model.Szamologep;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SzamologepTest {

    private Szamologep szamologep;

    @BeforeEach
    void setUp() {
        szamologep = new Szamologep();
    }

    @AfterEach
    void tearDown() {
        szamologep = null;
    }

    @Test
    void add() {
        assertEquals(2331, szamologep.add(1785,546 ));
    }

    @Test
    void sub() {
        assertEquals(1239, szamologep.sub(1785,546 ));
    }

    @Test
    void mul() {
        assertEquals(974610, szamologep.mul(1785,546 ));
    }

    @Test
    void div() {
        assertEquals(3, szamologep.div(1785,546 ));
    }
}
