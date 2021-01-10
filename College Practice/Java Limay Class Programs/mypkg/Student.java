/*
 here to access the Student.java set CLASSPATH=Desktop\assigh\omkar
 
 i.e. one folder up







*/

package mypkg;
import mypkg.Util;
import java.io.*;

public class Student implements Serializable
{
	private int rn;
	private String nm;
	private double mrk;
	private  boolean state;

	public Student()
	{
		rn=0;
		nm="";
		mrk=0.0;
		state=true;
	}
	public int getRollNo(){return rn;}
	public String getName(){return nm;}
	public double getMark(){return mrk;}
	public boolean getState(){return state;}
	public void setData(int n)
	{
		rn=n;
		nm=Util.sInput("Name:");
		mrk=Util.dInput("Marks");
		state=true;
	}
	public void setState(boolean flag){state=flag;}
	public String toString()
	{
		String s="\nRoll no:"+rn+"\nName:"+nm+"\nMarks:"+mrk+"\nState:"+state;
		return s;
	}	
	public void display()
	{
		Util.display(toString());
	}
}	