import java.awt.*;
import java.awt.event.*;
import javax.swing.*;    
public class ShowColors extends JFrame 
{
 	private JButton changeColorButton;
	private Color color = Color.LIGHT_GRAY;
	private Container container;
0000
  	public ShowColors()
    {
    	super( "Using JColorChooser" );
      container = getContentPane();
      container.setLayout( new FlowLayout() );
  
       // set up changeColorButton and register its event handler
        changeColorButton = new JButton( "Change Color" );
        changeColorButton.addActionListener(new ActionListener()
         {  // anonymous inner class
                // display JColorChooser when user clicks button
              public void actionPerformed( ActionEvent event )
                {
                  color = JColorChooser.showDialog(ShowColors.this, "Choose a color", color );
   
                   // set default color, if no color is returned 
                if ( color == null )
                     color = Color.LIGHT_GRAY;
   
                  // change content pane's background color
                   container.setBackground( color );
                }
       	      } // end anonymous inner class
         ); // end call to addActionListener
     
          container.add( changeColorButton );
    
          setSize( 400, 130 );
          setVisible( true );
      }
       // execute application
       public static void main( String args[] )
       {
         ShowColors application = new ShowColors();
         application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      }
  // end class ShowColors2

}