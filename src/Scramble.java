package src;
import java.util.Random;
public class Scramble {
    //Current set of moves we have available
    private static final String[] MOVES = { "R", "R'", "U", "U'", "L", "L'", "D", "D'", "F", "F'", "B", "B'"};
    private static String generateRandomSequence(int minLength, int maxLength){
        Random random = new Random();
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        StringBuilder sequence = new StringBuilder();
        for(int i = 0; i < length; i++){
            String move = MOVES[random.nextInt(MOVES.length)];
            sequence.append(move);
        }
        return sequence.toString();
    }
    public static void scrambleCube(Cube cube){
        //Generate a random sequence of 30-40 moves
        String randomSequence = generateRandomSequence(5, 10);

        System.out.println(randomSequence);
        Movement.performSequence(randomSequence, cube);
    }
}
