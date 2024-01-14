package bht.swt.esa.tst;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import bht.swt.esa.tst.ACDE.NoNameException;
import bht.swt.esa.tst.ACDE.WeirdNameException;

import static org.junit.jupiter.api.Assertions.*;

public class ACDETest {
    @Test
    void testAdd() {
        ACDE acde = new ACDE();
        assertTrue(acde.add(1, 2) == 3);
        assertTrue(acde.add(1, -1) == 0);
        assertTrue(acde.add(0, 0) == 0);
        assertTrue(acde.add(Integer.MAX_VALUE, 1) == Integer.MIN_VALUE);
        assertTrue(acde.add(Integer.MIN_VALUE, -1) == Integer.MAX_VALUE);
    }

    @Test
    void testSub() {
        ACDE acde = new ACDE();
        assertTrue(acde.sub(1, 2) == -1);
        assertTrue(acde.sub(1, -1) == 2);
        assertTrue(acde.sub(25615, 56) == 25559);
        assertTrue(acde.sub(Integer.MAX_VALUE, -1) == Integer.MIN_VALUE);
        assertTrue(acde.sub(Integer.MIN_VALUE, 1) == Integer.MAX_VALUE);
        assertEquals(0, acde.sub(0, 0));
    }

    @Test
    void testDiv() {
        ACDE acde = new ACDE();
        assertTrue(acde.div(1, 2) == 0.5);
        assertTrue(acde.div(1, -1) == -1);
        assertTrue(acde.div(Integer.MAX_VALUE, -1) == -2147483647);
        assertTrue(acde.div(Integer.MIN_VALUE, 1) == -2147483648);
        assertThrows(ArithmeticException.class, () -> acde.div(1, 0));
    }

    @Test
    void testJudgeName() {
        ACDE acde = new ACDE();
        assertTrue(acde.scoreName("Alice") >= 0);
        assertThrows(WeirdNameException.class, () -> acde.scoreName("X Æ A-12"));
        assertThrows(NoNameException.class, () -> acde.scoreName(""));

    }
}
