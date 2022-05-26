/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Nov 4, 2020
 *  @version: 1.0
 */

package ui;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDemoClient {
	public static void main(String[] args) throws IOException {
		
		DatagramSocket datagramSocket = new DatagramSocket();
		
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream("data/myfile.mp4"));
		
		byte[] b = new byte[1024];
		int n = in.read(b);
		
		while(n != -1) {
			DatagramPacket packet = new DatagramPacket(b, 0, n, InetAddress.getByName("localhost"), 32155);
			datagramSocket.send(packet);
			n = in.read(b);
		}
		
		in.close();
	}
}
