package za.co.sfh.features.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid header exception")
public class InvalidHeaderException extends RuntimeException {
     public InvalidHeaderException(String message) {
          super(message);
     }
}
