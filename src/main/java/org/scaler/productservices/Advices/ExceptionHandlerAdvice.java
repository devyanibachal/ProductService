package org.scaler.productservices.Advices;


import org.scaler.productservices.DTO.RuntimeExceptionHandlerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RuntimeExceptionHandlerDTO> exceptionHandler(){
        RuntimeExceptionHandlerDTO runtimeExceptionHandlerDTO = new RuntimeExceptionHandlerDTO();
        runtimeExceptionHandlerDTO.setMessage("THere is an error ");
        return new ResponseEntity<RuntimeExceptionHandlerDTO>(runtimeExceptionHandlerDTO, HttpStatus.BAD_REQUEST);
    }
}
