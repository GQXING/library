package com.gqx.entity;

public class ReaderType {
	private int rdType;
	private String rdTypeName;
	private int canLendDay;
	private int canLendQty;
	private int canContinueTimes;
	private float punishRate;
	private int dateValid;
	public int getRdType() {
		return rdType;
	}
	public void setRdType(int rdType) {
		this.rdType = rdType;
	}
	public String getRdTypeName() {
		return rdTypeName;
	}
	public void setRdTypeName(String rdTypeName) {
		this.rdTypeName = rdTypeName;
	}
	public int getCanLendDay() {
		return canLendDay;
	}
	public void setCanLendDay(int canLendDay) {
		this.canLendDay = canLendDay;
	}
	public int getCanLendQty() {
		return canLendQty;
	}
	public void setCanLendQty(int canLendQty) {
		this.canLendQty = canLendQty;
	}
	public int getCanContinueTimes() {
		return canContinueTimes;
	}
	public void setCanContinueTimes(int canContinueTimes) {
		this.canContinueTimes = canContinueTimes;
	}
	public float getPunishRate() {
		return punishRate;
	}
	public void setPunishRate(float punishRate) {
		this.punishRate = punishRate;
	}
	public int getDateValid() {
		return dateValid;
	}
	public void setDateValid(int dateValid) {
		this.dateValid = dateValid;
	}
	@Override
	public String toString() {
		return "ReaderType [rdType=" + rdType + ", rdTypeName=" + rdTypeName
				+ ", canLendDay=" + canLendDay + ", canLendQty=" + canLendQty
				+ ", canContinueTimes=" + canContinueTimes + ", punishRate="
				+ punishRate + ", dateValid=" + dateValid + "]";
	}
	

}
