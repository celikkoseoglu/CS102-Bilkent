import java.util.Random;

/**
 * @description Hangman class for Hangman game.
 * @author Çelik Köeoğlu - CS102 all stars
 * @date 07/02/2015
 */

public class Hangman {
	
	//final variables
	private final int maxAllowedIncorrectTries = 6;
	private final String[] wordList = {"interface", "computer", "inheritance", "java", "memory"};
	
	//variables
	private StringBuffer secretWord, allLetters, usedLetters, knownSoFar;
	private int numberOfIncorrectTries;
	
	/**
	 * @description Constructor for Hangman class.
	 * 1.defines the English alphabet
	 * 2.resets the number of incorrect tries.
	 * 3.resets the used letters,
	 * 4.gets a new secret word.
	 * 5.resets known so far. add secretWord.length() times *s to knownSoFar.
	 */
	public Hangman()
	{
		allLetters = new StringBuffer("abcdefghijklmnopqrstuwxyz");
		numberOfIncorrectTries = 0;
		usedLetters = new StringBuffer("");
		chooseSecretWord();
		
		knownSoFar = new StringBuffer("");
		for(int i = 0; i < secretWord.length(); i++)
			knownSoFar.append("*");
	}
	
	/**
	 * @description gets a (char)letter as a parameter and checks if the letters is in the secretWord
	 * @param letter - gets this as a char parameter from Main class
	 * @return -1 : the letter was not from the Englisg Alphabet
	 * @return -2 : the letter was already used
	 * @return -3 : the game is over. Either the user won or the maximum number of incorrect tries have been reached
	 */
	public int tryThis(char letter)
	{
		if (letter < 'a' || letter > 'z')
			return -1;
		else if (usedLetters.indexOf(Character.toString(letter)) > -1)
			return -2;
		else if (usedLetters.indexOf(Character.toString(letter)) == -1)
		{
			usedLetters.append(letter);
			boolean exists = false;
			for(int i = 0; i < secretWord.length(); i++)
			{
				if(secretWord.charAt(i) == letter)
				{
					exists = true;
					knownSoFar.deleteCharAt(i);
					knownSoFar.insert(i, letter);
				}
			}
			if(!exists)
				numberOfIncorrectTries++;
			if(hasLost())
			{
				System.out.print("You lost! The secret word was: " + secretWord);
				return -3;
			}
			else if(isGameOver())
			{
				System.out.print("You won!");
				return -3;
			}
		}
		return 0;
	}
	
	//gets a random word from the wordList array
	private void chooseSecretWord()
	{
		Random rand = new Random();
		secretWord = new StringBuffer(wordList[rand.nextInt(wordList.length)]);
	}
	
	public int getMaxAllowedIncorrectTries()
	{
		return maxAllowedIncorrectTries;
	}
	
	public String getAllLetters()
	{
		return allLetters.toString();
	}
	
	public String getUsedLetters()
	{
		return usedLetters.toString();
	}
	
	public int getNumOfIncorrectTries()
	{
		return numberOfIncorrectTries;
	}
	
	public String getKnownSoFar()
	{
		return knownSoFar.toString();
	}
	
	//game is over when there are no *s left in knownSoFar or maximum number of incorrect tries have been reached
	public boolean isGameOver()
	{
		return (knownSoFar.indexOf("*") == -1 || maxAllowedIncorrectTries - numberOfIncorrectTries == 0) ? true : false;
	}
	
	//the player has lost if the maximum number of incorrect tries have been reached and there are still some *s in knownSoFar
	public boolean hasLost()
	{
		return (knownSoFar.indexOf("*") != -1 && maxAllowedIncorrectTries - numberOfIncorrectTries == 0) ? true : false;
	}
}
