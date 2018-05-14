package cmd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import BDAI.Person;

public class PDialog extends JDialog
{
	JTextField txtId;
	JTextField txtFn;
	JTextField txtLn;
	JTextField txtAg;
	boolean res = false;
	
     public PDialog() 
     {
    	 setLayout(null);
    	 setModal(true);
    	 
    	 setBounds(10, 10, 600, 600);
    	 txtId = new JTextField();
    	 txtFn = new JTextField();
    	 txtLn = new JTextField();
    	 txtAg = new JTextField();
    	 
    	 txtId.setBounds(10, 50, 100, 25);
    	 txtFn.setBounds(10, 100, 100, 25);
    	 txtLn.setBounds(10, 150, 100, 25);
    	 txtAg.setBounds(10, 200, 100, 25);
    	 
    	 add(txtId);
    	 add(txtFn);
    	 add(txtLn);
    	 add(txtAg);
    	 
    	 JButton btnok = new JButton("ok");
    	 JButton btnCn = new JButton("Cancel");
    	 
    	 btnok.setBounds(10, 300, 100, 25);
    	 btnCn.setBounds(10, 400, 100, 25);
    	 
    	 add(btnok);
    	 add(btnCn);
    	 
    	 btnok.addActionListener( new ActionOk() );
    	 btnCn.addActionListener(new ActionCn() );
    	 
    	 
    	 
     }
     class ActionOk implements ActionListener
     {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			res = true;
			setVisible(false);
			
		}
    	 
     }
     class ActionCn implements ActionListener
     {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			res = false;
			setVisible(false);
			
		}
    	 
     }
     
     public boolean isOk() 
     {
    	 return res;
     }
     
     
     public Person getPerson()
     {
    	 Person p = new Person();
    	 p._id = Integer.parseInt(txtId.getText());
    	 p.fname = txtFn.getText();
    	 p.lname = txtLn.getText();
    	 p.age  = Integer.parseInt(txtAg.getText());
    	 return p;
     }
     
     
     
     public void setPerson(Person p)
     {
    	 txtId.setText( "" + p._id);
    	 txtFn.setText( p.fname);
    	 txtLn.setText(p.lname);
    	 txtAg.setText( "" + p.age);
     }
     
     
}
