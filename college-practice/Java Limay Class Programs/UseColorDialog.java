import mypkg.MyColor;
import java.awt.*;
import java.awt.event.*;
class UseColorDialog extends Frame
{
	MyColor cobj;
	int x,y,w,h,flg;
	Color cr;
	UseColorDialog()
	{
		super("Clr disp");
		cobj=new MyColor(this,"COLOR",true);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});


		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getButton()==MouseEvent.BUTTON3)
				{
					cobj.setVisible(true);
					cr=new Color(cobj.r,cobj.g,cobj.b);
				}
				else
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
						draw();
					}
				}
			}
		});
		cr=new Color(0,0,0);
		setSize(500,500);
		setVisible(true);

	}
	void draw()
	{
		Graphics gr=getGraphics();
		gr.setColor(cr);
		gr.drawOval(x,y,w,h);
	}
	public static void main(String []args)
	{
		UseColorDialog a=new UseColorDialog();
	}
}