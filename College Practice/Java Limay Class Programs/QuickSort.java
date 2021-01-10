import mypkg.Util;

class QuickSort implements Runnable
{
	static int arr[];
	int l,r;
	static
	{
		arr=new int[10];
	}
	QuickSort()
	{
		l=0;
		r=9;
	}
	QuickSort(int a,int b)
	{
		l=a;r=b;
	}
	void input()
	{
		for(int i=0;i<10;i++)
			arr[i]=Util.iInput("Enter no:");
	}
	public String toString()
	{
		String s="Data:"+"\n";
		for(int i=0;i<10;i++)
			s=s+" "+arr[i];
		return s;
	}
	void display(String s)
	{
		Util.display(s+""+toString());
	}
	void pivot()
	{
		if(arr[l]>arr[r])
		{
			int tmp=arr[l];
			arr[l]=arr[r];
			arr[r]=tmp;
		}
	}
	synchronized int partition()
	{
		pivot();
		int i=l,j=r+1,k=arr[l];
		do
		{
			do {i++;}while(arr[i]<k);
			do {--j;}while(arr[j]>k);
			if(i<j)
			{
				int tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
			}
		}while(i<j);

		int tmp=arr[l];
			arr[l]=arr[j];
			arr[j]=tmp;

			return j;
	}

	synchronized void Quick()
	{
		int k=0;
		if(l<r)
		{
			k=partition();
			Thread a=new Thread(new QuickSort(l,k-1));
			a.start();
			try
			{
				a.join();
			}
			catch(Exception e1){}
			Thread b=new Thread(new QuickSort(k+1,r));
			b.start();
			try
			{
				b.join();
			}
			catch(Exception e1){}
		}
	}
	public void run()
	{
		Quick();
	}
	public static void main(String []args)
	{
		QuickSort p=new QuickSort();
		p.input();
		p.display("Before Sorting:\n");
		Thread th=new Thread(p);
		th.start();
		try
		{th.join();}
		catch(Exception e2){}
		p.display("After Sorting:\n");

	}
}