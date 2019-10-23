package com.ia.tmi.iatmi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ia.tmi.iatmi.exception.SocioNoPoseePaseActivoException;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@ControllerAdvice
class SocioNoPoseePaseActivoAdvice {

  @SuppressWarnings("rawtypes")
  @ResponseBody
  @ExceptionHandler(SocioNoPoseePaseActivoException.class)
  @ResponseStatus(HttpStatus.PRECONDITION_REQUIRED)
	public WSReturn employeeNotFoundHandler(SocioNoPoseePaseActivoException ex) {
    return WSReturn.ERROR(ex.getMessage());
  }
}