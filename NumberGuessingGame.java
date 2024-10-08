import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int rounds = 0;
            int score = 0;
            boolean playAgain = true;
            
            while (playAgain) {
                rounds++;
                int numberToGuess = random.nextInt(100) + 1; 
                int attempts = 0;
                boolean hasGuessed = false;
                
                System.out.println("Round " + rounds + ": Guess a number between 1 and 100!");
                
               
                while (attempts < 10 && !hasGuessed) {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;
                    
                    if (userGuess == numberToGuess) {
                        System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                        hasGuessed = true;
                        score += 10 - attempts; 
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Too low! Try again.");
                    }
                    
                    if (attempts == 10 && !hasGuessed) {
                        System.out.println("You've reached the maximum attempts! The correct number was " + numberToGuess);
                    }
                }
                
                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.next().equalsIgnoreCase("yes");
            }
            
            System.out.println("Game over! You played " + rounds + " rounds and your final score is: " + score);
        }
    }
}
