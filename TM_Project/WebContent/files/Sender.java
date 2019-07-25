//package com.attackertracker.sender;

import java.net.*;
import java.io.*;

public class Sender {

	public static void main(String args[]) {
	try {
		
		Socket s = new Socket("localhost", 9009);

		OutputStream outToServer = s.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        
        out.writeUTF("Hello from " + s.getLocalSocketAddress());
        InputStream inFromServer = s.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);
        
        System.out.println("Server says " + in.readUTF());
        s.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
