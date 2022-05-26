package com.webscience.json;

public class ws_a_cugb_dept {
	private	String id;
	private String deptName;
    private String rate;
    private String number;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "ws_a_cugb_dept [id=" + id + ", deptName=" + deptName
				+ ", rate=" + rate + ", number=" + number + "]";
	}
}
