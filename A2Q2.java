package a2Q2;
/*
 * Alistair Godwin
 * SID: 020079158
 * UID: agodwin
 * Assignment 2: Question 3(Part 2 ->Pg 635 14.8)
 * JAC444
 * 
 *This program creates a Frame object and adds containers with components to create a design.
 *There is no implementation beyond the design.
 */

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial") //Prevent odd "Serialization error"
public class A2Q2 extends JFrame {

	//ctor
	public A2Q2 () {
		
		//Create a frame with grid and size.
		this.setTitle("Align");
		this.setLayout(new GridLayout(1,3,20,50));		
		this.setSize(370, 150);  
		
		//==============Check box=============//
		JPanel chbo = new JPanel(); //Outer shell
		chbo.setLayout(new FlowLayout(FlowLayout.LEFT,10,27)); //Make aligned with text box
				
		JPanel chbox = new JPanel();
		chbox.setLayout(new GridLayout(2,1,1,8)); //Ensure chkbox aligns vertically
		chbox.add(new JCheckBox("Snap to Grid"));
		chbox.add(new JCheckBox("Show Grid"));
	
		chbo.add(chbox); //Add internal panel to outer
		
		//=======================================//
		
		//===============Text Box================//
		JPanel txtin = new JPanel(); //Outer shell
		txtin.setLayout(new FlowLayout(FlowLayout.LEFT,1,20));
		
		//Ensure Each text aligns vertically only.  
		//ex.  1
		//     2
		JPanel txtinp = new JPanel();
		txtinp.setLayout(new GridLayout(2,1,1,10));
		
		//Combine each textbox/label into a useable object
		JPanel txtinpa = new JPanel();
		txtinpa.add(new JLabel("X:"));
		txtinpa.add(new JTextField(6));
		txtinp.add(txtinpa);
		
		//Combine each textbox/label
		JPanel txtinpb = new JPanel();
		txtinpb.add(new JLabel("Y:"));
		txtinpb.add(new JTextField(6));
		txtinp.add(txtinpb);
		
		//Add to outer shell
		txtin.add(txtinp);
	   //========================================//
	    
		//=========Button==============//
		JPanel Btn = new JPanel(); //Outer Shell
		Btn.setLayout(new FlowLayout(FlowLayout.CENTER,15,10));
		JPanel Btns = new JPanel();
		Btns.setLayout(new GridLayout(3,1,5,5));
		Btns.add(new JButton("Ok"));
		Btns.add(new JButton("Cancel"));
		Btns.add(new JButton("Help"));
		Btns.setSize(100,100);
		Btn.add(Btns);
		
		//============================//
		
		//Add all containers to the frame
		 this.add(chbo);
		 this.add(txtin);
		 this.add(Btn);
		// ====^
		 
		 //Set behavior
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
	
	
	//Initialize Object
	 public static void main(String[] args) {
		 new A2Q2();
		 
		System.out.println("Goodbye!");
	 }
	 
	 
}
