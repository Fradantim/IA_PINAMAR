package com.ia.tmi.iatmi.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ia.tmi.iatmi.wsModel.WSReturn;

public class NoPosseResultadoAdvice {

	@SuppressWarnings("rawtypes")
	@ResponseBody
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public WSReturn liquidacionNotFoundHandler(NoSuchElementException ex) {
		return WSReturn.ERROR(ex.getMessage());
	}
}
