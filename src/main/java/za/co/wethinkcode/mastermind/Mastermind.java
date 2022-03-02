package za.co.wethinkcode.mastermind;

public class Mastermind {
    private final String code;
    private final Player player;


    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }


    public Mastermind(){
        this(new CodeGenerator(), new Player());
    }


    /**
     * Compares the guess and code and says which numbers are in the correct
     * and incorrect places
     * @param code : the guess
     * @return (int) : the number of matching numbers between the two codes
     */
    public int compareCode(String input){
        int matches = 0;
        int contains = 0;

        for (int i = 0; i < 4; i++){
            if (code.charAt(i) == input.charAt(i)) matches++;
            if (code.contains(""+input.charAt(i))) contains++;
        }
        
        contains -= matches;
        System.out.println("Number of correct digits in correct place: " + matches);
        System.out.println("Number of correct digits not in correct place: " + contains);

        return matches;
    }


    /**
     * Checks if the guess matches the code
     * @param code : the guess
     * @return (boolean) : True if the codes match, otherwise False
     */
    public boolean matchesCode(String input){
        if (this.compareCode(input) == 4){
            System.out.println("Congratulations! You are a codebreaker!");
            return true;
        }

        player.useTurn();
        return false;
    }


    /**
     * Runs the Mastermind game loop
     */
    public void runGame(){
        System.out.println(
            "4-digit Code has been set. "   + 
            "Digits in range 1 to 8. "      +
            "You have 12 turns to break it."
        );
        String input = player.getGuess();
        while (!Player.playerWantsToQuit(input) && !matchesCode(input) && !player.isOutOfTurns()){
            input = player.getGuess();
        }
        System.out.println("The code was: " + code);
    }


    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();
    }
}
