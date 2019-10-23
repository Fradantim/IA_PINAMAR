package com.ia.tmi.iatmi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ia.tmi.iatmi.wsModel.WSReturn;

@ControllerAdvice
class IllegalArgumentAdvice {

  @SuppressWarnings("rawtypes")
  @ResponseBody
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public WSReturn employeeNotFoundHandler(IllegalArgumentException ex) {
    return WSReturn.ERROR(ex.getMessage());
  }
}