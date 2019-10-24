package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

public class GerHsPresentismoResponse {

	private Integer absences;
	private Integer totalHours;
	
	public GerHsPresentismoResponse() { }
	
	public GerHsPresentismoResponse(Integer absences, Integer totalHours) {
		this.absences = absences;
		this.totalHours = totalHours;
	}
	
	@Override
	public String toString() {
		return "GerHsPresentismoResponse [absences=" + absences + ", totalHours=" + totalHours + "]";
	} 	

	public Integer getAbsences() {
		return absences;
	}

	public void setAbsences(Integer absences) {
		this.absences = absences;
	}

	public Integer getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}	
}
