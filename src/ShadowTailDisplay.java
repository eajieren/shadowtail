import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShadowTailDisplay extends JPanel
{
	/**
	 * 
	 */
	private static final int F_WIDTH = 500, F_HEIGHT = 500;
	private static final long serialVersionUID = 1L;
	private static boolean initiated;
	
	private static final HashMap<Integer, String> weatherStrs = new HashMap<Integer, String>();

	public ShadowTailDisplay()
	{
		super();
		if(!initiated)
		{
			initiate();
		}
	}
	
	public void welcome()
	{
		//empty the container of all components
		removeAll();
		
		//create the title label, the associated pic, and an instruction label
		JLabel jlab = new JLabel();
		jlab.setFont(new Font("Georgia", Font.BOLD, 30));
		jlab.setText("Welcome to Shadow Tail!");
		JLabel sqImage = new JLabel(new ImageIcon("C:/Users/eceeh/Downloads/sqPic.jpg"));
		JLabel instrLab = new JLabel("Press ENTER to continue.");
		instrLab.setFont(new Font("Arial", Font.ITALIC, 14));
				
		//add the labels and image to the JFrame
		add(jlab, BorderLayout.NORTH);
		add(sqImage, BorderLayout.CENTER);
		add(instrLab, BorderLayout.SOUTH);
	}
	
	public void homeNestMenu(String name, String gender)
	{
		removeAll();
		
		//view calendar option could be displayed when you're near a human home
		JLabel nameO = new JLabel(name + " is safely in " + getPossessiveAdj(gender) + " drey.");
		JLabel currentStatus = new JLabel("Today is... ");
		
		JButton leave = new JButton("Leave the nest");
		
		//nutsToWinter(buried), etc.
		JButton goalStatus = new JButton("Goal Status");
		
		//includes things like need to gnaw, to drink, to eat, to sleep, 
		JButton health = new JButton("Health");
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(nameO);
		add(currentStatus);
		add(leave);
		add(goalStatus);
		add(health);
	}
	
	//introduces the user to the game's overall idea and asks the user to enter a name for his/her
	//squirrel adventurer; then returns that name
	public String[] intro()
	{
		String input = "";
		
		//JDialog and its method, setModalityType, help us to hold the program until the user enters input
		JDialog diaFrame = new JDialog();
		
		//set up a JLabel explaining the game
		String premise = "You are a fantastic fox squirrel traversing the daily dangers of Foxwood Manor, a small suburban community. Your goal is to stay alive by gathering food for winter, avoiding predators, cars, and upset gardeners and bird-watchers. You must survive through the winter, because in the spring, your uncle, Skiouros the Sage, is coming to visit and take you on a journey.\n\n\nPlease enter the name of your bushy-tailed adventurer:";
		premise = String.format("<html><div style=\"width:%dpx;\">%s</div></html>", F_WIDTH - 150, premise);
		JLabel summary =  new JLabel(premise);
			
		//set up a TextField for name input
		JTextField inputSpot = new JTextField();
		inputSpot.setColumns(40);
		//inputSpot.setPreferredSize(new Dimension(200, 20));
		inputSpot.setVisible(true);
			
		//sets up the specifics for the JDialog frame
		diaFrame.setSize(new Dimension(F_WIDTH, F_HEIGHT));
		diaFrame.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		diaFrame.setLayout(new FlowLayout());
		diaFrame.add(summary);
		diaFrame.add(inputSpot);
			
		//set up the action-listener that will determine when the JDialog returns control of the
		//program to the regular code-flow
		
		UserSetupListener usl = new UserSetupListener();
		inputSpot.addActionListener(usl);
			
		//upon setting the JDialog visible, it holds control of the program until it is disposed
		//(upon user pressing ENTER)
		diaFrame.setVisible(true);
			
			//iterations++;
		//input = inputSpot.getText();
		//System.out.println(inputSpot.getActionListeners()[0].plyrGender);
		
		
		return new String[] {inputSpot.getText(), usl.getGender()};
	}
	
	private static void initiate()
	{
		weatherStrs.put(1, "The cold wind howls through the surrounding trees and lightly shakes the branches of your nest.");
		weatherStrs.put(2, "Light rain patters in a steady rhythm on the nest");
		initiated = true;
	}
	
	private static String getPossessiveAdj(String gender)
	{
		/*if(gender == "Male")
			return "his";
		return "her";*/
		
		return (gender == "Male") ? "his" : "her";
	}
	
	private class UserSetupListener implements ActionListener
	{
		private String plyrGender;
		
		public void actionPerformed(ActionEvent ae)
		{
	    	  JTextField jtf = (JTextField) ae.getSource();
	    	  if(jtf.getText().length() > 0)
	    	  {
	        	  jtf.setEditable(false);
	        	  
	        	  String[] genders = {"Male", "Female"};
	      		  int choiceIndex = JOptionPane.showOptionDialog(jtf.getParent(), "Please select " + jtf.getText() + "\'s gender:", "Gender", 2, JOptionPane.QUESTION_MESSAGE,
	      				null, genders, genders[0]);
	      		  plyrGender = genders[choiceIndex];
	      		  
	      		  Container c = jtf.getParent();
	      		  while(!(c instanceof JDialog))
	      			 c = c.getParent();
	      		  ((JDialog)c).dispose();
	      		  //((JDialog) (jtf.getParent().getParent().getParent().getParent())).dispose();
	              //((JTextField) ae.getSource()).getParent().dispose();
	    	  }
	    	  else
	    		  JOptionPane.showMessageDialog(jtf.getParent(), "Invalid entry. Please enter some value for a name.");
		}
		
		public String getGender()
		{
			return plyrGender;
		}
	}
}
