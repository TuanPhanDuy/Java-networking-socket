/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Oct 29, 2020
 *  @version: 1.0
 */

package ui;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MainTest {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("ServerSide_socket")
				.createEntityManager();
	}
}
