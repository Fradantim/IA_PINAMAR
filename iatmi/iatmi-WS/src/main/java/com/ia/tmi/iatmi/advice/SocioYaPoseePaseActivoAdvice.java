package com.ia.tmi.iatmi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ia.tmi.iatmi.exception.SocioYaPoseePaseActivoException;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@ControllerAdvice
class SocioYaPoseePaseActivoAdvice {

  @SuppressWarnings("rawtypes")
  @ResponseBody
  @ExceptionHandler(SocioYaPoseePaseActivoException.class)
  @ResponseStatus(HttpStatus.PRECONDITION_REQUIRED)
	public WSReturn employeeNotFoundHandler(SocioYaPoseePaseActivoException ex) {
    return WSReturn.ERROR(ex.getMessage());
  }
}