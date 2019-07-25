import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

class HReciver implements Runnable {
	DatagramSocket socket;
	DatagramPacket packet;
	public HReciver(){
		try{
		socket = new DatagramSocket(5001);
		packet = new DatagramPacket(new byte[1024], 1024);
		}catch(Exception e){e.printStackTrace();}
	}
	public void run(){
		System.out.println("Hacker Reciver Strarted");
		try{
			while(true) {
				socket.receive(packet);
				System.out.print(packet.getAddress());
				String str = new String(packet.getData(),0,packet.getLength());
				System.out.println(" : "+str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class HSender implements Runnable {

	DatagramPacket dp;
	DatagramSocket socket;
	InetAddress ip;

	public HSender() {
		try {
			socket = new DatagramSocket();
			ip = InetAddress.getByName("127.0.0.1"); // reciver IP
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		System.out.println("Hacker Sender Strarted");
		String i = "2";
		while (true) {
			try {
				dp = new DatagramPacket(i.getBytes(), i.length(), ip, 5001);
				socket.send(dp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Hacker {

	public static void main(String[] args) {
		HSender s = new HSender();
		Thread t1 = new Thread(s);
		//t1.start();
		
		HReciver r = new HReciver();
		Thread t2 = new Thread(r);
		t2.start();
	}
}
