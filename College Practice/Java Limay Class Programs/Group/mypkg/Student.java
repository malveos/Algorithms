package mypkg;
import javax.swing.*;

public class Student
{
        int no;
        String nm="";
        public Student()
        {
                no=0;
                nm="";
        }
        public void setData(int n)
        {
                no=n;
                nm=JOptionPane.showInputDialog(null,"Name:");
        }
        public void setData()
        {
                try
                {
                        no=Integer.parseInt(JOptionPane.showInputDialog(null,"Number"));
                }
                catch(Exception e)
                {
                }
                setData(no);
        }
        public String toString()
        {
                String s="Roll no:"+no+"\nName:"+nm;
                return s;
        }
        public void display()
        {
                JOptionPane.showMessageDialog(null,toString());
        }
}
