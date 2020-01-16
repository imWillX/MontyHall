public class Main {

    public static void main(String[] args) throws Exception {
        Game gameWithChoiceChange = new Game();
        gameWithChoiceChange.shouldChangeChoice(true);
        int simulations = 1000000, choiceWins = 0;
        for (int i = 0; i < simulations; i++) {
            if (gameWithChoiceChange.simulate())
                choiceWins++;
        }

        Game gameWithNoChoiceChange = new Game();
        int instinctsWins = 0;
        for (int i = 0; i < simulations; i++) {
            if (gameWithNoChoiceChange.simulate())
                instinctsWins++;
        }

        System.out.println("n = " + simulations);
        System.out.println("Game Won (No Choice Change) Win Rate: " + ((double) instinctsWins / simulations));
        System.out.println("Game Won (Choice Change) Win Rate: " + ((double) choiceWins / simulations));
    }
}
