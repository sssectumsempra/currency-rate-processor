package ex.rate.app.controller.resolver;

import ex.rate.app.exception.CurrencyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler
    public ResponseEntity<?> handle(Exception e, WebRequest request) {
        if (e instanceof CurrencyNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Internal server error");
    }
}
