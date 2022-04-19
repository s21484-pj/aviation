package com.example.aviation.service;

import com.example.aviation.dto.AirportInfoResponse;
import com.example.aviation.dto.WeightResponse;
import com.example.aviation.entity.CargoEntity;
import com.example.aviation.entity.FlightEntity;
import com.example.aviation.exception.FlightNotFoundException;
import com.example.aviation.model.Baggage;
import com.example.aviation.model.Cargo;
import com.example.aviation.repository.FakeDB;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FakeDB fakeDB;

    public FlightService() {
        this.fakeDB = new FakeDB();
    }

    public WeightResponse findFlightByNumberAndDate(int flightNumber,
                                                    LocalDate localDate) throws FlightNotFoundException {
        Optional<FlightEntity> flight = fakeDB.getFlights().stream()
                .filter(f -> f.getFlightNumber() == flightNumber)
                .filter(flightEntity -> {
                    LocalDate date = flightEntity.getDepartureDate().toLocalDate();
                    return date.equals(localDate);
                })
                .findFirst();

        Optional<CargoEntity> cargoEntity = Optional.empty();

        if (flight.isPresent()) {
            long flightId = flight.get().getFlightId();

            cargoEntity = fakeDB.getCargos().stream()
                    .filter(c -> c.getFlightId().equals(flightId))
                    .findFirst();
        }

        if (cargoEntity.isPresent()) {
            return calculateWeight(cargoEntity.get());
        } else {
            throw new FlightNotFoundException("Flight not found.");
        }
    }

    public AirportInfoResponse findFlightByIATACodeAndDate(String IATACode,
                                                           LocalDate localDate) throws FlightNotFoundException {
        List<FlightEntity> departingFlights = fakeDB.getFlights().stream()
                .filter(f -> f.getDepartureAirportIATACode().equals(IATACode))
                .filter(flightEntity -> {
                    LocalDate date = flightEntity.getDepartureDate().toLocalDate();
                    return date.equals(localDate);
                })
                .collect(Collectors.toList());

        List<Long> departingFlightsIds = departingFlights.stream()
                .mapToLong(FlightEntity::getFlightId)
                .boxed()
                .collect(Collectors.toList());

        List<CargoEntity> departingCargos = fakeDB.getCargos().stream()
                .filter(c -> departingFlightsIds.contains(c.getFlightId()))
                .collect(Collectors.toList());

        List<FlightEntity> arrivingFlights = fakeDB.getFlights().stream()
                .filter(f -> f.getArrivalAirportIATACode().equals(IATACode))
                .filter(flightEntity -> {
                    LocalDate date = flightEntity.getDepartureDate().toLocalDate();
                    return date.equals(localDate);
                })
                .collect(Collectors.toList());

        List<Long> arrivingFlightsIds = arrivingFlights.stream()
                .mapToLong(FlightEntity::getFlightId)
                .boxed()
                .collect(Collectors.toList());

        List<CargoEntity> arrivingCargos = fakeDB.getCargos().stream()
                .filter(c -> arrivingFlightsIds.contains(c.getFlightId()))
                .collect(Collectors.toList());

        int numberOfDepartingFlights = departingFlights.size();
        int numberOfArrivingFlights = arrivingFlights.size();

        if (numberOfDepartingFlights > 0 || numberOfArrivingFlights > 0) {
            return getInfoAboutAirport(numberOfDepartingFlights, numberOfArrivingFlights, departingCargos, arrivingCargos);
        } else {
            throw new FlightNotFoundException("No flights arriving / departing from this airport.");
        }
    }

    private AirportInfoResponse getInfoAboutAirport(int numberOfDepartingFlights,
                                                    int numberOfArrivingFlights,
                                                    List<CargoEntity> departingCargos,
                                                    List<CargoEntity> arrivingCargos) {
        int piecesOfBaggageDeparting = departingCargos.stream()
                .map(CargoEntity::getBaggage)
                .flatMap(Collection::stream)
                .mapToInt(Baggage::getPieces)
                .sum();

        int piecesOfBaggageArriving = arrivingCargos.stream()
                .map(CargoEntity::getBaggage)
                .flatMap(Collection::stream)
                .mapToInt(Baggage::getPieces)
                .sum();

        AirportInfoResponse airportInfo = new AirportInfoResponse();
        airportInfo.setDepartingFlights(numberOfDepartingFlights);
        airportInfo.setArrivingFlights(numberOfArrivingFlights);
        airportInfo.setArrivingPiecesOfBaggage(piecesOfBaggageArriving);
        airportInfo.setDepartingPiecesOfBaggage(piecesOfBaggageDeparting);
        return airportInfo;
    }

    private WeightResponse calculateWeight(CargoEntity cargoEntity) {
        int cargoWeight = cargoEntity.getCargos().stream()
                .mapToInt(Cargo::getWeight)
                .sum();

        int baggageWeight = cargoEntity.getBaggage().stream()
                .mapToInt(Baggage::getWeight)
                .sum();

        int totalWeight = cargoWeight + baggageWeight;

        WeightResponse weightResponse = new WeightResponse();
        weightResponse.setCargoWeight(cargoWeight);
        weightResponse.setBaggageWeight(baggageWeight);
        weightResponse.setTotalWeight(totalWeight);
        return weightResponse;
    }
}
