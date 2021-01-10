package mypkg;
import java.sql.*;
public class DMD
{
	public static Connection con;
	public static PreparedStatement pti,ptm,ptd,pts,ptdisplay;
	public static PreparedStatement pri,prm,prd,prs,prdisplay;
	public static PreparedStatement phi,phd,phs,phdisplay;
	public static PreparedStatement pptdisplay,ppti,pptd;

	static
	{
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:SPLDSN");
		pti=con.prepareStatement("insert into test values(?,?,?,?)");
		ptm=con.prepareStatement("update test set tnm=?,tfee=? where tid=?");
		ptd=con.prepareStatement("update test set tstate=false where tid=?");
		pts=con.prepareStatement("select * from test");

		}
		catch(Exception e){}
	}
}