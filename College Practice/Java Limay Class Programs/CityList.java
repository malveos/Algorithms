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
class CityList extends Frame implements ActionListener
{
	Label lct;
	List obj;
	Button bn,br,bc,be;
	CityDialog cobj;
	CityList()
	{
		super("City List!!!");
		lct=new Label("City");
		obj=new List(10,true);
		bn=new Button("New");
		br=new Button("Remove");
		bc=new Button("Clear All");
		be=new Button("Exit");

		bn.addActionListener(this);
		br.addActionListener(this);
		bc.addActionListener(this);
		be.addActionListener(this);

		setLayout(null);
		lct.setBounds(50,50,100,20);
		obj.setBounds(50,90,180,100);
		bn.setBounds(230,50,100,20);
		br.setBounds(230,90,100,20);
		bc.setBounds(230,130,100,20);
		be.setBounds(230,170,100,20);

		add(lct);
		add(obj);
		add(bn);
		add(br);
		add(bc);
		add(be);
		setSize(370,240);
		cobj=new CityDialog(this,"City",true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		Button b=(Button)e.getSource();

		if(b==bn)
		{
			cobj.setVisible(true);
			String str=cobj.nm;
			obj.add(str);

		}

		if(b==br)
		{
			int i=obj.getSelectedIndex();
			if(i!=-1)
				obj.remove(i);
		}
		if(b==bc)
			obj.clear();
		if(b==be)
			System.exit(0);
	}
	public static void main(String []args)
	{
		CityList a=new CityList();
	}
}