package com.tuvarna.uspproject.controller;

import com.tuvarna.uspproject.exception.NotExistingClientException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public final class ExceptionHandlerController {

    private static final String DEFAULT_ERROR_PAGE = "error";

    @ExceptionHandler(value = NotExistingClientException.class)
    protected ModelAndView handleNotExistingClientException(ModelAndView modelAndView, NotExistingClientException ex) {
        modelAndView.addObject("errorMessage", ex.getMessage())
                .setViewName(DEFAULT_ERROR_PAGE);
        return modelAndView;
    }

}
