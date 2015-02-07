import java.util.Scanner;

/**
 * @description Main class for Hangman game.
 * @author Çelik Köeoğlu - CS102 all stars
 * @date 07/02/2015
 * @commit Caner Caliskaner - CS102 all stars
 * 		   Did a little bit of convention fixing (although it was good, David is nitpicking we all know that)
 * 		   Added a little fun pseudoGUI function to draw a stickman
 *		   Additions need some fixing though!
 * 		   08/02/2015
 */

public class Main {
	public static void main( String[] args) {
		
		// Variables
		int gameState;
		boolean isGameOver;
		char currentLetter;
		char playAgain;
		Hangman hangman;

		// Scanner
		Scanner scan = new Scanner( System.in);

		// Program code
		System.out.println( "Welcome to the Hangman Game!");
		
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
				System.out.println( pseudoGUI( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries()) );
				System.out.println( "You have " + ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries() ) + " tries left." );
				System.out.println( "\nHere is the word: " + hangman.getKnownSoFar());
				System.out.print( "\nEnter a letter from the English alphabet: " + hangman.getAllLetters() + ": " );
				currentLetter = scan.nextLine().charAt(0);
				gameState = hangman.tryThis( currentLetter );
				
				if (gameState == -1){
					System.out.println( "\nThe letter you entered is invalid" );
				}
				else if (gameState == -2){
					System.out.println( "\nThe letter was already used. Try another one!" );
				}
				else if (gameState == -3) {
					if ( ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries()) > 0 )
						System.out.println( "\n" + pseudoGUI( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries()) );
					else
						System.err.println( "\n" + pseudoGUI( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries()) );
					
					System.err.println( "Game over!\n" );
					isGameOver = true;
				}
			} while (isGameOver == false);
			System.out.print( "\nDo you want to play again? (Y/N): " );
			playAgain = scan.nextLine().charAt(0);
		} while (playAgain == 'Y' || playAgain == 'y' ? true : false);
		
		System.out.println( "Bye!" );
		scan.close();
	}
	/**
	 * @description Draws the stickman according to how many lives left
	 * @param remainingLives : number of tries left
	 */
	private static String pseudoGUI( int remainingLives ){
		StringBuffer output = new StringBuffer("");
		switch (remainingLives)
		{
			case 6:
				output.append( " __________ \n" );
				output.append( " |/      | \n" );
				output.append( " |          \n" );
				output.append( " |          \n" );
				output.append( " |         \n" );
				output.append( " |          \n" );
				output.append( " | \n" );
				output.append( "_|___\n" );
				break;
				
			case 5:
				output.append( " __________ \n" );
				output.append( " |/      | \n" );
				output.append( " |      (_) \n" );
				output.append( " |          \n" );
				output.append( " |         \n" );
				output.append( " |          \n" );
				output.append( " | \n" );
				output.append( "_|___\n" );
				break;
			
			case 4:
				output.append( " __________ \n" );
				output.append( " |/      | \n" );
				output.append( " |      (_) \n" );
				output.append( " |       |  \n" );
				output.append( " |       | \n" );
				output.append( " |          \n" );
				output.append( " | \n" );
				output.append( "_|___\n" );
				break;
	
			case 3:
				output.append( " __________ \n" );
				output.append( " |/      | \n" );
				output.append( " |      (_) \n" );
				output.append( " |       |  \n" );
				output.append( " |      \\| \n" );
				output.append( " |          \n" );
				output.append( " | \n" );
				output.append( "_|___\n" );
				break;
				
			case 2:
				output.append( " __________ \n" );
				output.append( " |/      | \n" );
				output.append( " |      (_) \n" );
				output.append( " |       |  \n" );
				output.append( " |      \\|/ \n" );
				output.append( " |          \n" );
				output.append( " | \n" );
				output.append( "_|___\n" );
				break;
				
			case 1:
				output.append( " __________ \n" );
				output.append( " |/      | \n" );
				output.append( " |      (_) \n" );
				output.append( " |       |  \n" );
				output.append( " |      \\|/ \n" );
				output.append( " |      /  \n" );
				output.append( " | \n" );
				output.append( "_|___\n" );
				break;
			
			default:
				output.append( " __________ \n" );
				output.append( " |/      | \n" );
				output.append( " |      (_) \n" );
				output.append( " |       |  \n" );
				output.append( " |      \\|/ \n" );
				output.append( " |      / \\ \n" );
				output.append( " | \n" );
				output.append( "_|___\n" );
				break;
		}
		return output.toString();
	}
}