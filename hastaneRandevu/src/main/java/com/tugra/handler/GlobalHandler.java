package com.tugra.handler;

import com.tugra.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ApiError<String>> globalHandler(BaseException exception , WebRequest request) {

        return ResponseEntity.badRequest().body(createApiError(exception.getMessage() , request));

    }

    private <T> ApiError<T> createApiError(T message , WebRequest request) {

        ApiError<T> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<T> exception = new Exception<>();
        exception.setPath(request.getDescription(false));
        exception.setLocalhost(getLocalHost());
        exception.setMessage(message);

        apiError.setException(exception);
        return apiError;
    }

    private String getLocalHost(){

        try {

            InetAddress localhost = InetAddress.getLocalHost();
            return localhost.getHostAddress();

        }catch (java.lang.Exception exception){
            return exception.getMessage();
        }

    }

}
