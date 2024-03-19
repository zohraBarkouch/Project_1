package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args)
    {
        logger.info("Starting application...");
        SpringApplication.run(App.class, args);

        // Example usage of Calculator class
        Calculator calculator = new Calculator();
        logger.info("Addition: " + calculator.add(5, 3));
        logger.info("Subtraction: " + calculator.subtract(5, 3));
        logger.info("Multiplication: " + calculator.multiply(5, 3));
        logger.info("Division: " + calculator.divide(5, 3));
    }

    @PostConstruct
    public void init() {
        Logger log = LoggerFactory.getLogger(App.class);
        log.info("Java app started");
    }
     public String getStatus() {
       return "OK";
    }
}
