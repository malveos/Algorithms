class jo extends Thread
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("CuCu ..........");
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{

			}
		}
	}
}
class ThreadJoin
{
	public static void main(String[] args) throws Exception {
		jo t=new jo();
		t.start();
		Thread main=Thread.currentThread();
		t.join(5000);

		for(int i=0;i<10;i++)
		{
			System.out.println("DaDa..........");
		}
	}
}