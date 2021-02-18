package by.hunar.kubik.controller;

import by.hunar.kubik.exception.NotFoundException;
import by.hunar.kubik.model.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice(assignableTypes = {UserController.class})
public class KubikErrorHandler {

    @ExceptionHandler
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(404);
        errorResponse.setMessage(ex.getMessage());

        return errorResponse;
    }
}
