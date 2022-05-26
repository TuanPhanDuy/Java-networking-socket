/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Nov 4, 2020
 *  @version: 1.0
 */

package ui;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPDemo {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(32155);
		
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("data/received.mp4"));
		byte[] b = new byte[1024];
		DatagramPacket packet = new DatagramPacket(b, 0, b.length);
		socket.receive(packet);
		while(packet.getData().length > 0) {
			out.write(packet.getData(), 0, packet.getData().length);
			socket.receive(packet);
		}
		
		out.close();
	}
}
