package com.example.aviation.entity;

import java.time.ZonedDateTime;

public class FlightEntity {

    private Long flightId;

    private int flightNumber;

    private String departureAirportIATACode;

    private String arrivalAirportIATACode;

    private ZonedDateTime departureDate;

    public FlightEntity() {
    }

    public FlightEntity(Long id,
                        int number,
                        String departureAirportIATACode,
                        String arrivalAirportIATACode,
                        ZonedDateTime departureDate) {
        this.flightId = id;
        this.flightNumber = number;
        this.departureAirportIATACode = departureAirportIATACode;
        this.arrivalAirportIATACode = arrivalAirportIATACode;
        this.departureDate = departureDate;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public void setDepartureAirportIATACode(String departureAirportIATACode) {
        this.departureAirportIATACode = departureAirportIATACode;
    }

    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
        this.arrivalAirportIATACode = arrivalAirportIATACode;
    }

    public ZonedDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(ZonedDateTime departureDate) {
        this.departureDate = departureDate;
    }
}
