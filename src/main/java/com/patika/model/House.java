package com.patika.model;


import com.patika.interfaces.IBuilding;

import java.math.BigDecimal;

public class House implements IBuilding {

    private BigDecimal price;
    private Float squareMeter;
    private int roomCount;
    private int hallCount;

    public House(BigDecimal price, Float squareMeter, int roomCount, int hallCount) {
        this.price = price;
        this.squareMeter = squareMeter;
        this.roomCount = roomCount;
        this.hallCount = hallCount;
    }

    @Override
    public String toString() {
        return "House{" +
                "price=" + price +
                ", squareMeter=" + squareMeter +
                ", roomCount=" + roomCount +
                ", hallCount=" + hallCount +
                '}';
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public Float getSquareMeter() {
        return squareMeter;
    }

    @Override
    public void setSquareMeter(Float squareMeter) {
        this.squareMeter = squareMeter;
    }

    @Override
    public int getRoomCount() {
        return roomCount;
    }

    @Override
    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    @Override
    public int getHallCount() {
        return hallCount;
    }

    @Override
    public void setHallCount(int hallCount) {
        this.hallCount = hallCount;
    }
}
