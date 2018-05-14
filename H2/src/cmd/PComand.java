package cmd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;


import BDAI.PDAO_H2;

import Blogic.Person;
import PView.PPanel;


public class PComand 
{
	public PPanel pp = null;
	public PTableMod dm = new PTableMod();
	
	public int id;
	
	


	public ActionRead aRead  = new ActionRead();
	public ActionCreate aCreate = new ActionCreate();
	public ActionDelete aDelete = new ActionDelete();
	public ActionUpdate aUP = new ActionUpdate();
	
	



	

	class ActionCreate implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PDialog pd = new PDialog();
			pd.setVisible(true);

			if( pd.isOk() ) 
			{
				dm.create ( pd.getPerson() );

				pp.tbl.revalidate();
				
				aRead.actionPerformed(e);
			}

		}

	}

	class ActionRead implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			dm.read();
			dm.fireTableDataChanged();

		}

	}

	class ActionDelete implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{

			PDialog pd = new PDialog();


			int c, r;
			c = pp.tbl.getSelectedColumn();
			r = pp.tbl.getSelectedRow();

			Object s=pp.tbl.getValueAt(r, c);
			String ss=s.toString();
			id = Integer.parseInt(ss);

			System.out.println(ss);

			dm.delete(new Person(id,null,null,33));
			dm.fireTableDataChanged();
			
			aRead.actionPerformed(e);

		}

	}

	

	class ActionUpdate implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PDialog pd = new PDialog();
			pd.setVisible(true);

			if( pd.isOk() ) 
			{
				dm.update( pd.getPerson() );

				dm.fireTableDataChanged();
				aRead.actionPerformed(e);
			}
		}

	}

	


}
