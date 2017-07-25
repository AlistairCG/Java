package a1_SquaredCircles;
/*
Alistair Godwin
SID: 020079158
UID: agodwin
Prof: Mehrnaz Zhian
A1 - Question 2: Squares and Cubed.
 
 This program displays to the user the squares and cubes of preset ints in a tabular format 
 using method calls for square and cube.
*/


public class SquaredCircle {
//Display assignment information, and loop through all ints.
	public static void main(String[] args) {
		//==========Change as required=======//
		//Allows scalable changes to how many ints to loop through
		final int IMAX = 10;
		final int IMIN = 0;
			
		//============================//
		System.out.println("===========Assignment 1: Question 2: Squares and Cubes==========\n\n");
		System.out.println("The ints from " + IMIN +" to "+ IMAX + " will be squared and cubed below:");
		System.out.println("||Number======Squared======Cubed======||");
		
		//Loop 0-10 inclusive, call and display cubed and squares in tabular table format
		for(int i = IMIN; i <= IMAX; i++){
			//Call for int requirements and displays
			System.out.printf("||" + "%6d \t %4d \t %7d      || \n",i,Square(i),Cube(i));
		}
		
		System.out.println("||====================================||");
		System.out.println("Goodbye!");
	}
	
	
	
	
	//Returns square of incoming int
	public static int Square(int sqn){
		return (sqn * sqn);
	}
	
	//Returns cube of incoming int.
	public static int Cube(int cub){
		return (cub * cub * cub);
	}
}
