package com.example.aviation.controller;

import com.example.aviation.dto.AirportInfoRequest;
import com.example.aviation.dto.AirportInfoResponse;
import com.example.aviation.dto.WeightRequest;
import com.example.aviation.dto.WeightResponse;
import com.example.aviation.exception.FlightNotFoundException;
import com.example.aviation.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/weight")
    public ResponseEntity<WeightResponse> getWeight(
            @RequestBody WeightRequest weightRequest) throws FlightNotFoundException {
        WeightResponse weightResponse = flightService.findFlightByNumberAndDate(
                weightRequest.getFlightNumber(),
                weightRequest.getDate());

        if (weightResponse != null) {
            return ResponseEntity.ok(weightResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/airport")
    public ResponseEntity<AirportInfoResponse> getInfoAboutAirport(
            @RequestBody AirportInfoRequest airportInfoRequest) throws FlightNotFoundException {
        AirportInfoResponse airportInfo = flightService.findFlightByIATACodeAndDate(
                airportInfoRequest.getAirportIATACode(),
                airportInfoRequest.getDate());

        if (airportInfo != null) {
            return ResponseEntity.ok(airportInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
