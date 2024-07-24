package com.patika.repository;


import com.patika.interfaces.IBuilding;

import java.util.ArrayList;
import java.util.List;

public class VillaRepository {

    private List<IBuilding> villaList = new ArrayList<>();

    private static VillaRepository lazySingleton;

    private VillaRepository(){
        System.out.println("VillaRepository sınıfından bir nesne oluşturuldu.");
    }

    public static VillaRepository getInstance(){
        if (lazySingleton == null){
            lazySingleton = new VillaRepository();
        }
        return lazySingleton;
    }



    public void save(IBuilding villa) {
        villaList.add(villa);
    }

    public List<IBuilding> findAll() {
        return villaList;
    }
}
