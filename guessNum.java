/*
Angelu Ferdinand Garcia
Object Oriented Programming 2
Mr. Jessie Lagrosas
6/17/19

User guesses a randomly-generated integer.
Program gives a hint/tip if guess is lesser or greater
*/
import java.util.Scanner;
import java.util.Random;
public class guessNum
{
		int limit; //upper limit
		int guess; //user guess
		int trueNum; //random num

	public static void main(String[] args) {
		//to access instance variables
		guessNum g = new guessNum();
		//to get user input
		Scanner in = new Scanner(System.in);
		//let user choose limit
		System.out.print("Enter upper limit: ");g.limit = in.nextInt();	
		//generate random number
		Random rand = new Random();g.trueNum = rand.nextInt(g.limit+1);

		System.out.println("0 to "+g.limit+". Start guessing! \nGuess: ");
		
		//let user make 1st guess
		int firstGuess = in.nextInt();

		if (firstGuess!=g.trueNum) {
			g.guess = firstGuess;
			while((wrongGuess(g.guess, g.trueNum))){
				giveTip(g.guess, g.trueNum);
				System.out.print("Guess: ");
				g.guess = in.nextInt();
			}
			System.out.println("Correct! the number was "+g.trueNum+".");
		}
		else System.out.println("Correct! the number was "+g.trueNum+". You guessed the number on your 1st try.");

	}

	private static boolean wrongGuess(int guess, int trueNum ){
		if (guess == trueNum) return false;
		else return true;
	}

	private static void giveTip(int guess, int trueNum)
	{
		if (guess>trueNum) System.out.println("Go lower.");
		else System.out.println("Go higher.");
	}
}