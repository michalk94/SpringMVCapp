package springmvcproject.springmvcprojectrest.user;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No user with this id")
public class UserNotFoundException extends RuntimeException {
}
