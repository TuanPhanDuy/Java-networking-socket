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
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientText {
	public static void main(String[] args) {
		PrintWriter out = null;
		Scanner in = null;
		try {
			Socket socket = new Socket("localhost", 9999);
			out = new PrintWriter(socket.getOutputStream(), true);//autoFlush
			in = new Scanner(socket.getInputStream());
			String msg = "Hello";
			out.println(msg);
			
			//Nhan
			if(in.hasNextLine()) {
				System.out.println("Received from server: " + in.nextLine());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			out.close();
			in.close();
		}
	}
}
