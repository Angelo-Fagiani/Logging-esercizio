package it.develhope.Loggingesercizio.controller;


import it.develhope.Loggingesercizio.services.NumberServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    private Environment environment;

    @Autowired
    private NumberServices numberServices;

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public String getWelcomeMsg(){
        logger.info("Start log");
        return "Welcome!";
    }

    @GetMapping("/exp")
    public int getPow(){
        int var1 = Integer.parseInt(environment.getProperty("myCustomProper.N1"));
        int var2 = Integer.parseInt(environment.getProperty("myCustomProper.N2"));
        return numberServices.pow(var1,var2);
    }

    @GetMapping("/get-errors")
    public void getError(){
        Error error = new Error("This is the error");
        logger.error(error.getMessage());
    }


}
