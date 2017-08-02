package a3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;




@SuppressWarnings("serial")
public class Keyboard extends JFrame implements KeyListener{
	//=======Components and Containers==============//
	private JPanel Contain = new JPanel();
	private JPanel Padding = new JPanel();
	private JPanel Lbl  = new JPanel();
	private JPanel Keys = new JPanel();
	private JTextArea TextArea = new JTextArea();
	private JScrollPane TxtArea_ = new JScrollPane(TextArea);
	private JPanel Hold = new JPanel();
	private JPanel Kb = new JPanel();
	private JLabel Lbl_txt = new JLabel();
	//===============================//
	
	private static final String [] KeysText = {"~","1","2","3","4","5","6","7","8","9","0","-","+","Backspace",
											"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\", //27
											"Caps","A","S","D","F","G","H","J","K","L",":","\"","Enter", //40
											"Shift","Z","X","C","V","B","N","M",",",".","?","","^", " "," "," ","<","v",">"};
	private boolean isSpam = false; //So shift, backsspace, etc cant be held down and destroy my syso.
	
	public Keyboard() {
		
		this.setTitle("Typing Tutor");
		this.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));		
		this.setSize(858, 630);  
		
		//Global Container 
		Contain.setLayout(new BoxLayout(Contain,BoxLayout.Y_AXIS));
		//Label Container
		Lbl.setLayout(new FlowLayout(FlowLayout.LEADING));
		//Holds Both the Lbl and Text area as required by assignment dimensions
		Hold.setLayout(new BoxLayout(Hold,BoxLayout.Y_AXIS));	//Make Hold place components
		//Eat 100% of available panel space
		Keys.setLayout(new GridLayout(1,1));
		
		Kb.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		SetKeys(Kb);
		
		//==============TextArea=============//
		//Prevents shaking component and makes sure text wraps.
		//Wrapping via Javadocs style
		TextArea.addKeyListener(this);
		TextArea.setLineWrap(true);
		TextArea.setWrapStyleWord(true);
		//=============================//
	
	
		//Display text, note HTML since JLabel supports it and means less Panels.
		Lbl_txt.setText("<html><body><p>Type some text using your keyboard. The keys you press will be highlighted and the text"
				+ " will be displayed.</p><p>Note: Clicking the buttons with your mouse will not perform any action </p></body> </html>");

		//Lbl.setBackground(new Color(150,100,100));
	//	Keys.setBackground(new Color(100,200,200));
	//	Kb.setBackground(new Color(100,100,100));
		
		//Make space as specified by the assignment.
		Lbl.setPreferredSize(new Dimension(827,40));
		Keys.setPreferredSize(new Dimension(420,210));
		Kb.setPreferredSize(new Dimension(827,300));
		//Make an invisible divider while keeping the components vertically stacked
		Padding.setPreferredSize(new Dimension(25,20));
			
		Kb.setFocusTraversalKeysEnabled(true);
		//=======Add all components to the Frame and Panel(s)====//
		Lbl.add(Lbl_txt);
		Keys.add(TxtArea_);
		Hold.add(Lbl);
		Hold.add(Keys);
		Contain.add(Hold);
		Contain.add(Padding);
		Contain.add(Kb);
		add(Contain); //Add to frame
		//============================================//
		
		//Set behaviour
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		
	}
	public void keyTyped(KeyEvent type){//Prevent spamming syso 
		//----//
		
	}
	public void keyReleased(KeyEvent type) {
	       //Switch characters() 	
		  isSpam = false; //Reset spam prevention
		  
		  //Skip Line like a typewriter. Spam on syso ends
	}
	
	public void keyPressed(KeyEvent type) {
	    //Switch characters() 
      
		int insp = type.getKeyCode();
		String Key = KeyEvent.getKeyText(insp);
	
		boolean Spam = (insp == KeyEvent.VK_SHIFT || insp == KeyEvent.VK_BACK_SPACE) ? true : false; 
		boolean isValid;
		

		//Useful, reduces strain by only performing 1 array check vs multiple conditional checks.
		if(isSpam == false) {
		
			Key = ReplacewithString(Key);	
			isValid = isMemberOfArray(Key);
			
		}else {
			//Shift + letter is a-ok
			if(Key.matches("[a-zA-Z]") == true){
				isValid = true; //Well a-z is part of keyboard...
				Spam = false;
				isSpam = false;
				//SwitchCase()
				
			}else {
				switch(Key) {
					case "Slash":
					case "Back Quote":
					case "Quote":
					case "Semicolon":
					case "Equals": //Actually +
					Key = ReplacewithString(Key);
					isValid = isMemberOfArray(Key);
					Spam = false;
					isSpam = false;
					
					break;
				default:
					isValid = false;
				
				}
			}
		
		}
		
		//Check for key spam and valid key entry
		  if(isValid == true && (Spam == false)){
			 System.out.println("Traversal: Switch Pass "+ Key);
		  }else if(isValid == true && (Spam == true) && (isSpam == false)) {
			  isSpam = true; // Prevent the spam of useless chars to syso by flag
			  System.out.println("Traversal: (Spam)"+ Key);
		  }else if( isValid == true && isSpam == true) {
			 
		  }
		  
	}
	
