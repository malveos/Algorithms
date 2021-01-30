import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

class ImgInFrm1 extends Frame
{
	BufferedImage img;
	ImgInFrm1()
	{
		super("Image");
		File f=new File("F:\\Images\\super\\53.jpg");
		try
		{
			img=ImageIO.read(f);
		}
		catch(Exception e){}

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setSize(800,800);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		g.drawImage(img,50,50,this);
	}
	public static void main(String []args)
	{
		ImgInFrm1 a=new ImgInFrm1();
	}

}