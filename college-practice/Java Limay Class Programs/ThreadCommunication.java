class TShared
{
    int data,flg;
    TShared()
    {
        data=flg=0;
    }
    synchronized void producer()
    {
        if(flg==0)
        {
            flg=1;
            try
            {
                wait();
            }
            catch(Exception e2){}
        }    
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception ew){}
        data=(int)(Math.random()*100);
        notify();
    }
    synchronized void consumer()
    {
        if(flg==1)
        {
            notify();
        }
        else
            flg=1;
        try
        {
            wait();
        }
        catch(Exception e){}
        String s="TABLE::\n";
        for(int i=0;i<10;i++)
            s=s+"\n"+data*i;
        System.out.println(s);
    }
}

class ConThread extends Thread
{
    TShared obj;
    ConThread(TShared s)
    {
        super();
        obj=s;
        start();
    } 
    public void run()
    {
        obj.consumer();
    }
}

class ProThread extends Thread
{
    TShared obj;
    ProThread (TShared s)
    {
        super();
        obj=s;
        start();

    }
    public  void run()
    {
        obj.producer();
    }
}
class ThreadCommunication
{
    public static void main(String []args)
    {
        TShared obj=new TShared();
        ConThread c=new ConThread(obj);
        ProThread p=new ProThread(obj);
        try
        {
            c.join();
            p.join();
        }
        catch(Exception e){}

        System.out.println("Main Ends");
    }
}