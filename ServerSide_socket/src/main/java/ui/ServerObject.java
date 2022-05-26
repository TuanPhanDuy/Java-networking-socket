/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Oct 29, 2020
 *  @version: 1.0
 */

package ui;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.google.gson.Gson;

import entity.Sinhvien;

public class ServerObject {
	public static void main(String[] args) {
		Scanner in = null;
		EntityManager em = null;
		ObjectOutputStream out = null;
		try {
			em =  Persistence.createEntityManagerFactory("ServerSide_socket")
					.createEntityManager();
			ServerSocket serverSocket = new ServerSocket(6666);
			System.out.println("Ready...");
			Socket socket = serverSocket.accept();
			in = new Scanner(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
			String mssv = in.nextLine();
			Sinhvien sv = em.find(Sinhvien.class, mssv);
			String json = new Gson().toJson(sv);
			System.out.println(json);
//			System.out.println(sv);
			out.writeObject(sv);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			in.close();
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
