package a1Q1;

/*
 * Alistair Godwin
 * SID: 020079158
 * UID: agodwin
 * Assignment 2: Question 2(Part 1 -> 5.25)
 * JAC444
 * 
 * 
 * New: Added new methods for getting the MAXROW constant via a user. for 5.25 quest.
 * 
 * This program will generate a star using a given MaxRow size by utilizing multiple nested for loops and method calls.
 */
import java.util.Scanner;

public class Q1{
		
	//==Allows use in functions==//
	static int _stars;
	static int _halfdigit;
	//==========================//
	
	public static void main(String [] args) {
		
		System.out.println("Assignment 2: Q1\n");
		//==============Set as Required=============//
		
		final int MAXROW = getMaxRows();		//Both the max rows and max characters PER row. Min should be 3, otherwise no diamond.
		final int HALFROW = (int) Math.round( MAXROW / 2.0 ); //The halfway point of the max rows. Rounded
		//=========================================//
		 _stars = 1; 			   //Default The least amount of stars possible. Changes to per row character limits.
		 _halfdigit = HALFROW - 1; //The starting star digit is half the total rows - 1.
		
		//=====================Display Pyramid===============//
		//Print up to HALFROW rows.
		for(int i = 0; i < HALFROW; i++) {
			//Print up to MAXROW chars per Row.
			for(int j = 0; j < MAXROW; j++) {
				if(j == _halfdigit) {
					j+=PrintStars();//Continue iterating after placing the stars
				}else {
					space(); //Fill up remaining spaces pre and post.
				}
			}
			endLn();	
			_halfdigit--;//The amount of spaces decreases by 1 per row(the stars start sooner)
			_stars += 2; //Max stars increases by 2 per row
		}		
		//=====================================================//
		
		_stars -= 4; 	//Reversal, skip the max star line repeating in this case.
		_halfdigit = 1; //Since we are not keeping two lines in the centre, move the half digit by one.
		
		//===================Reverse Pyramid==================//
		//Print up to HALFROW rows in reverse order.
		for(int i = HALFROW - 1; i > 0; i--) {
			//Print up to MAXROW chars per Row.
			for(int j = 0; j < MAXROW; j++) {
				if(j == _halfdigit) {
					j+=PrintStars();
				}else {
					space(); //Fill up remaining spaces pre and post
				}
			}
			endLn();
			_halfdigit++; //The amount of spaces increases by 1 per row(the stars start later)
			_stars -=2;	//Max stars decreases by 2 per row
		}
		//=================================================//
	
	
	System.out.println("\nGoodbye!"); //Bye Bye
	}
	
	
	//Fetch the MaxRows of the diamond from the user. Make calls to ensure safe input. 
	public static int getMaxRows() {
	
		Scanner inp = new Scanner(System.in);
		int a = 0;
		do {
			System.out.println("Please Enter an Odd Numbered Int from 1 - 19");
			if (inp.hasNextInt()){  
				a = inp.nextInt(); //Get int
			}else {
				
				inp.next(); //Clean buffer if not int
			}
			
	   }while(Inspect(a) == false); // Ensure valid input
		
		inp.close();
		return a; //Return MAXROWS
	}
	
	//Check the Range of 1 - 19 inclusive and check if odd.
	public static boolean Inspect(int a) {
		boolean range = (a > 0 && a < 20) ? true : false;
		
	return (range == true && IsOdd(a) == true);
	}
	//Check if odd and return it.
	private static boolean IsOdd(int a) {
		return (a % 2 != 0);	
	}
	//Print 'stars' worth of asterisks by calling Star();
	public static int PrintStars() {
		for(int k = 0; k < _stars; k++) {
			star();
		}
		return _stars;
		
	}

	//Print Space
	public static void space() {
		System.out.printf(" ");
	}
	
	//Print *
	public static void star(){
			System.out.printf("*");	
	}
	//Print \n
	public static void endLn() {
		System.out.print("\n");
	}
}
