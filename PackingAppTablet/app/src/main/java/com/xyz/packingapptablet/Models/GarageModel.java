package com.xyz.packingapptablet.Models;

import java.util.ArrayList;

/**
 * Created by THUAN on 09/02/2017.
 */

public class GarageModel {
    private ArrayList<Integer> parkHubBays;
    private Integer baysAvailable;

    public ArrayList<Integer> getParkHubBays() {
        return parkHubBays;
    }

    public Integer getBaysAvailable() {
        return baysAvailable;
    }

    public GarageModel(ArrayList<Integer> parkHubBays, Integer baysAvailable) {
        this.parkHubBays = parkHubBays;
        this.baysAvailable = parkHubBays.size();
    }
}
