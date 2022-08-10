package ru.malyshev.epicpartnerstest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = {RestController.class})
@RequiredArgsConstructor
public class CounterExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {Exception.class})
    public void handleException() {
        //
    }
}
