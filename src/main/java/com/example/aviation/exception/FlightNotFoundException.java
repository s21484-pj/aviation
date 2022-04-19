package com.example.aviation.exception;

public class FlightNotFoundException extends Exception {

    public FlightNotFoundException() {
    }

    public FlightNotFoundException(String message) {
        super(message);
    }
}
