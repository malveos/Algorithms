import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Open 
{
 
 Open()
 { 
 	try{
	Desktop.getDesktop().open(new  File("F:\\Java4-Graphics.ppt"));
}
catch(Exception e){}
}
public static void main(String []args)
{
	Open s=new Open();
}
}

