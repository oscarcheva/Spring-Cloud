package com.restfulservices.rest.Error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ErrorDetails {

    private LocalDate timeStamp;
    private String message;
    private String details;

}
