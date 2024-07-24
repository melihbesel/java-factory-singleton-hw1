package com.patika.service;

import com.patika.factory.BuildingFactory;
import com.patika.interfaces.IBuilding;
import com.patika.interfaces.enums.BuildingType;
import com.patika.repository.HouseRepository;
import com.patika.repository.VillaRepository;
import com.patika.repository.SummerHouseRepository;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BuildingService {

    private static final HouseRepository houseRepository = HouseRepository.getInstance();
    private static final VillaRepository villaRepository = VillaRepository.getInstance();
    private static final SummerHouseRepository summerHouseRepository = SummerHouseRepository.getInstance();

    private static final BuildingService eagerSingleton = new BuildingService();

    private BuildingService(){
        System.out.println("BuildingService sınıfından bir nesne oluşturuldu.");
    }

    public static BuildingService getInstance(){
        return eagerSingleton;
    }

    /**
     * Ev kaydet
     */
    public void saveHouse(String price, Float squareMeter, int roomCount, int hallCount) {
        IBuilding building = BuildingFactory.createBuilding(BuildingType.HOUSE, new BigDecimal(price), squareMeter, roomCount, hallCount);
        houseRepository.save(building);
    }

    /**
     * Villa kaydet
     */
    public void saveVilla(String price, Float squareMeter, int roomCount, int hallCount) {
        IBuilding building = BuildingFactory.createBuilding(BuildingType.VILLA, new BigDecimal(price), squareMeter, roomCount, hallCount);
        villaRepository.save(building);
    }

    /**
     * Yazlık kaydet
     */
    public void saveSummerHouse(String price, Float squareMeter, int roomCount, int hallCount) {
        IBuilding building = BuildingFactory.createBuilding(BuildingType.SUMMERHOUSE, new BigDecimal(price), squareMeter, roomCount, hallCount);
        summerHouseRepository.save(building);
    }

    /**
     * Evlerin toplam fiyatlarını dönen bir metot
     */
    public BigDecimal getTotalPriceHouse() {
        return houseRepository.findAll().stream()
                .map(IBuilding::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Villaların toplam fiyatlarını dönen bir metot
     */
    public BigDecimal getTotalPriceVilla() {
        return villaRepository.findAll().stream()
                .map(IBuilding::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Yazlıkların toplam fiyatlarını dönen bir metot
     */
    public BigDecimal getTotalPriceSummerHouse() {
        return summerHouseRepository.findAll().stream()
                .map(IBuilding::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Tüm tipteki evlerin toplam fiyatını dönen metot
     */
    public BigDecimal getTotalPrice() {
        return getTotalPriceHouse()
                .add(getTotalPriceVilla())
                .add(getTotalPriceSummerHouse());
    }

    /**
     * Evlerin ortalama metrekaresini dönen bir metot
     */
    public float getAverageSquareMeterHouse() {
        Float totalSquareMeter = houseRepository.findAll().stream()
                .map(IBuilding::getSquareMeter)
                .reduce(0f, Float::sum);

        return totalSquareMeter / houseRepository.findAll().size();
    }

    /**
     * Villaların ortalama metrekaresini dönen bir metot
     */
    public float getAverageSquareMeterVilla() {
        Float totalSquareMeter = villaRepository.findAll().stream()
                .map(IBuilding::getSquareMeter)
                .reduce(0f, Float::sum);

        return totalSquareMeter / villaRepository.findAll().size();
    }

    /**
     * Yazlıkların ortalama metrekaresini dönen bir metot
     */
    public float getAverageSquareMeterSummerHose() {
        Float totalSquareMeter = summerHouseRepository.findAll().stream()
                .map(IBuilding::getSquareMeter)
                .reduce(0f, Float::sum);

        return totalSquareMeter / summerHouseRepository.findAll().size();
    }

    /**
     * Tüm tipteki evlerin ortalama metrekaresini dönen metot
     */
    public double getAverageSquareMeter() {
        return (getAverageSquareMeterHouse() + getAverageSquareMeterVilla() + getAverageSquareMeterSummerHose()) / 3;
    }

    /**
     * Oda ve salon sayısına göre tüm tipteki evleri filtreleyip dönen metot
     */
    public List<IBuilding> getBuildingsByFilters(int roomCount, int hallCount) {
        List<IBuilding> allBuildings = new ArrayList<>();
        List<IBuilding> houseList = houseRepository.findAll().stream()
                .filter(o -> o.getRoomCount() == roomCount)
                .filter(o -> o.getHallCount() == hallCount)
                .toList();
        List<IBuilding> villaList = villaRepository.findAll().stream()
                .filter(o -> o.getRoomCount() == roomCount)
                .filter(o -> o.getHallCount() == hallCount)
                .toList();
        List<IBuilding> summerHouseList = summerHouseRepository.findAll().stream()
                .filter(o -> o.getRoomCount() == roomCount)
                .filter(o -> o.getHallCount() == hallCount)
                .toList();
        allBuildings.addAll(houseList);
        allBuildings.addAll(villaList);
        allBuildings.addAll(summerHouseList);
        return allBuildings;
    }

}
