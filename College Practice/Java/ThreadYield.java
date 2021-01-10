class Th implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("Child Thread :"+Thread.currentThread().getName());
			Thread.yield();
		}
	}
}
class ThreadYield
{
	public static void main(String[] args) throws Exception {
		System.out.println("MAin thread :"+Thread.currentThread().getName());
		Thread main=Thread.currentThread();
		Thread.currentThread().setName("Badshahh....");
		System.out.println("Changed Name :"+Thread.currentThread().getName());
		Th t= new Th();
		Thread th= new Thread(t,"Children");
		
		th.setPriority(5);
		th.start();
		th.join();System.out.println("Join called");
		for(int i=0;i<8;i++)
			System.out.println("MAin Thread Running........................"+Thread.currentThread().getName());

	}
}