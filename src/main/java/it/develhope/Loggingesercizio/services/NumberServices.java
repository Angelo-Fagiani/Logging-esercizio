package it.develhope.Loggingesercizio.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class NumberServices {

    Logger logger = LoggerFactory.getLogger(NumberServices.class);

    @GetMapping
    public int pow(int a,int b) {
        try {
            logger.info("Start logger");
        } finally {
            int result = (int) Math.pow(a,b);
            logger.info("End logger");
            return result;
        }


    }
}
