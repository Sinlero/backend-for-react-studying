package App.Controllers;

import App.DTO.UsersDTO;
import App.Entities.User;
import App.Exceptions.BigAskingException;
import App.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@Validated
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    private AtomicLong counter = new AtomicLong(0);

    @GetMapping("/users")
    @ResponseStatus(code = HttpStatus.OK)
    public UsersDTO getUsers(@RequestParam (defaultValue = "1", required = false) @Min(1) int page,
                             @RequestParam(defaultValue = "10", required = false) @Min(1) @Max(100) int limit) {
        log.info("Request page number: " + page + "; Request limit records: " + limit + "; Request number " + counter.incrementAndGet());
        return userService.getUsers(page, limit);
    }

    @PostMapping("/modelUserTest")
    public String modelUserTest() {
        throw new BigAskingException();
    }
}
