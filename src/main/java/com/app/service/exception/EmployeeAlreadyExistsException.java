package com.app.service.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

  public EmployeeAlreadyExistsException(String message) {
    super(message);
  }

}
