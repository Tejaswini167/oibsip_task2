import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 5;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = generateRandomNumber(rangeStart, rangeEnd);
            int attempts = 0;
            boolean guessedCorrectly = false;

            JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!");
            JOptionPane.showMessageDialog(null,
                    "I'm thinking of a number between " + rangeStart + " and " + rangeEnd + ".");

            while (attempts < maxAttempts && !guessedCorrectly) {
                int userNumber = getUserGuess(rangeStart, rangeEnd);
                attempts++;

                if (userNumber == randomNumber) {
                    guessedCorrectly = true;
                    score += maxAttempts - attempts + 1;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number.");
                } else if (userNumber < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry, you have reached the maximum number of attempts.");
                JOptionPane.showMessageDialog(null, "The number I was thinking of was: " + randomNumber);
            }

            JOptionPane.showMessageDialog(null, "Your score: " + score);

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again",
                    JOptionPane.YES_NO_OPTION);
            playAgain = (choice == JOptionPane.YES_OPTION);
        }

        JOptionPane.showMessageDialog(null, "Thank you for playing the Number Guessing Game!");
    }

    private static int generateRandomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }

    private static int getUserGuess(int start, int end) {
        int userNumber = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = JOptionPane.showInputDialog("Enter your guess between " + start + " and " + end + ":");

            try {
                userNumber = Integer.parseInt(input);

                if (userNumber < start || userNumber > end) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid input! Please enter a number within the specified range.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
            }
        }

        return userNumber;
    }
}
