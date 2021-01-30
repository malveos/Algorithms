
import java.io.*;
import java.net.*;

class UDPClient
{
   public static void main(String[] args) throws Exception
   {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));     
      DatagramSocket ss=new DatagramSocket();
      InetAddress IPAddress =InetAddress.getByName("localhost");

      byte[] x=new byte[100];
      byte[] y=new byte[100];
      String str=br.readLine();
      
      DatagramPacket sp=new DatagramPacket(x,x.length,IPAddress,8090);
      ss.send(sp);
      DatagramPacket rp=new DatagramPacket(y,y.length);
      ss.receive(rp);
      str=new String(rp.getData());
      System.out.println("From Server:"+str);

      ss.close();
   }
}