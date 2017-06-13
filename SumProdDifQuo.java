package A1_Jac444;

import java.util.Scanner;

public class SumProdDifQuo {
	//Program will loop while accepting 2 ints for use. 
	// Finds and displays product, quotient, sum, and difference.
		public static void main(String[] args) {
			
			int exit = 0;
			//Summing Loop, exit on int 0 entry
			do{
				
				System.out.println("======Assignment 1: Question 1=====\n\n");
				//Make object
				Scanner inp = new Scanner(System.in);
				
				System.out.println("Enter the first Int: ");
				
				//Get Int A with safety
				int a = 0;
				if (inp.hasNextInt()){
					a = inp.nextInt();
				}else{
					System.out.println("That was not an int. It's now 0");
					inp.next();
				}
				System.out.println("\nInt a: " + a);
				System.out.println("Enter the second Int: ");

				//Get Int B with safety
				int b = 0;
				if (inp.hasNextInt()){
					b = inp.nextInt();
				}else{
					System.out.println("That was not an int. It's now 0\n");
					inp.next();
				}
				System.out.println("\nInt b: " + b);
				
				//===========Output and method calls=============//
				System.out.println("The Sum of "+ a +" and "+  b + " is: " + Sum(a,b));
				System.out.println("The Product of "+ a +" and " + b + " is: " + Product(a,b));
				System.out.println("The Differance of "+ a +" and " + b + " is: " + Difference(a,b) + " digits.");
				System.out.println("The Quotient of "+ a +" divided by " + b + " is: " + Quotient(a,b));
				//================================================//
				
				//Query exit
				System.out.println("Enter 0 to exit the program, or anything else to continue...");
				if (inp.hasNextInt()){
					exit = inp.nextInt();
				}			
			
				//Graceful exit and closure of scanner
				if (exit == 0) 
					inp.close(); 
			}while(exit != 0);
		}

	//Return sum of 2 ints
	public static int Sum(int a, int b){
		return (a + b);
	}
	//Return product of 2 ints
	public static int Product(int a, int b){
		return (a * b);
	}
	
	//Returns the difference(positive digit) between two ints
	//Checks for greater value digit for positive difference.
	public static int Difference(int a, int b){
		if(a > b){
			return (a - b);
			
		}else if(a < b) {
			return (b - a);
			
		}else{
			return 0;
		}
	}
	//Returns the double quotient of two ints. 
	//Also prevent a divide by 0 scenario.
	//Since ints dont divide kindly as ints(truncation), returning a double seems better.
	public static double Quotient(int a, int b){
			if(a == 0 || b == 0){
				return 0;
			}
			else{
				 double c = ((double)a / (double)b);
				 Math.round(c); //Make a less horrible looking digit
				 return c;
			}
		}
		
		


}
