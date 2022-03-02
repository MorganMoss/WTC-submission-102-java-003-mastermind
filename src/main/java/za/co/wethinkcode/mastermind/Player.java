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
     * The number of guesses remaining
     */
    private int turns;


    /**
     * Default constructor, uses System.in as input
     */
    public Player(){
        this.inputScanner = new Scanner(System.in);
        turns = 12;
    }

    
    /**
     * Overloaded constructor for custom input stream
     * @param inputStream : An alternate input stream to System.in
     */
    public Player(InputStream inputStream){
        this.inputScanner = new Scanner(inputStream);
        turns = 12;
    }


    /**
     * Getter for amount of turns left
     * @return (int) : The amount of times this player can still guess
     */
    public int getTurns(){return turns;}


    /**
     * Checks to see if the player has no more turns left
     * @return (boolean) : True if the player has run out of turns
     */
    public boolean isOutOfTurns(){return turns == 0;}


    /**
     * De-Increments the players turn counter. And prints the result
     */
    public void useTurn(){
        if (turns > 0) turns--;
        if (!this.isOutOfTurns()) System.out.println("Turns left: " + turns); 
        else System.out.println("No more turns left.");
    }


    /**
     * Checks if the input given is a 4 digit string with numbers between 1-8
     * Also prints an error message.
     * @param input : The input string
     * @return (boolean) : True if valid 4 digit string with numbers between 1-8
     * , otherwise False
     */
    public static boolean isValidNumber(String input){
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
