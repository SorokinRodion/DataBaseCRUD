package BDAI;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Blogic.Person;

public class PDAO_MySQL 
{

	public void create(Person p) 
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?user=root&password=");
			Statement st = conn.createStatement();
			st.execute("INSERT INTO `user` (`id`, `fname`, `lname`, `age`) VALUES ('"+p.id+"', '"+p.fname+"', '"+p.lname+"', '"+p.age+"');");

			conn.close();
		} catch ( ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}
	}

	public List<Person> read() 
	{
		ArrayList<Person> pp = new ArrayList<Person>();

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?user=root&password=");
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM USER");
			while ( rs.next() ) 
			{
				pp.add( new Person( rs.getInt("ID"), rs.getString("FName") , rs.getString(3), rs.getInt(4) ) );
			}
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

	public void update(Person p) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?user=root&password=");
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE `user` SET `fname`='"+p.fname+"', `lname` = '"+p.lname+"', `age` = '"+p.age+"' WHERE `id`="+p.id+"");
			

			conn.close();
		} catch ( ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}
	}

	public void delete(Person p) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?user=root&password=");
			Statement st = conn.createStatement();
			st.execute("DELETE FROM `user` WHERE `id` LIKE '"+p.id+"' LIMIT 1;");

			conn.close();
		} catch ( ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}
	}


}
