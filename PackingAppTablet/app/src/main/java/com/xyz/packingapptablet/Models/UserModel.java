package com.xyz.packingapptablet.Models;

import java.io.Serializable;

/**
 * Created by THUAN on 09/02/2017.
 */

public class UserModel implements Serializable {
    private String name;
    private String contact;
    private String payment;
    private String reliability;
    private String distance;
    private CarModel car;

    public UserModel(String name, String contact, String payment, String reliability, CarModel car, String distance) {
        this.name = name;
        this.contact = contact;
        this.payment = payment;
        this.reliability = reliability;
        this.car = car;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getReliability() {
        return reliability;
    }

    public void setReliability(String reliability) {
        this.reliability = reliability;
    }

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
