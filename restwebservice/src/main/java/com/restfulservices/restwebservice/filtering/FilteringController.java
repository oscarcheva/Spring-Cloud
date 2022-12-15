package com.restfulservices.restwebservice.filtering;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    static BeanPropertyFilter filter;
    static FilterProvider filters;
    static MappingJacksonValue mappingJacksonValue;

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {

        SomeBean somebean = new SomeBean("value1", "value2", "value3");

        setFilters(somebean, "field1");

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));

        setFilters(someBeanList, "field3", "field2");

        return mappingJacksonValue;
    }

    static void setFilters(Object object, String... filteredFields) {

        mappingJacksonValue = new MappingJacksonValue(object);
        filter = SimpleBeanPropertyFilter.filterOutAllExcept(filteredFields);
        filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
    }
}
