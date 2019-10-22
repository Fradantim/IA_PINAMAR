package com.ia.tmi.iatmi.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ia.tmi.iatmi.wsModel.WSReturn;

@ControllerAdvice
class NoSuchElementAdvice {

  @ResponseBody
  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public WSReturn employeeNotFoundHandler(NoSuchElementException ex) {
    return WSReturn.ERROR(ex.getMessage());
  }
}