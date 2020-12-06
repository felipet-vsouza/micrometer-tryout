package felipetvsouza.github.micrometertryout.controller;

import felipetvsouza.github.micrometertryout.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<Void> handleGenericException(Exception exception) {
        log.error("There was an error in the application.", exception);
        return BaseResponse.build(null, "There was an error in the application.");
    }

}
