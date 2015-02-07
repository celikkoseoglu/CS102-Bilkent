import java.util.Scanner;
import static java.lang.System.out;

/**
 * @description Main class for Hangman game.
 * @author Çelik Köeoğlu - CS102 all stars
 * @date 07/02/2015
 */

public class Main {
	public static void main(String[] args) {
		
		// Variables
		int gameState;
		boolean isGameOver;
		char currentLetter;
		char playAgain;
		Hangman hangman;

		// Scanner
		Scanner scan = new Scanner(System.in);

		// Program code
		out.println("Welcome to the Hangman Game!");
		
		/*
		 * 1.start by creating an instance of the Hangman class
		 * 2.the game just started so, isGameOver = false
		 */
		do {
			hangman = new Hangman();
			isGameOver = false;
			/*
			 * 1.display the number of tries left.
			 * 2.display the letters -unknown letters are shown by *-
			 * 3.ask the user for a letter from the English alphabet
			 * 4.continue this loop until the game is over
			 */
			do {
				out.println("You have " + (hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries()) + " tries left.");
				out.println("\nHere is the word: " + hangman.getKnownSoFar());
				out.print("\nEnter a letter from the English alphabet: " + hangman.getAllLetters() + ": ");
				currentLetter = scan.nextLine().charAt(0);
				gameState = hangman.tryThis(currentLetter);
				
				if (gameState == -1)
					out.println("\nThe letter you entered is invalid");
				else if (gameState == -2)
					out.println("\nThe letter was already used. Try another one!");
				else if (gameState == -3) {
					out.println("\nGame over!");
					isGameOver = true;
				}
			} while (isGameOver == false);
			out.print("\nDo you want to play again? (Y/N): ");
			playAgain = scan.nextLine().charAt(0);
		} while (playAgain == 'Y' || playAgain == 'y' ? true : false);
		
		out.println("Bye!");
		
		scan.close();
	}
}