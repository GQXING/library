package com.gqx.entity;

import java.sql.Date;

public class CLRClass {
	//rdName,bkName,IdContinueTimes
	private String rdName;
	private String bkName;
	private int IdContinueTimes;
	private int bkID;
	private int rdID;
	private int CanContinueTimes;
	private boolean IsHasReturn;
	private Date IdDateRetPlan;
	
	public Date getIdDateRetPlan() {
		return IdDateRetPlan;
	}
	public void setIdDateRetPlan(Date idDateRetPlan) {
		IdDateRetPlan = idDateRetPlan;
	}
	public boolean isIsHasReturn() {
		return IsHasReturn;
	}
	public void setIsHasReturn(boolean isHasReturn) {
		IsHasReturn = isHasReturn;
	}
	public int getCanContinueTimes() {
		return CanContinueTimes;
	}
	public void setCanContinueTimes(int canContinueTimes) {
		CanContinueTimes = canContinueTimes;
	}
	public int getBkID() {
		return bkID;
	}
	public void setBkID(int bkID) {
		this.bkID = bkID;
	}
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
	public String getBkName() {
		return bkName;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public int getIdContinueTimes() {
		return IdContinueTimes;
	}
	public void setIdContinueTimes(int idContinueTimes) {
		IdContinueTimes = idContinueTimes;
	}
	@Override
	public String toString() {
		return "CLRClass [rdName=" + rdName + ", bkName=" + bkName
				+ ", IdContinueTimes=" + IdContinueTimes + ", bkID=" + bkID
				+ ", rdID=" + rdID + ", CanContinueTimes=" + CanContinueTimes
				+ ", IsHasReturn=" + IsHasReturn + ", IdDateRetPlan="
				+ IdDateRetPlan + "]";
	}
	
	
	
	
}
