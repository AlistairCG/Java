package a3;

import java.awt.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class Keyboard extends JFrame{
	
	
	public Keyboard() {
		
		this.setTitle("Typing Tutor");
		this.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));		
		this.setSize(750, 630);  
		
		//==========Shell Panels=========//
		JPanel Contain = new JPanel();
		Contain.setLayout(new BoxLayout(Contain,BoxLayout.Y_AXIS));
		
		//Make an invisible divider while keeping the components vertically stacked
		JPanel Padding = new JPanel();
		Padding.setPreferredSize(new Dimension(25,20));
		
		//Label Container
		JPanel Lbl  = new JPanel();
		Lbl.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		//Holds Text Area
		JPanel Keys = new JPanel();
		//Eat 100% of available panel space
		Keys.setLayout(new GridLayout(1,1));
		
		//==============TextArea=============//
		//Make a scrolling text area. Prevents shaking component and makes sure text wraps.
		//Wrapping via Javadocs instructions
		JTextArea TextArea = new JTextArea();
		TextArea.setLineWrap(true);
		TextArea.setWrapStyleWord(true);
	
		JScrollPane TxtArea_ = new JScrollPane(TextArea);
		//=============================//
	
		//Holds Both the Lbl and Text area as required by assignment dimensions
		JPanel Hold = new JPanel();
		Hold.setLayout(new BoxLayout(Hold,BoxLayout.Y_AXIS));	//Make Hold place components
	
		//The keyboard
		JPanel Kb = new JPanel();
		//==============================//
		
		
		//Display text, note HTML since JLabel supports it and means less Panels.
		JLabel Lbl_txt = new JLabel("<html><body><p>Type some text using your keyboard. The keys you press will be highlighted and the text"
				+ " will be displayed.</p><p>Note: Clicking the buttons with your mouse will not perform any action </p></body> </html>");
		
		//Lbl.setBackground(new Color(150,100,100));
		Keys.setBackground(new Color(100,200,200));
		Kb.setBackground(new Color(100,100,100));
		Hold.setBackground(new Color(200,200,100));
		
		
		//Make space as specified by the assignment.
		Lbl.setPreferredSize(new Dimension(720,50));
		Keys.setPreferredSize(new Dimension(320,200));
		Kb.setPreferredSize(new Dimension(720,300));
		
		
		//=====Add all components to the Frame and Panel(s)====//
		Lbl.add(Lbl_txt);
		Keys.add(TxtArea_);
		Hold.add(Lbl);
		Hold.add(Keys);
		Contain.add(Hold);
		Contain.add(Padding);
		Contain.add(Kb);
		
		add(Contain);
		//============================================//
		
		//Set behaviour
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		
	}
	
	public static void main (String [] args) {
		
		new Keyboard();
		
		
	}

}
