/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Oct 29, 2020
 *  @version: 1.0
 */

package ui;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientByte {
	public static void main(String[] args) {
		
		FileInputStream in = null;
		BufferedOutputStream out = null;
		
		try {
			Socket socket = new Socket("localhost", 8888);
			in = new FileInputStream("data/myfile.pdf");
			out = new BufferedOutputStream(socket.getOutputStream());
			byte[] buff = new byte[1024];
			int n = in.read(buff);
			while(n != -1) {
				out.write(buff, 0, n);
				n = in.read(buff);
			}
			
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
