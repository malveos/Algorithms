import java.awt.*;
import java.awt.event.*;
class Sample extends Frame implements AdjustmentListener
{
	Sample()
	{
		Scrollbar s=new Scrollbar(Scrollbar.HORIZONTAL,0,20,50,1000);
		s.addAdjustmentListener(this);
		add(s,"South");
		setSize(400,400);
		setVisible(true);
	}
	public void adjustmentValueChanged(AdjustmentEvent e)
	{

	}
	public static void main(String[] args) {
		Sample ss=new Sample();
	}

} 