package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

public class FicharPresentismoResponse {

	private Integer id;
	private String employee;
	private String[] input;
	private String[] output;
	private Boolean holiday;
	
	FicharPresentismoResponse() { }

	@Override
	public String toString() {
		return "FicharPresentismoResponse [id=" + id + ", employee=" + employee + ", input=" + input
				+ ", output=" + output + ", holiday=" + holiday + "]";
	}
	
	public FicharPresentismoResponse(Integer id, String employee, String[] input, String[] output, Boolean holiday) {
		this.id = id;
		this.employee = employee;
		this.input = input;
		this.output = output;
		this.holiday = holiday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String[] getInput() {
		return input;
	}

	public void setInput(String[] input) {
		this.input = input;
	}

	public String[] getOutput() {
		return output;
	}

	public void setOutput(String[] output) {
		this.output = output;
	}

	public Boolean getHoliday() {
		return holiday;
	}

	public void setHoliday(Boolean holiday) {
		this.holiday = holiday;
	}	
}
