import java.sql.*; 
class ProcCall { 
public static void main(String[] a) { 
CallableStatement CS;
try { 
	Class.forName ("oracle.jdbc.driver.OracleDriver"); 
		   Connection connect = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe",
               "omkar","om");
           Statement stmt = connect.createStatement(); 
	       System.out.println("Connected to Database");
	       CS=connect.prepareCall("{call award_bonusC(?,?,?)}");
	       CS.setInt("emp_id",3);
	       CS.setDouble("Bonus_rate",0.01);
           CS.registerOutParameter("msg",Types.CHAR);
	       // Execute Stored Procedure
	       CS.execute();
           String outParam = CS.getString("msg");	//OUT para
	       System.out.println(outParam);      
           connect.close(); 
} 
catch(Exception e) {System.out.println(e);} 
} 
}
