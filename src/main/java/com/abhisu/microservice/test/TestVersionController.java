package com.abhisu.microservice.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestVersionController {
    @GetMapping("/v1/person")
    public TestPersonV1 getFirstVersionOfPerson(){
        return new TestPersonV1("Abhishek Kumar Raushan");
    }
    @GetMapping("/v2/person")
    public TestPersonV2 getSecondVersionOfPerson(){
        return new TestPersonV2("Abhishek", "Raushan");
    }

    @GetMapping(value = "/person", params = "version=1")
    public TestPersonV1 getFirstParamVersionOfPerson(){
        return new TestPersonV1("Abhishek Kumar Raushan");
    }
    @GetMapping(value = "/person", params = "version=2")
    public TestPersonV2 getSecondParamVersionOfPerson(){
        return new TestPersonV2("Abhishek", "Raushan");
    }

    @GetMapping(value = "/person", headers = "X-API-VERSION=1")
    public TestPersonV1 getFirstHeaderVersionOfPerson(){
        return new TestPersonV1("Abhishek Kumar Raushan");
    }
    @GetMapping(value = "/person", headers = "X-API-VERSION=2")
    public TestPersonV2 getSecondHeaderVersionOfPerson(){
        return new TestPersonV2("Abhishek", "Raushan");
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public TestPersonV1 getFirstAcceptHeaderVersionOfPerson(){
        return new TestPersonV1("Abhishek Kumar Raushan");
    }
    @GetMapping(value = "/person/accept/", produces = "application/vnd.company.app-v2+json")
    public TestPersonV2 getSecondAcceptHeaderVersionOfPerson(){
        return new TestPersonV2("Abhishek", "Raushan");
    }


}
