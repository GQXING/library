package com.gqx.entity;

import java.sql.Date;



public class Borrow {
	private int BorrowID;
	private int rdID;
	private int bkID;
	private int IdContinueTimes;
	//��������
	private Date IdDateOut;
	//Ӧ������
	private Date IdDateRetPlan;
	//ʵ�ʻ�������
	private Date IdDateRetAct;
	//��������
	private int IdOverDay;
	//���ڽ�Ӧ�����
	private int IdOverMoney;
	//������
	private int IdPunishMoney;
	//�Ƿ��Ѿ����飬ȱʡΪ0-δ��
	private int IsHasReturn;
	//�������Ա
	private String OperatorLend;
	//�������Ա
	private String OperatorRet;
	public int getBorrowID() {
		return BorrowID;
	}
	public void setBorrowID(int borrowID) {
		BorrowID = borrowID;
	}
	public int getRdID() {
		return rdID;
	}
	public void setRdID(int rdID) {
		this.rdID = rdID;
	}
	public int getBkID() {
		return bkID;
	}
	public void setBkID(int bkID) {
		this.bkID = bkID;
	}
	public int getIdContinueTimes() {
		return IdContinueTimes;
	}
	public void setIdContinueTimes(int idContinueTimes) {
		IdContinueTimes = idContinueTimes;
	}
	public Date getIdDateOut() {
		return IdDateOut;
	}
	public void setIdDateOut(Date idDateOut) {
		IdDateOut = idDateOut;
	}
	public Date getIdDateRetPlan() {
		return IdDateRetPlan;
	}
	public void setIdDateRetPlan(Date idDateRetPlan) {
		IdDateRetPlan = idDateRetPlan;
	}
	public Date getIdDateRetAct() {
		return IdDateRetAct;
	}
	public void setIdDateRetAct(Date idDateRetAct) {
		IdDateRetAct = idDateRetAct;
	}
	public int getIdOverDay() {
		return IdOverDay;
	}
	public void setIdOverDay(int idOverDay) {
		IdOverDay = idOverDay;
	}
	public int getIdOverMoney() {
		return IdOverMoney;
	}
	public void setIdOverMoney(int idOverMoney) {
		IdOverMoney = idOverMoney;
	}
	public int getIdPunishMoney() {
		return IdPunishMoney;
	}
	public void setIdPunishMoney(int idPunishMoney) {
		IdPunishMoney = idPunishMoney;
	}
	public int getIsHasReturn() {
		return IsHasReturn;
	}
	public void setIsHasReturn(int isHasReturn) {
		IsHasReturn = isHasReturn;
	}
	public String getOperatorLend() {
		return OperatorLend;
	}
	public void setOperatorLend(String operatorLend) {
		OperatorLend = operatorLend;
	}
	public String getOperatorRet() {
		return OperatorRet;
	}
	public void setOperatorRet(String operatorRet) {
		OperatorRet = operatorRet;
	}
	@Override
	public String toString() {
		return "Borrow [BorrowID=" + BorrowID + ", rdID=" + rdID + ", bkID="
				+ bkID + ", IdContinueTimes=" + IdContinueTimes
				+ ", IdDateOut=" + IdDateOut + ", IdDateRetPlan="
				+ IdDateRetPlan + ", IdDateRetAct=" + IdDateRetAct
				+ ", IdOverDay=" + IdOverDay + ", IdOverMoney=" + IdOverMoney
				+ ", IdPunishMoney=" + IdPunishMoney + ", IsHasReturn="
				+ IsHasReturn + ", OperatorLend=" + OperatorLend
				+ ", OperatorRet=" + OperatorRet + "]";
	}
	
	
}
