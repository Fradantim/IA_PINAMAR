package com.ia.tmi.iatmi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ia.tmi.iatmi.exception.UsuarioDebeLoguearseException;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@ControllerAdvice
class UsuarioDebeLoguearseAdvice {

  @SuppressWarnings("rawtypes")
  @ResponseBody
  @ExceptionHandler(UsuarioDebeLoguearseException.class)
  @ResponseStatus(HttpStatus.PRECONDITION_REQUIRED)
	public WSReturn employeeNotFoundHandler(UsuarioDebeLoguearseException ex) {
    return WSReturn.ERROR(ex.getMessage());
  }
}