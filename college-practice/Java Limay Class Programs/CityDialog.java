import java.awt.event.*;
import java.awt.*;
class CityDialog extends Dialog implements ActionListener
{
	Label lnm;
	public String nm;
	TextField tnm;
	Button bok,bcan;
	CityDialog(Frame hostname,String title,boolean bmodal)
	{	
		super(hostname,title,bmodal);
		lnm=new Label("Name");
		tnm=new TextField(40);
		bok=new Button("OK");
		bcan=new Button("CANCEL");
		bok.addActionListener(this);
		bcan.addActionListener(this);

		setLayout(new GridLayout(2,2,5,5));
		add(lnm);
		add(tnm);
		add(bok);
		add(bcan);

		setSize(400,400);
	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();
		if(b==bok)
			nm=tnm.getText();
		else
			nm="";

		setVisible(false);
	}
} 