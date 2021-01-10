import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

class MyPanel1 extends Panel
{
	Image img;
	int x,y,w,h,flg;
	MyPanel1(Image img)
	{

		super();
		this.img=img;
		flg=0;
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(flg==0)
				{
					x=e.getX();
					y=e.getY();
					flg=1;
				}
				else
				{
					w=e.getX()-x;
					h=e.getY()-y;
					flg=0;
					repaint();
				}
			}
		});
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(img,x,y,w,h,this);
	}
}


class ImgInFrm3 extends Frame
{
	Image img;
	MyPanel1 pan;
	ImgInFrm3()
	{
		super("Image");
		File f=new File("F:\\Images\\super\\53.jpg");
		try
		{
			img=ImageIO.read(f);
		}
		catch(Exception e){}
		pan=new MyPanel1(img);
		add(pan);
		
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
	
	public static void main(String []args)
	{
		ImgInFrm3 a=new ImgInFrm3();
	}

}