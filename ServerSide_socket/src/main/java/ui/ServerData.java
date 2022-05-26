/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Oct 29, 2020
 *  @version: 1.0
 */

package ui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerData {
	public static void main(String[] args) {
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			ServerSocket serverSocket = new ServerSocket(7777);
			System.out.println("Ready...");
			Socket socket = serverSocket.accept();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			int d = in.readInt();
			int r = in.readInt();
			
			long dt = d * r;
			out.writeLong(dt);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
