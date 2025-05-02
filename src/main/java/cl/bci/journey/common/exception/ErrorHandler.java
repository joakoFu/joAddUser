package cl.bci.journey.common.exception;

import jakarta.annotation.Priority;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@ControllerAdvice
@Priority(HIGHEST_PRECEDENCE)
public class ErrorHandler {
    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<String> handlerDefaultHandler(HttpMessageNotWritableException httpMessageNotWritableException){
        return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlerMethodArgumentNotValidException(Exception ex){
        return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
    }
}
