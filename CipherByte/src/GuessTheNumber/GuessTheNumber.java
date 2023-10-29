package GuessTheNumber;

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int lowerBound = 1;
		int upperBound = 100;
		int numberOfRounds = 3; // You can change the number of rounds here
		int totalScore = 0;

		System.out.println("Welcome to Guess the Number!");
		System.out.println("I will generate a random number between " + lowerBound + " and " + upperBound + ".");

		for (int round = 1; round <= numberOfRounds; round++) {
			int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
			int numberOfAttempts = 0;
			int userGuess;
			boolean hasGuessedCorrectly = false;

			System.out.println("\nRound " + round);
			while (!hasGuessedCorrectly && numberOfAttempts < 5) { // Limiting to 5 attempts per round
				System.out.print("Enter your guess: ");
				userGuess = scanner.nextInt();
				numberOfAttempts++;

				if (userGuess == numberToGuess) {
					System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts.");
					int roundScore = 5 - numberOfAttempts; // Give points based on attempts
					totalScore += roundScore;
					System.out.println("Your score for this round: " + roundScore);
					hasGuessedCorrectly = true;
				} else if (userGuess < numberToGuess) {
					System.out.println("Try a higher number.");
				} else {
					System.out.println("Try a lower number.");
				}
			}

			if (!hasGuessedCorrectly) {
				System.out.println("Out of attempts. The correct number was: " + numberToGuess);
			}
		}

		System.out.println("\nGame Over!");
		System.out.println("Total Score: " + totalScore);

		scanner.close();
	}
}
