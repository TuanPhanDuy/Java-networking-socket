/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Oct 29, 2020
 *  @version: 1.0
 */

package ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerText {
	public static void main(String[] args) {
		Scanner in = null;
		PrintWriter out = null;
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			System.out.println("Ready...");
			Socket socket = serverSocket.accept();
			in = new Scanner(socket.getInputStream());
			out = new PrintWriter(socket.getOutputStream(), true);
			if(in.hasNextLine()) {
				String str = in.nextLine();
				System.out.println("Received from client: " + str);
				out.println("Hi");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			in.close();
			out.close();
		}
	}
}
