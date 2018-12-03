package springmvcproject.springmvcprojectrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Asset with this serial number already exists")
public class DuplicateSerialNumberException extends RuntimeException{
}
