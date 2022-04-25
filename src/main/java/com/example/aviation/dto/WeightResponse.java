package com.example.aviation.dto;

public class WeightResponse {

    private double cargoWeightInKg;

    private double cargoWeightInLb;

    private double baggageWeightInKg;

    private double baggageWeightInLb;

    private double totalWeightInKg;

    private double totalWeightInLb;

    public WeightResponse() {
    }

    public WeightResponse(double cargoWeightInKg,
                          double cargoWeightInLb,
                          double baggageWeightInKg,
                          double baggageWeightInLb,
                          double totalWeightInKg,
                          double totalWeightInLb) {
        this.cargoWeightInKg = cargoWeightInKg;
        this.cargoWeightInLb = cargoWeightInLb;
        this.baggageWeightInKg = baggageWeightInKg;
        this.baggageWeightInLb = baggageWeightInLb;
        this.totalWeightInKg = totalWeightInKg;
        this.totalWeightInLb = totalWeightInLb;
    }

    public double calculateKgToLb(double kg) {
        return kg * 2.2046;
    }

    public double calculateLbToKg(double lb) {
        return lb / 2.2046;
    }

    public double getCargoWeightInKg() {
        return cargoWeightInKg;
    }

    public void setCargoWeightInKg(double cargoWeightInKg) {
        this.cargoWeightInKg = cargoWeightInKg;
    }

    public double getCargoWeightInLb() {
        return cargoWeightInLb;
    }

    public void setCargoWeightInLb(double cargoWeightInLb) {
        this.cargoWeightInLb = cargoWeightInLb;
    }

    public double getBaggageWeightInKg() {
        return baggageWeightInKg;
    }

    public void setBaggageWeightInKg(double baggageWeightInKg) {
        this.baggageWeightInKg = baggageWeightInKg;
    }

    public double getBaggageWeightInLb() {
        return baggageWeightInLb;
    }

    public void setBaggageWeightInLb(double baggageWeightInLb) {
        this.baggageWeightInLb = baggageWeightInLb;
    }

    public double getTotalWeightInKg() {
        return totalWeightInKg;
    }

    public void setTotalWeightInKg(double totalWeightInKg) {
        this.totalWeightInKg = totalWeightInKg;
    }

    public double getTotalWeightInLb() {
        return totalWeightInLb;
    }

    public void setTotalWeightInLb(double totalWeightInLb) {
        this.totalWeightInLb = totalWeightInLb;
    }
}
