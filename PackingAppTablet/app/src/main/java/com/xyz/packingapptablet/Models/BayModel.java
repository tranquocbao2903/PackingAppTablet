package com.xyz.packingapptablet.Models;

import java.io.Serializable;

/**
 * Created by bao on 2/16/17.
 */

public class BayModel implements Serializable{

    private boolean state;
    private int stateColor;
    private int bayNumber;

    public BayModel(boolean state, int stateColor, int bayNumber) {
        this.setState(state);
        this.stateColor = stateColor;
        this.bayNumber = bayNumber;
    }

    public void setBayNumber(int bayNumber) {
        this.bayNumber = bayNumber;
    }

    public boolean isState() {
        return state;
    }

    public int getStateColor() {
        return stateColor;
    }

    public void setStateColor(int stateColor) {
        this.stateColor = stateColor;
    }

    public int getBayNumber() {
        return bayNumber;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
