package za.co.wethinkcode.mastermind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class MastermindTest {

    @Test 
    void testCompareCode(){
        Random randomNumberMock = Mockito.mock(Random.class);
        when(randomNumberMock.nextInt(anyInt())).thenReturn(0, 1, 2, 3);
        Mastermind m = new Mastermind(new CodeGenerator(randomNumberMock), new Player());
        
        assertEquals(0, m.compareCode("5555"));
        assertEquals(1, m.compareCode("1555"));
        assertEquals(2, m.compareCode("1255"));
        assertEquals(3, m.compareCode("1235"));
        assertEquals(4, m.compareCode("1234"));
    }
    @Test 
    void testMatchedCode(){
        Random randomNumberMock = Mockito.mock(Random.class);
        when(randomNumberMock.nextInt(anyInt())).thenReturn(0, 1, 2, 3);
        Mastermind m = new Mastermind(new CodeGenerator(randomNumberMock), new Player());

        assertFalse(m.matchesCode("5555"));
        assertFalse(m.matchesCode("1555"));
        assertFalse(m.matchesCode("1255"));
        assertFalse(m.matchesCode("1235"));
        assertTrue(m.matchesCode("1234"));
    }
}
