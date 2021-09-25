package App.Controllers;

import App.DTO.UserProfileDTO;
import App.DTO.UsersDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Validated
@SuppressWarnings("unused")
public interface UserApi {

    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get list of users", description = "page > 1; 100 > limit > 1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Well done", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "NONONONONO")})
    UsersDTO getUsers(@RequestParam(defaultValue = "1", required = false) @Min(1) int page,
                      @RequestParam(defaultValue = "10", required = false) @Min(1) @Max(100) int limit);

    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get profile of user", description = "GIMMEIDUSER", method = "GEEEEEEET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Well done"),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content(mediaType = "text/plain"))})
    UserProfileDTO getProfile(Long id);
}
