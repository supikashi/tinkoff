package edu.project1;

public class GameRunner {
    private static final Dictionary DICTIONARY = new Dictionary();
    private static final int MAX_ATTEMPTS = 5;

    public void runGame() {
        Session session = new Session(DICTIONARY.getRandomWord(), MAX_ATTEMPTS);
        ConsoleHangman consoleHangman = new ConsoleHangman(session);
        consoleHangman.run();
    }
}
