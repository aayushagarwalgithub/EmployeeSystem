package com.classes;

public class Regulation {

	private int regulationId;
	private String departmentName;
	private String regulationName;
	private String listOfComments;
	
	public Regulation() {
		super();
	}
	public int getRegulationId() {
		return regulationId;
	}
	public void setRegulationId(int regulationId) {
		this.regulationId = regulationId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getRegulationName() {
		return regulationName;
	}
	public void setRegulationName(String regulationName) {
		this.regulationName = regulationName;
	}
	public String getListOfComments() {
		return listOfComments;
	}
	public void setListOfComments(String ListOfComments) {
		this.listOfComments = ListOfComments;
	}
	@Override
	public String toString() {
		return "Regulation [regulationId=" + regulationId + ", departmentName=" + departmentName + ", regulationName="
				+ regulationName + ", ListOfComments=" + listOfComments + "]";
	}
	public Regulation(int regulationId, String departmentName, String regulationName,
			String ListOfComments) {
		super();
		this.regulationId = regulationId;
		this.departmentName = departmentName;
		this.regulationName = regulationName;
		this.listOfComments = ListOfComments;
	}
	
	

	
}
