//package com.attackertracker.reciver;

import java.io.*;
import java.net.*;

public class Receiver extends Thread{
	private ServerSocket serverSocket;
	   
	public Receiver() throws IOException {
	      serverSocket = new ServerSocket(9009);
	      serverSocket.setSoTimeout(100000);
	   }

	   public void run() {
	      while(true) {
	         try {
	            System.out.println("Waiting for client on port " + 
	               serverSocket.getLocalPort() + "...");
	            Socket server = serverSocket.accept();
	            System.out.println("------------------"+server.getRemoteSocketAddress());
	            System.out.println("Just connected to " + server.getRemoteSocketAddress());
	            DataInputStream in = new DataInputStream(server.getInputStream());
	            
	            System.out.println(in.readUTF());
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
	               + "\nGoodbye!");
	            server.close();
	            
	         } catch (Exception s) {
	            System.out.println("Socket timed out!");
	            break;
	         }
	      }
	   }
	   public static void main(String [] args) {
		      try {
		         Thread t = new Receiver();
		         t.start();
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
		}
}

