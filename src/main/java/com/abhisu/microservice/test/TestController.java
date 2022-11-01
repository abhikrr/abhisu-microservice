package com.abhisu.microservice.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Locale;

@RestController
@Slf4j
public class TestController {
    private final Test test;
    private MessageSource messageSource;

    public TestController(MessageSource messageSource) {
        this.messageSource = messageSource;
        this.test = new Test(1, "Xml Data", 30, 1000.00, new Timestamp(LocalDate.now().toEpochDay()));
    }

    @GetMapping("/test/string")
    public String getString() {
        return "Hello World";
    }

    @GetMapping(value = "/testXml", produces = MediaType.APPLICATION_XML_VALUE)
    public Test getXmlTest() {
        return this.test;
    }

    @GetMapping(value = "/testJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Test getJsonTest() {
        return this.test;
    }

    @GetMapping("/pathvariable/{name}")
    public String usePathVariable(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping("/requestparam")
    public String userequestParm(@RequestParam String name){
        return "Hello " + name;
    }

    @GetMapping("/internationalizedMessage")
    public String getInternationalizedMessage(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
