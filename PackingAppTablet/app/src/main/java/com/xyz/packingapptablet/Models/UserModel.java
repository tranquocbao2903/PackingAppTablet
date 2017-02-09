package com.xyz.packingapptablet.Models;

/**
 * Created by THUAN on 09/02/2017.
 */

public class UserModel {
    private String name;
    private String contact;
    private String payment;

    public UserModel(String name, String contact, String payment) {
        this.name = name;
        this.contact = contact;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getPayment() {
        return payment;
    }
}
