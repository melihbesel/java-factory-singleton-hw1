package com.patika.repository;


import com.patika.interfaces.IBuilding;

import java.util.ArrayList;
import java.util.List;

public class HouseRepository {

    private List<IBuilding> houseList = new ArrayList<>();

    private static HouseRepository lazySingleton;

    private HouseRepository(){
        System.out.println("HouseRepository sınıfından bir nesne oluşturuldu.");
    }

    public static HouseRepository getInstance(){
        if (lazySingleton == null){
            lazySingleton = new HouseRepository();
        }
        return lazySingleton;
    }



    public void save(IBuilding house) {
        houseList.add(house);
    }

    public List<IBuilding> findAll() {
        return houseList;
    }
}
