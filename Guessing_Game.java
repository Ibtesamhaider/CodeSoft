package number_guessing_game;

import java.util.Random;
import java.util.Scanner;

public class Guessing_Game {

	int number;
	int inputNumber;
	int numberOfGuesses=0;
	
	public int getNumberOfGuesses() {
		return numberOfGuesses;
	}

	public void setNumberOfGuesses(int numberOfGuesses) {
		this.numberOfGuesses = numberOfGuesses;
	}

	Guessing_Game(){
		Random rand=new Random();
		this.number=rand.nextInt(100);
	}
	void takeUserInput() {
		System.out.println("Guess the number");
		Scanner sc=new Scanner(System.in);
		inputNumber=sc.nextInt();
	}
	boolean isCorrectNumber() {
		numberOfGuesses++;
		if(inputNumber==number) {
			System.out.format("You Won, it was %d\nyou guessed it in %d attempts",number,numberOfGuesses);
			return true;
		}
		else if(inputNumber<number) {
			System.out.println("Too Low");
		}
		else if(inputNumber>number) {
			System.out.println("Too High");
		}
		return false;
	}

	public static void main(String[] args) {
		
		Guessing_Game g=new Guessing_Game();
		boolean b=false;
		while(!b) {
			g.takeUserInput();
			b=g.isCorrectNumber();
		}

	}
}

