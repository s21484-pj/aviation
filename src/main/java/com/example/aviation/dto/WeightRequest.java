package com.example.aviation.dto;

import java.time.LocalDate;

public class WeightRequest {

    private int flightNumber;

    private LocalDate date;

    public WeightRequest() {
    }

    public WeightRequest(int flightNumber,
                         LocalDate date) {
        this.flightNumber = flightNumber;
        this.date = date;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
