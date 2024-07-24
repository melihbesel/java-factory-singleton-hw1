package com.patika.interfaces;

import java.math.BigDecimal;

public interface IBuilding {

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Float getSquareMeter();

    void setSquareMeter(Float squareMeter);

    int getRoomCount();

    void setRoomCount(int roomCount);

    int getHallCount();

    void setHallCount(int hallCount);

}
