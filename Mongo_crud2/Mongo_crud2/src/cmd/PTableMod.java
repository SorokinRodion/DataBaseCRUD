package cmd;





import java.util.List;

import BDAI.Person;



import javax.swing.table.AbstractTableModel;


import BDAI.PDAO_MongoDB;



public class PTableMod extends AbstractTableModel 
{

	
	public PDAO_MongoDB pd = new PDAO_MongoDB();
	List<Person> lst = null;



	public PTableMod() 
	{
		lst = pd.read();
	}

	@Override
	public int getColumnCount()
	{

		return 4;
	}

	@Override
	public String getColumnName(int col)
	{
		String[] str = {"ID","FName","LName","Age"};
		return str[col];
	}

	@Override
	public int getRowCount() 
	{

		return lst.size();
	}

	@Override
	public Object getValueAt(int row, int col)
	{
		Object ret = null;
		Person p = lst.get(row);

		switch(col) 
		{
		case 0: ret = p._id; break;
		case 1: ret = p.fname; break;
		case 2: ret = p.lname; break;
		case 3: ret = p.age;   break;
		}
		return ret;
	}

	public void create(Person p) 
	{

		pd.create(p);
	}


	public void read() 
	{
		lst = pd.read();
	}


	public void update(Person p) 
	{
		pd.update(p);
	}


	public void delete(Person p) 
	{
		pd.delete(p);

	}



}
