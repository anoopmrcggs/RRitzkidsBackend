package com.rcg.com.controller;




import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rcg.com.dto.ErrorDetails;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;
import com.rcg.com.dto.Error;

@ControllerAdvice
@RestController
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler 
{

	@ExceptionHandler(RitzkidsException.class)
	public ResponseEntity<ResponseStatus<Error>> handleInvalidInputException(RitzkidsException ex,WebRequest request) 
	{
		ErrorDetails errorDetails = new ErrorDetails(ex.getEx_code(), ex.getMessage());
		Error error = new Error(errorDetails);
		return ResponseEntity.ok(new ResponseStatus<Error>(RitzConstants.ERROR_CODE, RitzConstants.NOT_FOUND, error.getError().getMessage()));
	}

	@SuppressWarnings("rawtypes")
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,HttpStatus status, WebRequest request) 
	{

		FieldError fieldError = ex.getBindingResult().getFieldError();
		String errorMessage = fieldError.getDefaultMessage();
		String annoTationType = ex.getBindingResult().getAllErrors().get(0).getCode();
		if (RitzConstants.VALIDATION_ERROR_TYPE.contains(annoTationType))
		{
			String fieldName = fieldError.getField();
			errorMessage = fieldName + " " + errorMessage;
		}
		return ResponseEntity.ok(new ResponseStatus<Error>(RitzConstants.WARN_CODE, RitzConstants.WARN, errorMessage));

	}

}
