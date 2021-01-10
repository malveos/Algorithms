import java.io.*;
class FileDemo
{
	protected void writephone()throws Exception
	{
		File f= new File("phones.txt");
		f.createNewFile();
		FileWriter fr =new FileWriter(f);
		for(int i=0;i<50;i++)
		{
			String ph="8956957";
			long num=Math.round(Math.random()*10000);
			ph+=num+"\n";
			fr.write(ph);
		}
		fr.flush();
		fr.close();
	}
	public void readphoneusingbuffered() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(new File("phones.txt")));
		String ln=br.readLine();
		while(ln!=null)
		{
			System.out.println(ln);
			ln=br.readLine();
		}
		br.close();
	}
	public void checkfileordirectory()throws Exception
	{
		File f=new File("abc.txt");
		System.out.println(f.exists());

		f.createNewFile();
		System.out.println(f.exists());
		File ff=new File("mydir");
		System.out.println(ff.exists());

		ff.mkdir();
		System.out.println(ff.exists());	
	}
	public void writein()throws Exception
	{
		File f=new File("abc.txt");
		FileWriter fw = new FileWriter(f);
		fw.write(97);
		fw.write('O');
		//fw.write('');
		fw.write("omkara");
		char []c={'a','j','l'};
		fw.write(c);
		fw.close();
	}
	public void readwhole()throws Exception
	{
		File f=new File("abc.txt");
		FileReader fr = new FileReader(f);

		char ch[]=new char[(int)f.length()];
		fr.read(ch);
		for(char cc:ch)
			System.out.print(cc);
		fr.close();
	}
	public void readbychar()throws Exception
	{
		File f=new File("phones.txt");
		System.out.println("\nUsing read only");

		FileReader fra = new FileReader(f);
		int i=fra.read();
		while(i!=-1)
		{
			System.out.print((char)i);
			i=fra.read();
		}

		fra.close();
	}
	public void showlist()throws Exception
	{
		File f=new File("C:\\Users\\Dell\\Desktop\\Assignments\\PRACTICE\\");		
		int ct=0;
		String []ls=f.list();

		for(String s1:ls)
		{
			ct++;
			System.out.println(s1);
		}
		System.out.println("Total Count:"+ct);
	}
	public static void main(String[] args) throws Exception
	{
		FileDemo d=new FileDemo();
		/*d.showlist();
		d.checkfileordirectory();
		d.writein();
		d.readbychar();
		d.readwhole();	
		*/
		//d.writephone();
		//d.readbychar();
		d.readphoneusingbuffered();
	}

}