//Will make caps when caps lock is pressed(or depressed)
//With shift though: Underlines the key since 
	
//	private void switchAlpha(boolean Capital) {
	
		
//	}
	private String ReplacewithString(String key2) {
		switch (key2) {
		case "Slash":
			return "?";
		case "Back Slash":
			return "\\";
		case "Back Quote":
			return "~";
		case "Quote":
			return "\"";
		case "Semicolon":
			return ":";
		case "Open Bracket":
			return "[";
		case "Close Bracket":
			return "]";
		case "Minus":
			return "-";
		case "Equals":
			return "+";
		case "Caps Lock":
			return "Caps";
		case "Comma":
			return ",";
		case "Period":
			return ".";
		case "Up":
			return "^";
		default:
			return key2;
		}
	}
	public boolean isMemberOfArray(String test) {

		System.out.println("Testing:" + test);
		 for (String s: KeysText) {
		        if (s.equals(test) && test != "Down" ) {
		        	
		        	System.out.println("Valid Catch");
		            return true;
		        }else if( test == "Down") {
		        	//for the down arrow since its also 'v'
		        }
		}
		 
		 return false;
	}
	
	
	//Write some buttons using the array and size them based on the element.
	public static void SetKeys(Container kb) {
		for(int i = 0; i < KeysText.length; i++) {
		
			switch(i) {
			//Make a Double Sized key
				case 41:
				case 40:
				case 13: 
					JButton button_Ext = new JButton(GetNextKey(i));
					button_Ext.setAlignmentX(Component.CENTER_ALIGNMENT);
					button_Ext.setPreferredSize(new Dimension(110,60));
					button_Ext.setFont(new Font("Arial",Font.BOLD,12));

					kb.add(button_Ext);
					break;
		
			//Make a 1.5 Sized Key
				case 28:
				case 14: 
					JButton button_FullHalf = new JButton(GetNextKey(i));
					button_FullHalf.setAlignmentX(Component.CENTER_ALIGNMENT);
					button_FullHalf.setPreferredSize(new Dimension(86,60));
					button_FullHalf.setFont(new Font("Arial",Font.BOLD,12));
					kb.add(button_FullHalf);
					break;
			
			//Make a .5 sized invisible panel
				case 52:
					JPanel button_Half = new JPanel();
					button_Half.setPreferredSize(new Dimension(31,60));
					button_Half.setVisible(true);
					kb.add(button_Half);
					break;
			
			//Make a space divider for the space bar
				case 54:
					JPanel divide = new JPanel();
					divide.setPreferredSize(new Dimension(218,60));
					divide.setEnabled(true);
					divide.setVisible(true);
					kb.add(divide);
					break;
			//Make a space bar key	
				case 55:
					JButton button_Space = new JButton(GetNextKey(i));
					button_Space.setPreferredSize(new Dimension(335,60));
					kb.add(button_Space);
					break;
			//Make a r-side divider for the arrow keys
				case 56:
					JPanel divide_r = new JPanel();
					divide_r.setPreferredSize(new Dimension(83,60));
					divide_r.setEnabled(true);
					divide_r.setVisible(true);
					kb.add(divide_r);
					break;
			//Make a standard key
				default:
					JButton button = new JButton(GetNextKey(i));
					button.setAlignmentX(Component.CENTER_ALIGNMENT);
					button.setPreferredSize(new Dimension(55,60));
					button.setFont(new Font("Arial",Font.BOLD,12));
					kb.add(button);
					break;
			}
	
		}
		
		
	}
	
//Return KeysText[element]
	public static String GetNextKey(int arrAt) {
		return KeysText[arrAt];
	}
	
//Initialize
	public static void main (String [] args) {
		new Keyboard();
	}

}
