
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.Font;

//import javax.swing.ImageIcon;
//import javax.swing.JComponent;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;

public class ShadowTailMain extends JFrame implements KeyListener
{	
	private static final int F_WIDTH = 500, F_HEIGHT = 500;
	private ShadowTailDisplay stDisplay;
	
	public ShadowTailMain()
	{
		super("Shadow Tail");
		
		stDisplay = new ShadowTailDisplay();
		
		//set customizable settings of Frame
		setPreferredSize(new Dimension(F_WIDTH, F_HEIGHT));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ShadowTailMain stm = this;
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if(exit(stm))
				{
					System.exit(0);
				}
         	}
        });
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
			
			String[] userInfo = stDisplay.intro();
			
			stDisplay.homeNestMenu(userInfo[0], userInfo[1]);
			add(stDisplay);
			pack();
			setVisible(true);
		}
	}
	
	public void keyTyped(KeyEvent ke){
		//filler to satisfy the KeyListener interface
	}
	/********************************************************************************************/
	
	public static void main(String[] args)
	{
		ShadowTailMain stMain = new ShadowTailMain();
		stMain.displayWelcome();
		
		
		
		System.out.print("Welcome to ShadowTail!\nPlease enter the name of your squirrel explorer: ");
	    
	    journeyIntro();
	    //menu(name);
	}
	
	private void displayWelcome()
	{
		//sets the in-built panel to the welcome; then adds it to the Frame
		stDisplay.welcome();
		//stDisplay.homeNestMenu();
		add(stDisplay);
		
		//add the KeyListener, which happens to be the same object
		addKeyListener(this);
		
		//ready the JFrame to show
		pack();
		setVisible(true);
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
	
	private static boolean exit(JFrame jf)
	{
		return JOptionPane.showConfirmDialog(jf, "Are you sure that you want to quit Shadow Tail?",
			"EXIT?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
	}
}
