package com.gqx.entity;



import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

public class Reader {
	private int rdID;
	private String rdName;
	private String rdSex;
	private int rdType;
	//单位代码/单位名称
	private String rdDept;
	private String rdphone;
	private String rdEmail;
	private Date rdDateReg;
	private String rdPhoto;
	//证件状态，3个：有效、挂失、注销
	private String rdStatus;
	private int rdBorrowQty;
	private String rdPwd;
	private int rdAdminRoles;
	public int getRdID() {
		return rdID;
	}
	public void setRdID(int rdID) {
		this.rdID = rdID;
	}
	public String getRdName() {
		return rdName;
	}
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}
	public String getRdSex() {
		return rdSex;
	}
	public void setRdSex(String rdSex) {
		this.rdSex = rdSex;
	}
	public int getRdType() {
		return rdType;
	}
	public void setRdType(int rdType) {
		this.rdType = rdType;
	}
	public String getRdDept() {
		return rdDept;
	}
	public void setRdDept(String rdDept) {
		this.rdDept = rdDept;
	}
	public String getRdphone() {
		return rdphone;
	}
	public void setRdphone(String rdphone) {
		this.rdphone = rdphone;
	}
	public String getRdEmail() {
		return rdEmail;
	}
	public void setRdEmail(String rdEmail) {
		this.rdEmail = rdEmail;
	}
	public Date getRdDateReg() {
		
		return rdDateReg;
	}
	public void setRdDateReg(Date rdDateReg) {
		this.rdDateReg = rdDateReg;
	}
	
	public String getRdPhoto() {
		return rdPhoto;
	}
	public void setRdPhoto(String rdPhoto) {
		this.rdPhoto = rdPhoto;
	}
	public String getRdStatus() {
		return rdStatus;
	}
	public void setRdStatus(String rdStatus) {
		this.rdStatus = rdStatus;
	}
	public int getRdBorrowQty() {
		return rdBorrowQty;
	}
	public void setRdBorrowQty(int rdBorrowQty) {
		this.rdBorrowQty = rdBorrowQty;
	}
	public String getRdPwd() {
		return rdPwd;
	}
	public void setRdPwd(String rdPwd) {
		this.rdPwd = rdPwd;
	}
	public int getRdAdminRoles() {
		return rdAdminRoles;
	}
	public void setRdAdminRoles(int rdAdminRoles) {
		this.rdAdminRoles = rdAdminRoles;
	}
	@Override
	public String toString() {
		return "Reader [rdID=" + rdID + ", rdName=" + rdName + ", rdSex="
				+ rdSex + ", rdType=" + rdType + ", rdDept=" + rdDept
				+ ", rdphone=" + rdphone + ", rdEmail=" + rdEmail
				+ ", rdDateReg=" + rdDateReg + ", rdPhoto=" + rdPhoto
				+ ", rdStatus=" + rdStatus + ", rdBorrowQty=" + rdBorrowQty
				+ ", rdPwd=" + rdPwd + ", rdAdminRoles=" + rdAdminRoles + "]";
	}
	
}
