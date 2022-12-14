package com.restfulservices.rest.User;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {

    private Integer id;

    @Size(min = 2, message = "Name must have at least two letters")
    private String name;
    @Past(message = "Date must be a past date")
    private LocalDate birthDate;
}
