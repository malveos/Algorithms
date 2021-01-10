import java.sql.*;
import mypkg.Util;

class NewInsertRow
{
	public static void main(String []args)
	{
		Connection con=null;
		PreparedStatement psi=null,pss=null;
		ResultSet rs=null;
		int id=0,fees=0;
		String cnm="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:WCEA");
			pss=con.prepareStatement("select * from Course where cid=?");
			psi=con.prepareStatement("insert into course values(?,?,?,?)");
			while(true)
			{
				id=Util.iInput("Enter course id:");
				if(id==0)
					break;
				pss.setInt(1,id);
				rs=pss.executeQuery();
				if(rs.next()==true)
				{
					Util.display("Record exists");
					continue;
				}


				cnm=Util.sInput("Enter Name:");
				fees=Util.iInput("Enter Feees");


				psi.setInt(1,id);
				psi.setString(2,cnm);
				psi.setInt(3,fees);
				psi.setBoolean(4,true);
				psi.executeUpdate();

				psi.close();
				pss.close();
				con.close();

			}
		}
			catch(Exception ee){
				System.out.println(ee);
			}
		
	}
}