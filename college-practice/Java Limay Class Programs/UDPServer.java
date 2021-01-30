import java.io.*;
import java.net.*;

class UDPServer
{
   public static void main(String[] args) throws Exception
   {
      DatagramSocket ss=new DatagramSocket(8090);
      byte[] x=new byte[100];
      byte[] y=new byte[100];
      String str="";
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      while(true)
      {
         DatagramPacket dp=new DatagramPacket(x,x.length);
         ss.receive(dp);
         str=new String(dp.getData());
         System.out.println("Received:"+str);

         InetAddress IPAddress=dp.getAddress();
         int port=dp.getPort();
         str=br.readLine();
         y=str.getBytes();

         DatagramPacket sp=new DatagramPacket(y,y.length,IPAddress,port);
         ss.send(sp);
      }
      
   }
}