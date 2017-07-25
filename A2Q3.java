package a2R;
/*
 * Alistair Godwin
 * SID: 020079158
 * UID: agodwin
 * Assignment 2: Question 4(Part 3)
 * JAC444
 * 
 *This app takes a user input via a JTextBox and converts it between 
 *celcius and farenheit depending on which Text box is active. The program uses
 *a document listener rather than a button for entry confirmation.
 */


import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class A2Q3 extends JFrame {

	
	public A2Q3() {
		
		this.setTitle("Conversion Application");
		this.setLayout(new GridLayout(2,2,10,10));		
		this.setSize(400, 150);  
		
		//===============Text Boxes + Labels============//
		JPanel conv = new JPanel();
		conv.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		JTextField Celc = new JTextField(6);	
		JLabel CelcL = new JLabel("Celcius: ");
		
		JTextField Farh = new JTextField(6);
		JLabel FarhL = new JLabel("Fahrenheit: ");
		
		conv.add(CelcL);
		conv.add(Celc);
		conv.add(FarhL);
		conv.add(Farh);
		//===============================================//
		
		//==================Conversion Labels======================//
		JPanel Lbl = new JPanel();
		Lbl.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		JLabel Info = new JLabel("Conversion: ");
		JLabel InfoAns = new JLabel("<Enter a valid number in either box>");
		
		Lbl.add(Info);
		Lbl.add(InfoAns);
		//=============================================//
		
		//============Event Listen for JTextBox Change========//
		//More interesting to automatically convert on Key press then action event.
		//Celcius
		Celc.getDocument().addDocumentListener(new DocumentListener() {
		
			//On any change, set the colour to active textbox and call Convert()
			public void insertUpdate(DocumentEvent e) {
				//Prevent exception, not really part of assignment, but I really want the automatic conversion
				try {
					InfoAns.setText(Convert_Cel(Double.parseDouble(Celc.getText())));
				
				}catch(Exception x) {
					InfoAns.setText(Convert_Err());
				}
				Celc.setBackground(new Color(1,225,1));
				Farh.setBackground(new Color(255,255,255));
					
					
			}
			public void changedUpdate(DocumentEvent e) {}
			public void removeUpdate(DocumentEvent e) {
				//Prevent exception, not really part of assignment, but I really want the automatic conversion
				try {
					InfoAns.setText(Convert_Cel(Double.parseDouble(Celc.getText())));
				
				}catch(Exception x) {
					InfoAns.setText(Convert_Err());
				}
				Celc.setBackground(new Color(1,225,1));
				Farh.setBackground(new Color(255,255,255));
					
			}
			
		
		});
		//Fahrenheit
		Farh.getDocument().addDocumentListener(new DocumentListener() {
			
			//On any change, set the colour to active textbox and call Convert()
			public void insertUpdate(DocumentEvent e) {
				//Prevent exception not really part of assignment, but I really want the automatic conversion
				try {
					InfoAns.setText(Convert_Far(Double.parseDouble(Farh.getText())));
				
				}catch(Exception x) {
					InfoAns.setText(Convert_Err());
				}
				Farh.setBackground(new Color(1,225,1));
				Celc.setBackground(new Color(255,255,255));
			}
			public void changedUpdate(DocumentEvent e) {}	
			public void removeUpdate(DocumentEvent e) {
				//Prevent exception not really part of assignment, but I really want the automatic conversion
				try {
				InfoAns.setText(Convert_Far(Double.parseDouble(Farh.getText())));
				}catch(Exception x) {
					InfoAns.setText(Convert_Err());
				}
				
				Farh.setBackground(new Color(1,225,1));
				Celc.setBackground(new Color(255,255,255));
			}
	
		});
		
		//==============================================//

		//=================Add to Frame=======================//
		this.add(conv);
		this.add(Lbl);
		
		//===============================================//
		
		
		
		//Set Behavior
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
		
		
	}
	//Display error where no valid double(or int) present.
	public static String Convert_Err() {
		
		return "<Enter a valid number in either box>";
	}
	//Convert Far -> Cel
	//Convert the double to string and return it.
	public static String Convert_Far(double inc) {
		double set = (inc - 32) * 5/9;
		
		set = (double)Math.round(set * 100d) / 100d; //Round up 2 decimals
		String s = String.valueOf(set);

		return "Celcius: " + s;	
	}
	
	//Convert Cel -> Far
	//Convert the double to string and return it.
	public static String Convert_Cel(double inc) {
		double set = inc * 9/5 + 32;
		
		set = (double)Math.round(set * 100d) / 100d; //Round up 2 decimals
		String s = String.valueOf(set);
		
		return "Farenheit: " + s;
		
	}
	
	
	//Initialize Object
	public static void main(String[] args) {
		new A2Q3();
		 
		System.out.println("Goodbye!");
	 }
	 
	
}
