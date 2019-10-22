package com.ia.tmi.iatmi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ia.tmi.iatmi.exception.TokenInvalidoException;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@ControllerAdvice
class TokenInvalidoAdvice {

  @SuppressWarnings("rawtypes")
  @ResponseBody
  @ExceptionHandler(TokenInvalidoException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
	public WSReturn employeeNotFoundHandler(TokenInvalidoException ex) {
    return WSReturn.ERROR(ex.getMessage());
  }
}