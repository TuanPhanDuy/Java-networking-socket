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
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientData {
	public static void main(String[] args) {
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			Socket socket = new Socket("localhost", 7777);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			int dai = 20;
			int rong = 5;
			out.writeInt(dai);
			out.writeInt(rong);
			
			//Nhan ket qua
			long dt = in.readLong();
			System.out.println("Dien tich: " + dt);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
