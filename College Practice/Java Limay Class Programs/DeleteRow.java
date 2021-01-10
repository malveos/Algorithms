import java.sql.*;
import mypkg.Util;

class DeleteRow
{
	public static void main(String []args)
	{
		Connection con=null;
		PreparedStatement pss=null,psu=null;
		ResultSet rs=null;
		int id=0,fees=0;
		String cnm="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:WCEA");
			pss=con.prepareStatement("select * from Course where cid=?");
			psu=con.prepareStatement("update course set cstate=? where cid=?");
			while(true)
			{
				id=Util.iInput("Enter course id:");
				if(id==0)
					break;
				pss.setInt(1,id);
				rs=pss.executeQuery();
				if(rs.next()==false)
				{
					Util.display("Record not found");
					continue;
				}
				psu.setInt(2,id);
				psu.setBoolean(1,false);
				psu.executeUpdate();

				psu.close();
				pss.close();
				con.close();

			}
		}
			catch(Exception ee){
				System.out.println(ee);
			}
		
	}
}