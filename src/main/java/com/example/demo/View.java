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

    private String name;
    private String country;
    private String indicator;
    private String startDate;
    private String endDate;


    public View() {
    }

    public View(String name, String country, String indicator, String start, String end) {
        this.name = name;
        this.country = country;
        this.indicator = indicator;
        this.startDate = start;
        this.endDate = end;
    }

    public View(Long id, String name, String country, String indicator, String start, String end) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.indicator = indicator;
        this.startDate = start;
        this.endDate = end;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getIndicator() {
        return indicator;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public void setStartDate(String start) {
        this.startDate = start;
    }

    public void setEndDate(String end) {
        this.endDate = end;
    }
}
