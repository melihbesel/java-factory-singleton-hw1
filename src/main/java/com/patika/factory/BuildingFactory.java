package com.patika.factory;

import com.patika.interfaces.IBuilding;
import com.patika.interfaces.enums.BuildingType;
import com.patika.model.House;
import com.patika.model.SummerHouse;
import com.patika.model.Villa;

import java.math.BigDecimal;

public class BuildingFactory {

    public static IBuilding createBuilding(BuildingType buildingType, BigDecimal price, Float squareMeter, int roomCount, int hallCount){
        IBuilding building;
        if(buildingType.equals(BuildingType.HOUSE)){
            building = new House(price, squareMeter, roomCount, hallCount);
        }
        else if(buildingType.equals(BuildingType.VILLA)){
            building = new Villa(price, squareMeter, roomCount, hallCount);
        }
        else if(buildingType.equals(BuildingType.SUMMERHOUSE)){
            building = new SummerHouse(price, squareMeter, roomCount, hallCount);
        }
        else{
            throw new RuntimeException(buildingType+" type buildings cannot be created.");
        }
        return building;
    }

}
