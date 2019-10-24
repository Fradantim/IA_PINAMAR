package com.ia.tmi.iatmi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ia.tmi.iatmi.exception.NoPoseeResultadoException;
import com.ia.tmi.iatmi.wsModel.WSReturn;

public class NoPosseResultadoAdvice {

	@SuppressWarnings("rawtypes")
	@ResponseBody
	@ExceptionHandler(NoPoseeResultadoException.class)
	@ResponseStatus(HttpStatus.OK)
	public WSReturn liquidacionNotFoundHandler(NoPoseeResultadoException ex) {
		return WSReturn.OK_FALSE(ex.getMessage());
	}
}
