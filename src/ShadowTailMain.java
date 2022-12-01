import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ShadowTailMain extends JFrame implements KeyListener
{	
	public ShadowTailMain()
	{
		super("Shadow Tail");
		
		//set customizable settings of Frame
		setPreferredSize(new Dimension(500, 500));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if(exit())
				{
					System.exit(0);
				}
         	}
        });
		
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
		
		//add the KeyListener, which happens to be the same object
		addKeyListener(this);
	}
	
	/********************************************************************************************/
	//set the 3 functions to satisfy the KeyListener interface required functions
	/********************************************************************************************/
	public void keyPressed(KeyEvent ke){
		//filler to satisfy the KeyListener interface
	}
	
	//closes this Frame when the user presses ENTER
	public void keyReleased(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_ENTER)
		{
			System.out.println("Key Released");
			dispose();
		}
	}
	
	public void keyTyped(KeyEvent ke){
		//filler to satisfy the KeyListener interface
	}
	/********************************************************************************************/
	
	public static void main(String[] args)
	{
		displayWelcome();
		
		System.out.print("Welcome to ShadowTail!\nPlease enter the name of your squirrel explorer: ");
	    
	    journeyIntro();
	    //menu(name);
	}
	
	private static void displayWelcome()
	{
		ShadowTailMain stMain = new ShadowTailMain();		
		
		//ready the JFrame to show
		stMain.pack();
		stMain.setVisible(true);
	}
	
	private static void journeyIntro()
	{
		System.out.println("\nYou are a fantastic fox squirrel traversing the daily dangers of Foxwood Manor,\n" +
				"a small suburban community. Your goal is to stay alive by gathering food for winter, avoiding\n" +
				"predators, cars, and upset gardeners and bird-watchers. You must survive through the winter,\n" +
				"because in the spring, your uncle, Skiouros the Sage, is coming to visit and take you on a journey.");
	}
	
	private static void menu(String sqName)
	{
		System.out.println("\n1.Start " + sqName + "\'s adventure\n2.Sleep");
	}
	
	private static boolean exit()
	{
		return JOptionPane.showConfirmDialog(null, "Are you sure that you want to quit Shadow Tail?",
			"EXIT?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
	}
}
