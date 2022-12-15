package com.restfulservices.restwebservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@JsonFilter("SomeBeanFilter")
//@JsonIgnoreProperties({"field1", "field3"})
public class SomeBean {

    private String field1;
    //@JsonIgnore
    private String field2;
    private String field3;
}
