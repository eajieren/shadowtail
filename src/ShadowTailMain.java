import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class ShadowTailMain
{
	private static JFrame jf;
	private static JPanel jPane;
	
	public static void main(String[] args) throws Exception
	{
		jf = new JFrame("Shadow Tail");
		jf.setPreferredSize(new Dimension(500, 500));
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jf.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if(exit())
				{
					System.exit(0);
				}
         	}
        });
		JLabel jlab = new JLabel();
		jlab.setFont(new Font("Georgia", Font.BOLD, 30));
		jlab.setText("Welcome to Shadow Tail!");
		
		JLabel sqImage = new JLabel(new ImageIcon("C:/Users/eceeh/Downloads/sqPic.jpg"));
		jf.add(jlab, BorderLayout.NORTH);
		jf.add(sqImage, BorderLayout.CENTER);
		jf.pack();
		jf.setVisible(true);
		
		System.out.print("Welcome to ShadowTail!\nPlease enter the name of your squirrel explorer: ");
		/*BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String name = in.readLine();
	    System.out.println("Press ENTER to continue.");
	    in.readLine();*/
	    
	    journeyIntro();
	    //menu(name);
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
