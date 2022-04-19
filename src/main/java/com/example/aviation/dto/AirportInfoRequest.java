package com.example.aviation.dto;

import java.time.LocalDate;

public class AirportInfoRequest {

    private String airportIATACode;

    private LocalDate date;

    public AirportInfoRequest() {
    }

    public AirportInfoRequest(String airportIATACode,
                              LocalDate date) {
        this.airportIATACode = airportIATACode;
        this.date = date;
    }

    public String getAirportIATACode() {
        return airportIATACode;
    }

    public void setAirportIATACode(String airportIATACode) {
        this.airportIATACode = airportIATACode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
