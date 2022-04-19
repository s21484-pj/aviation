package com.example.aviation.repository;

import com.example.aviation.entity.CargoEntity;
import com.example.aviation.entity.FlightEntity;
import com.example.aviation.model.Baggage;
import com.example.aviation.model.Cargo;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class FakeDB {

    private List<FlightEntity> flightEntities = addFlightEntities();
    private List<CargoEntity> cargos = addCargoEntities();

    public FakeDB() {
    }

    public List<FlightEntity> getFlights() {
        return flightEntities;
    }

    public void setFlights(List<FlightEntity> flightEntities) {
        this.flightEntities = flightEntities;
    }

    public List<CargoEntity> getCargos() {
        return cargos;
    }

    public void setCargos(List<CargoEntity> cargos) {
        this.cargos = cargos;
    }

    private List<FlightEntity> addFlightEntities() {
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 4, 1, 10, 27, 26);
        ZoneId zoneId1 = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDateTime1, zoneId1);
        FlightEntity flightEntity1 = new FlightEntity(0L, 9798, "SEA", "KRK", zonedDateTime1);

        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 12, 17, 2, 41, 33);
        ZoneId zoneId2 = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDateTime2, zoneId2);
        FlightEntity flightEntity2 = new FlightEntity(1L, 4941, "YYT", "MIT", zonedDateTime2);

        List<FlightEntity> flightEntityList = new ArrayList<>();
        flightEntityList.add(flightEntity1);
        flightEntityList.add(flightEntity2);
        return flightEntityList;
    }

    private List<CargoEntity> addCargoEntities() {
        Baggage baggage1 = new Baggage(0L, 768, "kg", 21);
        Baggage baggage2 = new Baggage(1L, 831, "lb", 439);
        Baggage baggage3 = new Baggage(2L, 724, "kg", 288);
        Baggage baggage4 = new Baggage(3L, 17, "kg", 308);
        List<Baggage> baggageList = new ArrayList<>();
        baggageList.add(baggage1);
        baggageList.add(baggage2);
        baggageList.add(baggage3);
        baggageList.add(baggage4);

        Cargo cargo1 = new Cargo(0L, 303, "kg", 436);
        Cargo cargo2 = new Cargo(1L, 23, "kg", 301);
        Cargo cargo3 = new Cargo(2L, 858, "kg", 435);
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargo1);
        cargoList.add(cargo2);
        cargoList.add(cargo3);

        CargoEntity cargoEntity = new CargoEntity(0L, baggageList, cargoList);
        List<CargoEntity> cargoEntityList = new ArrayList<>();
        cargoEntityList.add(cargoEntity);
        return cargoEntityList;
    }
}
