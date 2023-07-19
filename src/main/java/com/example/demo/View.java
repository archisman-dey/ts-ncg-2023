package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "view")
public class View {
    @Id
    @GeneratedValue
    private Long id;

    private String country;
    private String indicator;

    public View() {
    }

    public View(String country, String indicator) {
        this.country = country;
        this.indicator = indicator;
    }

    public View(Long id, String country, String indicator) {
        this.id = id;
        this.country = country;
        this.indicator = indicator;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }
}
