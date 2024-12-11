import java.util.Random;
import java.util.Scanner;

public class Number_guessing_game {
    public static void main(String[] args) {
        Random random = new Random();  
        int numberToGuess = random.nextInt(50) + 1; //to pick some random number..random.nextInt(50) is from 0 to 49 and +1 shifts a bit i.e form 1 to 50
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        int numberOfTries = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 50.");
        System.out.println("Try to guess it!");
        while (guess != numberToGuess) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numberOfTries++;
            if (guess < numberToGuess) {
                System.out.println("Your guess is too low. Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + numberOfTries + " tries.");
            }
        }
        scanner.close();
    }
}
