package a1_TwelveDays;
/*
Alistair Godwin
SID: 020079158
UID: agodwin
Prof: Mehrnaz Zhian
A1 - Question 5: Twelve Days of Christmas



This program uses switch statements and method calls to print out the lyrics to the twelve days of Christmas

*/

public class TwelveDays {

	public static void main(String[] args) {
		System.out.println("======Assignment 1: Question 5: Twelve Days of Chirstmas.=====\n\n");
		
		
		//Go through each listed day.
		for(int i = 1; i < 13; i++){
			System.out.printf("\nOn the %s day of Chirstmas, my true love sent to me\n",GetDayOf(i));
			
			//Go reverse order through the days items starting from i.
			for(int j = i; j > 0; j--){
				
				// AND <--- a partridge in a pear tree! Multi items need 'and' for last item
				if(j == 1 && i != 1) System.out.printf("and %s\n",GetItem(j));
				else{
					System.out.printf("%s\n",GetItem(j)); //a partridge in a pear tree!
				}
			}	
		}
		System.out.println("\nGoodbye!");
		
		
		
	}
	
	//Return the Day requested from the incoming int.
	public static String GetDayOf(int Day){
		switch (Day){
		
		case 1:
			return "First";
		
		case 2: 
			return "Second";

		case 3:
			return "Third";
			
		case 4:
			return "Fourth";
			
		case 5: 
			return "Fifth";
			
		case 6: 
			return "Sixth";
			
		case 7:
			return "Seventh";
			
		case 8: 
			return "Eight";
		
		case 9:
			return "Ninth";
			
		case 10:
			return "Tenth";
			
		case 11:
			return "Eleventh";
			
		case 12:
			return "Twelvth";
			
		default:
			return "ERROR: Out of Bounds Int Recieved in Method GetDayOF";
			
		
		}
		
	}
	//Return the Item requested from the incoming int.
	public static String GetItem(int Day){
		
		
		
		switch (Day){
		
		case 1:
			return "a Partridge in a Pear Tree.";
		
		case 2: 
			return "Two Turtle Doves,";
			
		case 3:
			return "Three French Hens,";
			
		case 4:
			return "Four Calling Birds,";
			
		case 5: 
			return "Five Gold Rings,";
			
		case 6: 
			return "Six Geese a-Laying,";
			
		case 7:
			return "Seven Swans a-Swimming,";
			
		case 8: 
			return "Eight Maids a-Milking,";
		
		case 9:
			return "Nine Ladies Dancing,";
			
		case 10:
			return "Ten Lords a-Leaping,";
			
		case 11:
			return "Eleven Pipers Piping,";
			
		case 12:
			return "Twelve Drummers Drumming,";
		default:
			return "ERROR: Out of Bounds Int Recieved in Method GetItem";
			
		
		}
		
	}
}
