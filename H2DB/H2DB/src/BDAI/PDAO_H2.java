package BDAI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Blogic.Person;

public class PDAO_H2 
{
	
	public void create(Person p)
	{
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();
			st.execute("Insert INTO PERSON VALUES("+p.id+",'"+p.fname+"','"+p.lname+"',"+p.age+")");
		} catch (ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}
	}

	public List<Person> read()
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM PERSON");

			while(rs.next()) 
			{

				pp.add( new Person( rs.getInt("id"), rs.getString("FName"), rs.getString("LName"), rs.getInt("age") ) );
			}
			con.close();

		}
		catch(SQLException | ClassNotFoundException e)
		{

		}


		return pp;
	}

	public void update(Person p) 
	{
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();
			st.execute("UPDATE PERSON SET FName='"+p.fname+"', LName='"+p.lname+"', age ="+p.age+" WHERE ID="+p.id+";");
		} catch (ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}
	}

	public void delete(Person p) 
	{
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();
			st.execute("DELETE FROM PERSON WHERE ID="+p.id+"");
		} catch (ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}
	}

	

}
