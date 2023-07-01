package red.softn.npedidos.configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import red.softn.npedidos.exception.DefaultHttpException;
import red.softn.npedidos.pojo.ErrorDetails;
import red.softn.npedidos.response.ErrorResponse;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(DefaultHttpException.class)
    public ResponseEntity<Object> handleException(DefaultHttpException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                             .body(new ErrorResponse(ex.getErrorDetails()));
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        return ResponseEntity.internalServerError()
                             .body(getErrorResponse(ex));
    }
    
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        return ResponseEntity.status(statusCode)
                             .body(getErrorResponse(ex));
    }
    
    private ErrorResponse getErrorResponse(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
        
        return new ErrorResponse(errorDetails);
    }
    
}
