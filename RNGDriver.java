import java.util.Scanner;
public class RNGDriver {
public static void main(String[] args) {
	String choice="";
	int randInt, nextGuess; 
	Scanner obj = new Scanner(System.in);
	
	do {
		RNG.resetCount();
		nextGuess=0;
		randInt = RNG.rand();
		int lowGuess=1;
		int highGuess=100;
		System.out.println("This application generates a random integer between 0 and 100"
				+ " and asks the user to guess repeatedly until they guess correctly");
		do {
			System.out.println("Enter your guess: ");
			nextGuess=obj.nextInt();
			if(RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
				if(nextGuess<randInt && (randInt-nextGuess)<(randInt-lowGuess)){
					lowGuess=nextGuess;
					System.out.println("Your guess is too low.");
				}
				if(nextGuess>randInt && (nextGuess-randInt)<(highGuess-randInt)) {
					highGuess=nextGuess;
					System.out.println("Your guess is too high.");
				}
				if (nextGuess!=randInt) {
				System.out.println("Enter guess between "+ lowGuess + " and "+ highGuess);
				System.out.println("Number of guesses is "+ RNG.getCount());
				}
				if (nextGuess==randInt) {
					System.out.println("Congratulations you guessed the right number!");
					break;
				}
				if (RNG.getCount()>=7) {
					
					System.out.println("Limit exceeded.");
					System.out.println("The number was "+ randInt);
					break;
				}
				
			}
		}while(RNG.getCount()<=7 );
		System.out.println("Try again (yes or no)?");
		obj.nextLine();
		choice = obj.nextLine();
	}while(choice.equals("yes"));
	if (choice.equals("no")) {
		System.out.println("Thank you for playing this game!");
		System.exit(0);
	} 
}
}
	
		
		
			
	




