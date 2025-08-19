package du20464813.foundation.bank.customer.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AccountServiceException.class)
    public  ResponseEntity<?>  handleAccountServiceException(AccountServiceException ex){
        Map<String,Object> response=new HashMap<>();
        response.put("timeStamp", LocalDate.now());
        response.put("status code",ex.getStatusCode());
        response.put("message", ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode()).body(response);
    }

}
