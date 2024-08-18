package com.mylab.techLab.domain.order.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
}
