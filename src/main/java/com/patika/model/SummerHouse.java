package com.patika.model;


import com.patika.interfaces.IBuilding;

import java.math.BigDecimal;

public class SummerHouse extends House implements IBuilding {

    private BigDecimal price;
    private Float squareMeter;
    private int roomCount;
    private int hallCount;

    public SummerHouse(BigDecimal price, Float squareMeter, int roomCount, int hallCount) {
        super(price, squareMeter, roomCount, hallCount);
    }

    @Override
    public String toString() {
        return "SummerHouse{" +
                "price=" + getPrice() +
                ", squareMeter=" + getSquareMeter() +
                ", roomCount=" + getRoomCount() +
                ", hallCount=" + getHallCount() +
                '}';
    }
}
