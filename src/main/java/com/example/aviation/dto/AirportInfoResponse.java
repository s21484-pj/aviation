package com.example.aviation.dto;

public class AirportInfoResponse {

    private int departingFlights;

    private int arrivingFlights;

    private int arrivingPiecesOfBaggage;

    private int departingPiecesOfBaggage;

    public AirportInfoResponse() {
    }

    public AirportInfoResponse(int departingFlights,
                               int arrivingFlights,
                               int arrivingPiecesOfBaggage,
                               int departingPiecesOfBaggage) {
        this.departingFlights = departingFlights;
        this.arrivingFlights = arrivingFlights;
        this.arrivingPiecesOfBaggage = arrivingPiecesOfBaggage;
        this.departingPiecesOfBaggage = departingPiecesOfBaggage;
    }

    public int getDepartingFlights() {
        return departingFlights;
    }

    public void setDepartingFlights(int departingFlights) {
        this.departingFlights = departingFlights;
    }

    public int getArrivingFlights() {
        return arrivingFlights;
    }

    public void setArrivingFlights(int arrivingFlights) {
        this.arrivingFlights = arrivingFlights;
    }

    public int getArrivingPiecesOfBaggage() {
        return arrivingPiecesOfBaggage;
    }

    public void setArrivingPiecesOfBaggage(int arrivingPiecesOfBaggage) {
        this.arrivingPiecesOfBaggage = arrivingPiecesOfBaggage;
    }

    public int getDepartingPiecesOfBaggage() {
        return departingPiecesOfBaggage;
    }

    public void setDepartingPiecesOfBaggage(int departingPiecesOfBaggage) {
        this.departingPiecesOfBaggage = departingPiecesOfBaggage;
    }
}
