package com.ia.tmi.iatmi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CatalogoConfig {

	@Value("${iatmi.CUIL}")
	private String CUIL;
	
	@Value("${iatmi.CBU}")
	private String CBU;

	public CatalogoConfig() { }

	public String getCUIL() {
		return CUIL;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}
}
