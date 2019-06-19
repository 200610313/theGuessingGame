/*
Angelu Ferdinand Garcia
Object Oriented Programming 2
Mr. Jessie Lagrosas
6/19/19

User guesses a randomly-generated integer.
Program gives a hint/tip if guess is lesser or greater
*/
import java.util.Random;
import java.util.Scanner;

public class launcher{
    public static void main(String[] args) {
        guessNum g = new guessNum();
        g.setLimit();
        g.guess();
    }
}


class guessNum
{
    private Scanner in = null;      //object to get input
    private Random rand = null;     //object to generate random num
    private int limit;              //upper limit
    private int guess;              //user guess
    private int trueNum;            //random num
    private int firstGuess;

    //constructor
    public guessNum()
    {
        in = new Scanner(System.in);
        rand = new Random();
        this.limit = 0;
        this.guess = 0;
        this.trueNum = 0;
    }

    public void setLimit()
    {
        System.out.print("Enter upper limit: ");
        //setting upper limit, store it to limit
        this.limit = this.in.nextInt();
        //generate random number
        setRandom();
    }

    private void setRandom()//private because never casted in main
    {
        //generate a random variable, store it to trueNum
        this.trueNum = this.rand.nextInt(this.limit+1);
    }

    public void guess()
    {
        System.out.print("Guess the number from 0 to "+this.limit+"." +
                         "\nGuess: ");

        //loop will only activate if first guess is wrong, make first guess.
        this.firstGuess = this.in.nextInt();
        //if user made the wrong guess on first try
        if (this.firstGuess!=this.trueNum)
        {
            this.guess = this.firstGuess;//encountered only once

            while(wrongGuess())
            {
                //tip user if true number was higher/lower than guess
                giveTip();
                System.out.print("Guess: ");
                this.guess = this.in.nextInt();
            }
            //if guess finally right, let user know
            System.out.println("Correct! the number was "+this.trueNum+".");
        }
        //if user made the right guess on the first try
        else System.out.println("Correct! the number was "+this.trueNum+". You guessed the number on your 1st try.");
    }

    private boolean wrongGuess()
    {
        //check if guess is correct
        if (this.guess == this.trueNum) return false;
        else return true;
    }

    private void giveTip()
    {
        if (this.guess>this.trueNum) System.out.println("Go lower.");
        else System.out.println("Go higher.");
    }
}
