package za.co.wethinkcode.mastermind;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void testValidInputEmptyString(){
        assertFalse(Player.isValidNumber(""));
    }
    
    @Test
    void testValidInput3Digit(){
        assertFalse(Player.isValidNumber("123"));
    }


    @Test
    void testValidInput5Digit(){
        assertFalse(Player.isValidNumber("12345"));
    }


    @Test
    void testValidInputAlpha(){
        assertFalse(Player.isValidNumber("abcd"));
    }


    @Test
    void testValidInputAlphaNumberic(){
        assertFalse(Player.isValidNumber("123c"));
    }


    @Test
    void testValidInputZero(){
        assertFalse(Player.isValidNumber("0000"));
    }

    @Test
    void testValidInputNine(){
        assertFalse(Player.isValidNumber("9999"));
    }


    @Test
    void testValidInputCorrect(){
        assertTrue(Player.isValidNumber("1234"));
        assertTrue(Player.isValidNumber("5678"));
    }


    @Test
    void testPlayerWantsToQuitIncorrect(){
        assertFalse(Player.playerWantsToQuit("q"));
        assertFalse(Player.playerWantsToQuit("E"));
        assertFalse(Player.playerWantsToQuit("1234"));
        assertFalse(Player.playerWantsToQuit("5678"));
    }


    @Test
    void testPlayerWantsToQuitCorrect(){
        assertTrue(Player.playerWantsToQuit("quit"));
        assertTrue(Player.playerWantsToQuit("Exit"));
        assertTrue(Player.playerWantsToQuit("EXIT"));
        assertTrue(Player.playerWantsToQuit("qUiT"));
    }
    

    

    
}
