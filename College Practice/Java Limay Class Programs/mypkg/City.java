package mypkg;
import mypkg.Util;
import java.io.*;

public class City implements Serializable
{
	
	public int id;
	public String nm;
	public City()
	{id=0;nm="";}
	public City(int id,String nm)
	{
		this.id=id;
		this.nm=nm;
	}
	public void setData(int d)
	{
		id=d;
		nm=Util.sInput("Name of city");
	}
	public void setData()
	{
		id=Util.iInput("Enter id for city");
		setData(id);
	}
	public String toString()
	{
		String s="City Data:\nID:"+id+"\nName:"+nm;
		return s;
	}
	public void display()
	{
		Util.display(toString());
	}
	public int getID()
	{
		return id;
	}
	public String getName()
	{return nm;}
}