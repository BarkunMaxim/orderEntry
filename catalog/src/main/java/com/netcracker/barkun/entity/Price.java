package com.netcracker.barkun.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "price")
public class Price extends BaseEntity {

    private double value;

    @OneToOne(mappedBy = "price", cascade = CascadeType.ALL)
    @JsonIgnore
    private Offer offer;

    public Price() {
    }

    public Price(double value) {
        this.value = value;
    }

    public Price(int value, Offer offer) {
        this.value = value;
        this.offer = offer;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Price price = (Price) obj;

        return Objects.equals(value, price.getValue()) &&
                Objects.equals(offer, price.getOffer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value, offer);
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ",Offer=" + offer + '}';
    }
}
