/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Oct 29, 2020
 *  @version: 1.0
 */

package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class  Sinhvien implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1393249280596526862L;
	@Id
	private String masv;
	private String hoten;
	
	public Sinhvien() {
		
	}

	/**
	 * @param masv
	 * @param hoten
	 */
	public Sinhvien(String masv, String hoten) {
		this.masv = masv;
		this.hoten = hoten;
	}

	/**
	 * @return the masv
	 */
	public String getMasv() {
		return masv;
	}

	/**
	 * @param masv the masv to set
	 */
	public void setMasv(String masv) {
		this.masv = masv;
	}

	/**
	 * @return the hoten
	 */
	public String getHoten() {
		return hoten;
	}

	/**
	 * @param hoten the hoten to set
	 */
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	@Override
	public String toString() {
		return "Sinhvien [masv=" + masv + ", hoten=" + hoten + "]";
	}
	
	
}
