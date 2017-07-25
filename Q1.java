package a2Q1;

public class Q1 {
/*
 * Alistair Godwin
 * SID: 020079158
 * UID: agodwin
 * Assignment 2: Question 1
 * JAC444
 * 
 */
	
	//==Allows use in functions==//
	static int stars;
	static int halfdigit;
	//==========================//
	
	public static void main(String [] args) {
		
		System.out.println("Assignment 2: Q1\n");
		//==============Set as Required=============//
		final int MAXROW = 9; //Both the max rows and max characters PER row. Min should be 3, otherwise no diamond.
		final int HALFROW = (int) Math.round( MAXROW / 2.0 ); //The halfway point of the max rows. Rounded
		//=========================================//
		 stars = 1; 			   //Default The least amount of stars possible. Changes to per row character limits.
		 halfdigit = HALFROW - 1; //The starting star digit is half the total rows - 1.
		
		//=====================Display Pyramid===============//
		//Print up to HALFROW rows.
		for(int i = 0; i < HALFROW; i++) {
			//Print up to MAXROW chars per Row.
			for(int j = 0; j < MAXROW; j++) {
				if(j == halfdigit) {
					j+=PrintStars();//Continue iterating after placing the stars
				}else {
					space(); //Fill up remaining spaces pre and post.
				}
			}
			endLn();	
			halfdigit--;//The amount of spaces decreases by 1 per row(the stars start sooner)
			stars += 2; //Max stars increases by 2 per row
		}		
		//=====================================================//
		
		stars -= 4; //Reversal, skip the max star line repeating in this case.
		halfdigit = 1; //Since we are not keeping two lines in ctr, move the half digit by one.
		
		//=================Reverse Pyramid===========//
		//Print up to HALFROW rows in reverse order.
		for(int i = HALFROW - 1; i > 0; i--) {
			//Print up to MAXROW chars per Row.
			for(int j = 0; j < MAXROW; j++) {
				if(j == halfdigit) {
					j+=PrintStars();
				}else {
					space(); //Fill up remaining spaces pre and post
				}
			}
			endLn();
			halfdigit++; //The amount of spaces increases by 1 per row(the stars start later)
			stars -=2;	//Max stars decreases by 2 per row
		}
		//==============================================//
	
	
	System.out.println("\nGoodbye!"); //Bye Bye
	}
	
	
	
	
	
	//Print Stars by calling Star();
	public static int PrintStars() {
		for(int k = 0; k < stars; k++) {
			star();
		}
		return stars;
		
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
