package za.co.wethinkcode.mastermind;

import java.io.InputStream;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.RunElement;

public class Player {
    /**
     * The scanner for input stream given
     */
    private final Scanner inputScanner;


    /**
     * Default constructor, uses System.in as input
     */
    public Player(){
        this.inputScanner = new Scanner(System.in);
    }

    
    /**
     * Overloaded constructor for custom input stream
     * @param inputStream : An alternate input stream to System.in
     */
    public Player(InputStream inputStream){
        this.inputScanner = new Scanner(inputStream);
    }


    /**
     * Checks if the input given is a 4 digit string with numbers between 1-8
     * Also prints an error message.
     * @param input : The input string
     * @return (boolean) : True if valid 4 digit string with numbers between 1-8
     * , otherwise False
     */
    private static boolean isValidNumber(String input){
        boolean valid = input.matches("[1-8]+") && input.length() == 4;
        if (!valid){
            System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
        }
        return valid;
    }


    /**
     * Checks if the player wants to quit
     * @param input : The(boolean) : True if valid input string
     * @return (boolean) : True if input is quit or exit, otherwise false
     */
    public static boolean playerWantsToQuit(String input){
        return input.matches("(?i).*\\b(quit|exit)\\b.*");

    }


    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is entered, or until the user enters `exit` or `quit`.
     *
     * @return (String) : the value entered by the user
     */
    public String getGuess(){
        System.out.println("Input 4 digit code:");
        String input = inputScanner.nextLine();
        return isValidNumber(input) || playerWantsToQuit(input) ?
            input : this.getGuess();
    }
}
