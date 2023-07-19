package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapInitialRepo implements CommandLineRunner {
    private final ViewRepository viewRepository;

    @Autowired
    public BootstrapInitialRepo(ViewRepository repo) {
        this.viewRepository = repo;
    }

    @Override
    public void run(String... args) {
        viewRepository.save(new View("Example Country", "Example Indicator"));
    }
}
