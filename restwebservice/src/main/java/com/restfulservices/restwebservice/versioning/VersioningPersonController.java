package com.restfulservices.restwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getfirstVersionOfPerson() {
        return new PersonV1("Juancito Teto");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Juancito", "Teto"));
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("Juancito Teto");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Name("Juancito", "Teto"));
    }

    @GetMapping(value = "/person", headers = "version=1")
    public PersonV1 getFirstVersionOfPersonHeader() {
        return new PersonV1("Juancito Teto");
    }

    @GetMapping(value = "/person", headers = "version=2")
    public PersonV2 getSecondVersionOfPersonHeader() {
        return new PersonV2(new Name("Juancito", "Teto"));
    }

    @GetMapping(value = "/person", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonContent() {
        return new PersonV1("Juancito Teto");
    }

    @GetMapping(value = "/person", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonContent() {
        return new PersonV2(new Name("Juancito", "Teto"));
    }
}
