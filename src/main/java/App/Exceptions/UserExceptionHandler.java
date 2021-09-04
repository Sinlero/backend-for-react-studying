package App.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@RestController
public class UserExceptionHandler {

    @ExceptionHandler(BigAskingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String bigAskingExceptionHandler(BigAskingException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundExceptionHandler(UserNotFoundException exception) {
        return exception.getMessage();
    }

}
