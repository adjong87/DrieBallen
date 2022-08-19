package nl.drieballen.drieballen.controllers;

import com.apdj.dedrieballenapp.exceptions.AlreadyInUseException;
import com.apdj.dedrieballenapp.exceptions.BadRequestException;
import com.apdj.dedrieballenapp.exceptions.RecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> notFoundException(RecordNotFoundException exception) {
        log.error("Error: {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AlreadyInUseException.class)
    public ResponseEntity<Object> usedException(AlreadyInUseException exception) {
        log.error("Error: {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.IM_USED);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> notAllowedException(BadRequestException exception) {
        log.error("Error: {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
}
