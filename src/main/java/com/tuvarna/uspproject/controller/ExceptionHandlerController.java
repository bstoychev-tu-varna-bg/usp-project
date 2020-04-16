package com.tuvarna.uspproject.controller;

import com.tuvarna.uspproject.exception.NotExistingCarException;
import com.tuvarna.uspproject.exception.NotExistingClientException;
import com.tuvarna.uspproject.exception.NotExistingEmployeeException;
import com.tuvarna.uspproject.exception.NotExistingSaleException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public final class ExceptionHandlerController {

    private static final String DEFAULT_ERROR_PAGE = "error";

    @ExceptionHandler(value = NotExistingEmployeeException.class)
    protected ModelAndView handleNotExistingEmployeeException(ModelAndView modelAndView, NotExistingEmployeeException ex) {
        modelAndView.addObject("errorMessage", ex.getMessage())
                .setViewName(DEFAULT_ERROR_PAGE);
        return modelAndView;
    }

    @ExceptionHandler(value = NotExistingCarException.class)
    protected ModelAndView handleNotExistingCarException(ModelAndView modelAndView, NotExistingCarException ex) {
        modelAndView.addObject("errorMessage", ex.getMessage())
                .setViewName(DEFAULT_ERROR_PAGE);
        return modelAndView;
    }

    @ExceptionHandler(value = NotExistingClientException.class)
    protected ModelAndView handleNotExistingClientException(ModelAndView modelAndView, NotExistingClientException ex) {
        modelAndView.addObject("errorMessage", ex.getMessage())
                .setViewName(DEFAULT_ERROR_PAGE);
        return modelAndView;
    }

    @ExceptionHandler(value = NotExistingSaleException.class)
    protected ModelAndView handleNotExistingSaleException(ModelAndView modelAndView, NotExistingSaleException ex) {
        modelAndView.addObject("errorMessage", ex.getMessage())
                .setViewName(DEFAULT_ERROR_PAGE);
        return modelAndView;
    }
}
