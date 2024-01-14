package bht.swt.esa.tst;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import java.util.Random;

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
        assertFalse(acde.sub(1, 2) == 1);
        assertEquals(0, acde.sub(0, 0));
    }

    @Test
    void testGetEmptyString() {
        ACDE acde = new ACDE();
        assertEquals("", acde.getEmptyString());
        assertTrue(acde.getEmptyString().isEmpty());
        assertFalse(!acde.getEmptyString().isBlank());
        assertNotNull(acde.getEmptyString());
    }

    @Test
    void testMul() {
        Random random = new Random();
        int a = random.nextInt();
        ACDE acde = new ACDE();
        assertTrue(acde.mul(1, 2) == 2);
        assertFalse(acde.mul(a, 0) != 0);
        assertEquals(20, acde.mul(4, 5));
        assertEquals(-30, acde.mul(5, -6));
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
        assertEquals(13, acde.scoreName("Martin"));
        assertThrows(WeirdNameException.class, () -> acde.scoreName("X Æ A-12"));
        assertThrows(NoNameException.class, () -> acde.scoreName(""));

    }

    @Test
    void testRomanNumeralsToNumbers() {
        // the basics
        assertEquals(1, ACDE.romanNumeralsToNumbers("I"));
        assertEquals(5, ACDE.romanNumeralsToNumbers("V"));
        assertEquals(10, ACDE.romanNumeralsToNumbers("X"));
        assertEquals(50, ACDE.romanNumeralsToNumbers("L"));
        assertEquals(100, ACDE.romanNumeralsToNumbers("C"));
        assertEquals(500, ACDE.romanNumeralsToNumbers("D"));
        assertEquals(1000, ACDE.romanNumeralsToNumbers("M"));
        // a bit trickier: combinations of the basics
        assertEquals(2, ACDE.romanNumeralsToNumbers("II"));
        assertEquals(3, ACDE.romanNumeralsToNumbers("III"));
        assertEquals(6, ACDE.romanNumeralsToNumbers("VI"));
        assertEquals(7, ACDE.romanNumeralsToNumbers("VII"));
        assertEquals(8, ACDE.romanNumeralsToNumbers("VIII"));
        assertEquals(11, ACDE.romanNumeralsToNumbers("XI"));
        assertEquals(12, ACDE.romanNumeralsToNumbers("XII"));
        assertEquals(48, ACDE.romanNumeralsToNumbers("XLVIII"));
        assertEquals(69, ACDE.romanNumeralsToNumbers("LXIX"));
        assertEquals(99, ACDE.romanNumeralsToNumbers("XCIX"));
        assertEquals(101, ACDE.romanNumeralsToNumbers("CI"));
        assertEquals(202, ACDE.romanNumeralsToNumbers("CCII"));
        assertEquals(499, ACDE.romanNumeralsToNumbers("CDXCIX"));
        assertEquals(549, ACDE.romanNumeralsToNumbers("DXLIX"));
        assertEquals(999, ACDE.romanNumeralsToNumbers("CMXCIX"));
        assertEquals(1001, ACDE.romanNumeralsToNumbers("MI"));
        assertEquals(2002, ACDE.romanNumeralsToNumbers("MMII"));
        // some edge cases
        assertEquals(4, ACDE.romanNumeralsToNumbers("IV"));
        assertEquals(9, ACDE.romanNumeralsToNumbers("IX"));
        assertEquals(40, ACDE.romanNumeralsToNumbers("XL"));
        assertEquals(90, ACDE.romanNumeralsToNumbers("XC"));
        assertEquals(400, ACDE.romanNumeralsToNumbers("CD"));
        // some invalid inputs
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("IIII"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("VV"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("XXXX"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("LL"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("CCCC"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("DD"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("MMMM"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("IM"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("XM"));
        // some more invalid inputs that are plain wrong and not even roman numerals
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("ABC"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("123"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers("ölpqiwe"));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers(""));
        assertThrows(IllegalArgumentException.class, () -> ACDE.romanNumeralsToNumbers(" "));
        // null input
        assertThrows(NullPointerException.class, () -> ACDE.romanNumeralsToNumbers(null));

    }
}
