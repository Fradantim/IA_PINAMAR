package com.ia.tmi.iatmi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ia.tmi.iatmi.exception.RemoteEndpointException;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@ControllerAdvice
class RemoteEndpointAdvice {

  @SuppressWarnings("rawtypes")
  @ResponseBody
  @ExceptionHandler(RemoteEndpointException.class)
  @ResponseStatus(HttpStatus.BAD_GATEWAY)
	public WSReturn employeeNotFoundHandler(RemoteEndpointException ex) {
    return WSReturn.ERROR(ex.getMessage());
  }
}