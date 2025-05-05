package cl.bci.journey.common.exception;

import jakarta.annotation.Priority;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@ControllerAdvice
@Priority(HIGHEST_PRECEDENCE)
public class ErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<HashMap<String,String>> handlerDefaultHandler(HttpMessageNotWritableException httpMessageNotWritableException){
        logger.error(httpMessageNotWritableException.getMessage());
        HashMap<String,String> result = new HashMap<>();
        result.put("mensaje","Error data");
        return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String,String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        logger.error(methodArgumentNotValidException.getMessage());
        HashMap<String,String> result = new HashMap<>();
        result.put("mensaje",methodArgumentNotValidException
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(fieldError -> fieldError.getDefaultMessage())
                .orElse("Error Validation"));
        return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap<String,String>> handlerMethodArgumentNotValidException(Exception ex){
        logger.error(ex.getMessage());
        HashMap<String,String> result = new HashMap<>();
        result.put("mensaje","Error Server");
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap<String,String>> handlerMethodArgumentNotValidException(RuntimeException ex){
        logger.error(ex.getMessage());
        HashMap<String,String> result = new HashMap<>();
        result.put("mensaje","Error service BBDD");
        return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
    }
}
