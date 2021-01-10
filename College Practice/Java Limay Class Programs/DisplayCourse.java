import java.sql.*;
import mypkg.Util;

class DisplayCourse
{
	public static void main(String []args)
	{
		Connection con;
		Statement st;
		ResultSet rs;
		int id=0,fees=0;
		String cnm="";
		boolean state;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:WCEA");
			
			st=con.createStatement();
			rs=st.executeQuery("select * from course");
			String s="Data:\nID:\tName\tFees\tState\n";
			while(rs.next())
			{
				id=rs.getInt(1);
				cnm=rs.getString(2);
				fees=rs.getInt(3);
				state=rs.getBoolean(4);
				s+=""+id+"\t"+cnm+"\t"+fees+"\t"+state+"\n";
			}
				//Util.display(s);
				System.out.println(s);
				con.close();

			
		}
			catch(Exception ee){}
		
	}
}