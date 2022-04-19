package com.example.aviation.entity;

import com.example.aviation.model.Baggage;
import com.example.aviation.model.Cargo;

import java.util.List;

public class CargoEntity {

    private Long flightId;

    private List<Baggage> baggage;

    private List<Cargo> cargos;

    public CargoEntity() {
    }

    public CargoEntity(Long flightId,
                       List<Baggage> baggage,
                       List<Cargo> cargos) {
        this.flightId = flightId;
        this.baggage = baggage;
        this.cargos = cargos;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public List<Baggage> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<Baggage> baggage) {
        this.baggage = baggage;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
}
