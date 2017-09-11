import entities.Game;

public class MontyHall {

    private final static int repetitions = 10000;

    public static void main(String args[]) {
        System.out.println("Playing Monty Hall " + repetitions + " times..");

        final Game game = new Game();

        for (int i = 0; i < repetitions; i++) {
            game.play();
        }

        System.out.println("Staywins: " + game.getStayWins());
        System.out.println("Switchwins: " + game.getSwitchWins());

    }
}
