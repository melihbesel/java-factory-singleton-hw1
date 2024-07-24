package com.patika.repository;


import com.patika.interfaces.IBuilding;

import java.util.ArrayList;
import java.util.List;

public class SummerHouseRepository {

    private List<IBuilding> summerHouseList = new ArrayList<>();

    private static SummerHouseRepository lazySingleton;

    private SummerHouseRepository(){
        System.out.println("SummerHouseRepository sınıfından bir nesne oluşturuldu.");
    }

    public static SummerHouseRepository getInstance(){
        if (lazySingleton == null){
            lazySingleton = new SummerHouseRepository();
        }
        return lazySingleton;
    }



    public void save(IBuilding summerHouse) {
        summerHouseList.add(summerHouse);
    }

    public List<IBuilding> findAll() {
        return summerHouseList;
    }
}
