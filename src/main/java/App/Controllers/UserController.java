package App.Controllers;

import App.DTO.UserProfileDTO;
import App.DTO.UsersDTO;
import App.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController implements UserApi{

    @Autowired
    private UserService userService;

    private AtomicLong counter = new AtomicLong(0);

    @GetMapping()
    public UsersDTO getUsers(int page, int limit) {
        log.info("Request page number: " + page + "; Request limit records: " + limit + "; Request number " + counter.incrementAndGet());
        return userService.getUsers(page, limit);
    }

    @GetMapping("/profile/{id}")
    public UserProfileDTO getProfile(@PathVariable Long id) {
        log.info("Request user with id " + id);
        return userService.getProfile(id);
    }

}
