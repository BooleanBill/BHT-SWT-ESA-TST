package bht.swt.esa.tst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class TimeBasedActionTest {
    @Test 
    void testGreeting() {
        TimeProvider mockTimeProvider = mock(TimeProvider.class);
        when(mockTimeProvider.getTimeOfDay()).thenReturn("Morning");
        TimeBasedAction timeBasedAction = new TimeBasedAction(mockTimeProvider);
        assertEquals("Good morning!", timeBasedAction.greeting());

        when(mockTimeProvider.getTimeOfDay()).thenReturn("Afternoon");
        assertEquals("Good afternoon!", timeBasedAction.greeting());

        when(mockTimeProvider.getTimeOfDay()).thenReturn("Evening");
        assertEquals("Good evening!", timeBasedAction.greeting());

        when(mockTimeProvider.getTimeOfDay()).thenReturn("Night");
        assertEquals("Good night!", timeBasedAction.greeting());

        verify(mockTimeProvider, times(4)).getTimeOfDay();

    }
}
