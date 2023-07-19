package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Year;

@Component
public class BootstrapInitialRepo implements CommandLineRunner {
    private final ViewRepository viewRepository;

    @Autowired
    public BootstrapInitialRepo(ViewRepository repo) {
        this.viewRepository = repo;
    }

    @Override
    public void run(String... args) {
        viewRepository.save(new View(
                "India's Urban Electricity Access",
                "India",
                "Electricity Urban",
                "1999",
                "2002"
        ));
        viewRepository.save(new View(
                "India's Urban Water Access",
                "India",
                "Urban Water",
                "1999",
                "2002"
        ));
    }
}
