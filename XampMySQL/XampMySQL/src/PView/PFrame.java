package PView;

import javax.swing.JFrame;

import cmd.PComand;
import cmd.PTableMod;


public class PFrame extends JFrame
{
	public PFrame() 
	{
		
		setTitle("DB Person");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(50, 50, 700, 500);
		
		PComand pc = new PComand();
		
		add( new PPanel(pc));
		
		setVisible(true);
	}

}
