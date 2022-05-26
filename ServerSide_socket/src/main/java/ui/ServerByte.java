/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Oct 29, 2020
 *  @version: 1.0
 */

package ui;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerByte {
	public static void main(String[] args) {
		BufferedInputStream in = null;
		FileOutputStream out = null;
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("Ready...");
			Socket socket = serverSocket.accept();
			
			in = new BufferedInputStream(socket.getInputStream());
			out = new FileOutputStream("data/dfsd.pdf");
			byte[] b = new byte[1024];
			
			while(true) {
				int n = in.read(b);
				if(n < b.length) {
					out.write(b, 0, n);
					out.flush();
					break;
				}
				out.write(b, 0, n);
			}
			
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
