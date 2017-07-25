package a1_jac444;

import java.util.Scanner;

/*
Alistair Godwin
SID: 020079158
UID: agodwin
Prof: Mehrnaz Zhian
A1 - Question 2: SalaryCalculator



This program calculates a sales rep salary based on a BASESALARY + 9% total sales(COMMISSION). The user loops through items to add to the sales and when ready the program displays the total cost.
The user has the option to keep entering data per worker after completion of one.

*/
public class SalaryCalculator {
final static int ITEMLIMIT = 4; //Set as required. Global. Used by multiple methods.
	
	
	public static void main(String[] args) {
		int exit = 0; //Escape int for the loop.
		int itemselect = -1; //No item selected.
		//==========Set as Required========//
		final double BASESALARY = 200.00;
		final double COMMISSION = .09; //9%
		//======================================//
		
		//Loop for a salaried worker.
		do{
			 
			double SaleSalary = 0.00; //Reset every new worker
			
			//==================Menu================//
			System.out.println("======Assignment 1: Question 3: Sales Commissions=====\n\n");
			System.out.println("The following Sales items are available to add:");			
			DisplayList();
			System.out.println("The Salesperson's salary is currently with commission: $" + (( SaleSalary * COMMISSION) + BASESALARY));
			//======================================//
			
			//=======================Input and Calculation=======================//
			//Accept user input for a menu item choice and add the items total every loop.
			//Escape on item select being 0.
			Scanner inp = new Scanner(System.in);
			do{
		
				System.out.println("Enter an item # to add or 0 to display the final amount. ");
				if (inp.hasNextInt()){
					int a = inp.nextInt();
					
					itemselect = (a > ITEMLIMIT || a < 0 ) ? -1 : a; //assign the entry only if valid selection, otherwise -1 for safe array bounds.
					
					//===Either add the new item to the salary or display the final cost===//
					if( itemselect != 0){
						
						DisplayList();
						SaleSalary = SetSalary(SaleSalary, GetValue(itemselect - 1));	//Call the Value of the item, and set the salary based on that value.
						//Display Running total
						System.out.printf("The Salesperson's salary is currently with commission: $%.2f\n" ,(( SaleSalary * COMMISSION) + BASESALARY));
						System.out.printf("The Salesperson has sold a total item value of: $%.2f\n", SaleSalary);
					}else{
						//Display Final total
						System.out.printf("==========\nThe Salesperson's Final salary with commission is: $%.2f\n===========\n" ,( (SaleSalary * COMMISSION) + BASESALARY));
						
					}
					//============//
					
					
				}else{ 
					//Somebody put a letter where a number should go....
					System.out.println("Invalid Selection");
					itemselect = -1; //Safety
					inp.next();
					DisplayList();
				
					//Format output to 2 decimals
					System.out.printf("The Salesperson's salary is currently with commission: $%.2f\n", (( SaleSalary * COMMISSION ) + BASESALARY));
					System.out.printf("The Salesperson has sold a total item value of: $%.2f\n", SaleSalary);
				}
				
			}while(itemselect != 0);
			
			//===================================================================//
			
			
			//========== Exit ==============//
			System.out.println("Enter 0 to exit the program, or anything else to start a new employee...");
			
			if (inp.hasNextInt()){
				exit = inp.nextInt();
			}else{
				exit = 1;
			}
			
			//Graceful exit and closure of scanner
			if (exit == 0) 
				inp.close(); 
			//============================//
		}while(exit != 0);
		
		System.out.println("\nGoodbye!"); //Bye Bye now!
	}
		
	//Return the value of the array item or 0.00 for out of bounds.
	public static double GetValue(int key){
		 final double [] VAL = {239.99,129.75,99.95,350.89};
		
		if(key >= 0 && key < ITEMLIMIT){
			return (VAL[key]);
		}else{
			
			return 0.00;
		}
		
	}
	//Return the combined salary + item change.
	public static double SetSalary(double salary, double change){
		return (salary + change);
	}
	
	//List all available items to the user.
	public static void DisplayList(){
		for(int i = 0; i < ITEMLIMIT; ++i){
			System.out.println((i + 1) + ". $"+ GetValue(i) );	
		}
		
		
	}
}
