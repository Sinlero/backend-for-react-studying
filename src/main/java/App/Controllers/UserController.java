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
@Validated
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    private AtomicLong counter = new AtomicLong(0);

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get list of users", description = "page > 1; 100 > limit > 1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Well done", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "NONONONONO")})
    public UsersDTO getUsers(@RequestParam (defaultValue = "1", required = false) @Min(1) int page,
                             @RequestParam(defaultValue = "10", required = false) @Min(1) @Max(100) int limit) {
        log.info("Request page number: " + page + "; Request limit records: " + limit + "; Request number " + counter.incrementAndGet());
        return userService.getUsers(page, limit);
    }

    @GetMapping("/profile/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get profile of user", description = "GIMMEIDUSER", method = "GEEEEEEET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Well done"),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content(mediaType = "text/plain"))})
    public UserProfileDTO getProfile(@PathVariable Long id) {
        log.info("Request user with id " + id);
        return userService.getProfile(id);
    }

}
