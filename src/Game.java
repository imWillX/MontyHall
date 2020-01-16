import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private Random gen;
    private int cups = 3;
    private boolean choices[];
    private boolean changeChoice = false;
    private int winningPosition = 0;

    public Game() {
        this.gen = new Random();
        this.choices = new boolean[cups];
    }

    private void reset() {
        this.gen = new Random();
        choices[winningPosition] = false;
        winningPosition = 0;
    }

    /**
     * Automatically plays the game
     * @return true if one has won and false otherwise
     */
    public boolean simulate() throws Exception {
        // The location at which the car is at
        winningPosition = gen.nextInt(cups);

        // Make our choice
        int choice = gen.nextInt(cups);

        // Set this to be the winning location
        this.choices[winningPosition] = true;

        print("The car is at " + winningPosition);
        print("You have choose " + choice);

        // Find all possibilities that the host could reveal
        List<Integer> possibilities = new ArrayList<>();
        for (int i = 0; i < choices.length; i++) {
            if (i != choice && i != winningPosition) possibilities.add(i);
        }

        // Reveal the choice
        int revealGoat = possibilities.get(gen.nextInt(possibilities.size()));
        if (revealGoat == winningPosition) throw new Exception("Host has revealed the goat");


        List<Integer> possibleChoices = new ArrayList<>();
        for (int i = 0; i < choices.length; i++) {
            if (i != revealGoat && i != choice) possibleChoices.add(i);
        }

        if (changeChoice) {
            choice = possibleChoices.get(gen.nextInt(possibleChoices.size()));
        }

        print("The host has revealed " + revealGoat);
        if (changeChoice) print("You have changed your choice to " + choice);
        print(String.format("The car is at %d and your choice is %d", winningPosition, choice));
        print("");

        boolean won = choice == winningPosition;
        reset();
        return won;
    }

    private void print(String message) {
//        System.out.println(message);
    }

    public void shouldChangeChoice(boolean bool) {
        this.changeChoice = bool;
    }

}
