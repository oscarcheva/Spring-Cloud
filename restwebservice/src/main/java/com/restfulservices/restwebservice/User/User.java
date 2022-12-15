package com.restfulservices.restwebservice.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {

    private Integer id;

    @JsonProperty("user_name")
    @Size(min = 2, message = "Name must have at least two letters")
    private String name;

    @Past(message = "Date must be a past date")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}
