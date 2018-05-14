package PView;



import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cmd.PComand;



public class PPanel extends JPanel
{
	
	public JTable tbl = null;
	public JScrollPane srl = null;
    public PPanel(PComand cmd) 
    {
    
    	setLayout(null);
    	cmd.pp = this;
    	tbl = new JTable(cmd.dm);
	    srl = new JScrollPane(tbl);
		srl.setBounds(0, 0, 350, 400);
		add( srl );
	
		JButton btn1 = new JButton("Create");
		JButton btn2 = new JButton("Read");
		JButton btn3 = new JButton("Update");
		JButton btn4 = new JButton("Delete");
		
		btn1.setBounds(500, 200, 100, 25);
		add(btn1);
		btn2.setBounds(500, 250, 100, 25);
		add(btn2);
		btn3.setBounds(500,300,100,25);
		add(btn3);
		btn4.setBounds(500,350,100,25);
		add(btn4);
		
		
        btn1.addActionListener(cmd.aCreate);
		btn2.addActionListener(cmd.aRead);
		btn3.addActionListener(cmd.aUP);
		btn4.addActionListener(cmd.aDelete);
		
		
    	
		
	}
}
