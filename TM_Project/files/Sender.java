import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {

	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();
			InetAddress ip = InetAddress.getByName("127.0.0.1"); // reciver IP
			String i = "1";
			DatagramPacket dp;
			while (true) {
				dp = new DatagramPacket(i.getBytes(), i.length(), ip, 5001);
				socket.send(dp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
