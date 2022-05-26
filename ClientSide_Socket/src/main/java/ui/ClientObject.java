/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Oct 29, 2020
 *  @version: 1.0
 */

package ui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import entity.Sinhvien;

public class ClientObject {
	public static void main(String[] args) {
		PrintWriter out = null;
		ObjectInputStream in = null;
		try {
			Socket socket = new Socket("localhost", 6666);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new ObjectInputStream(socket.getInputStream());
			String mssv  = "sv01";
			out.println(mssv);
			
			Sinhvien sv = (Sinhvien)in.readObject();
			System.out.println("Sinh vien: " + sv);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				out.close();
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
