/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bht.swt.esa.tst;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
    void testGetEmptyString() {
        ACDE acde = mock(ACDE.class);
        when(acde.getEmptyString()).thenReturn("");
        assertTrue(acde.getEmptyString().isEmpty());

    
    }
}
