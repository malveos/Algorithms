import java.sql.*;
import mypkg.Util;

class InsertRow
{
	public static void main(String []args)
	{
		Connection con;
		PreparedStatement pi;
		int id=0,fees=0;
		String cnm="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:WCEA");
			pi=con.prepareStatement("insert into Course values(?,?,?,?)");
			while(true)
			{
				id=Util.iInput("Enter course id:");
				if(id==0)
					break;
				cnm=Util.sInput("Enter Name:");
				fees=Util.iInput("Enter Feees");


				pi.setInt(1,id);
				pi.setString(2,cnm);
				pi.setInt(3,fees);
				pi.setBoolean(4,true);
				pi.executeUpdate();

				pi.close();
				con.close();

			}
		}
			catch(Exception ee){
				System.out.println(ee);
			}
		
	}
}