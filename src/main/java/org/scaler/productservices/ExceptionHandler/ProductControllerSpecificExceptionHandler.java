package org.scaler.productservices.ExceptionHandler;

public class ProductControllerSpecificExceptionHandler extends Exception{
    public ProductControllerSpecificExceptionHandler(String message){
        super(message);
    }
}
