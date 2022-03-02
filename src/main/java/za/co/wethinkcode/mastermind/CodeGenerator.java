package za.co.wethinkcode.mastermind;

import java.util.Random;

public class CodeGenerator {
    private final Random random;

    
    public CodeGenerator(){
        this.random = new Random();
    }

    public CodeGenerator(Random random){
        this.random = random;
    }


    /**
     * Generates a random 4 digit code, using this.random, where each digit is in the range 1 to 8 only.
     * Duplicated digits are allowed.
     * @return (int) : the generated 4-digit code
     */
    public String generateCode(){
        return 
              Integer.toString(1 + this.random.nextInt(7))
            + Integer.toString(1 + this.random.nextInt(7))
            + Integer.toString(1 + this.random.nextInt(7))
            + Integer.toString(1 + this.random.nextInt(7));
    }
}
