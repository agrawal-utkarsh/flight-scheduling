package agrawal.utkarsh.flight_schedulling;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class record 
{
	private String date,time,name,phone;
	public record()
	{
		
	}


	private record(String date, String time, String name, String phone) {
		super();
		this.date = date;
		this.time = time;
		this.name = name;
		this.phone = phone;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<record>viewall()
	{
		List<record>rec=new ArrayList<record>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/flight","newuser","password");
			PreparedStatement ps=con.prepareStatement("select * from flier");
			ResultSet rs=ps.executeQuery();
			//convert rs into list and return
			while(rs.next())
			{
				rec.add(new record(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rec;
	}
	public List<record>view(String input)
	{
		List<record>rec=new ArrayList<record>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/flight","newuser","password");
			PreparedStatement ps=con.prepareStatement("select * from flier where date=?");
			ps.setString(1,input);
			ResultSet rs=ps.executeQuery();
			//convert rs into list and return
			while(rs.next())
			{
				rec.add(new record(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rec;
	}
	public int insert(String date,String time,String name,String phone)
	{
		int res=0;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/flight","newuser","password");
			PreparedStatement ps=con.prepareStatement("insert into flier values (?,?,?,?)");
			ps.setString(1, date);
			ps.setString(2, time);
			ps.setString(3, name);
			ps.setString(4, phone);
			res=ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return res;
	}
}
