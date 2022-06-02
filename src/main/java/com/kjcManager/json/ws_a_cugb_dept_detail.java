package com.kjcManager.json;

public class ws_a_cugb_dept_detail {
	private	String id;
	private String flagCode;
	private String flagName;
	private String deptCode;
	private String deptName;
	private String typeCode;
	private String typeName;
	private String checkId;
	private String info;
	private String year;
	private String curPage;
	private String perPage;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlagCode() {
		return flagCode;
	}
	public void setFlagCode(String flagCode) {
		this.flagCode = flagCode;
	}
	public String getFlagName() {
		return flagName;
	}
	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCurPage() {
		return curPage;
	}
	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}
	public String getPerPage() {
		return perPage;
	}
	public void setPerPage(String perPage) {
		this.perPage = perPage;
	}
	@Override
	public String toString() {
		return "ws_a_cugb_dept [id=" + id + ", flagCode=" + flagCode
				+ ", flagName=" + flagName + ", deptCode=" + deptCode
				+ ", deptName=" + deptName + ", typeCode=" + typeCode
				+ ", typeName=" + typeName + ", checkId=" + checkId + ", info="
				+ info + ", year=" + year + ", curPage=" + curPage
				+ ", perPage=" + perPage + "]";
	}
}
