package com.xyz.packingapptablet.Models;

import java.io.Serializable;

/**
 * Created by THUAN on 09/02/2017.
 */

public class CarModel implements Serializable {
    private String type;
    private String vehicle;
    private String status;
    private String bayNr;
    private String current;
    private String noShow;

    public CarModel(String type, String vehicle, String status, String bayNr, String current, String noShow) {
        this.type = type;
        this.vehicle = vehicle;
        this.status = status;
        this.bayNr = bayNr;
        this.current = current;
        this.noShow = noShow;
    }

    public String getType() {
        return type;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getStatus() {
        return status;
    }

    public String getBayNr() {
        return bayNr;
    }

    public String getCurrent() {
        return current;
    }

    public String getNoShow() {
        return noShow;
    }
}
