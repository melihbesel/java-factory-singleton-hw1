package com.patika;

import com.patika.interfaces.enums.BuildingType;
import com.patika.service.BuildingService;

public class Main {
    public static void main(String[] args) {

        BuildingService buildingService = BuildingService.getInstance();
        /**
         * Ev, Villa, Yazlık kaydet
         */
        buildingService.saveHouse("150000", 85.5f, 3, 1);
        buildingService.saveSummerHouse("1000000", 100f, 3, 1);
        buildingService.saveVilla("250000", 145.5f, 4, 2);
        buildingService.saveSummerHouse("350000", 75f, 2, 1);
        buildingService.saveHouse("200000", 135f, 4, 2);

        /**
         * Evlerin toplam fiyatlarını dönen bir metot
         */
        System.out.println("Evlerin toplam fiyatları:");
        System.out.println(buildingService.getTotalPriceHouse());

        /**
         * Villaların toplam fiyatlarını dönen bir metot
         */
        System.out.println("Villaların toplam fiyatları:");
        System.out.println(buildingService.getTotalPriceVilla());

        /**
         * Yazlıkların toplam fiyatlarını dönen bir metot
         */
        System.out.println("Yazlıkların toplam fiyatları:");
        System.out.println(buildingService.getTotalPriceSummerHouse());

        /**
         * Tüm tipteki evlerin toplam fiyatını dönen metot
         */
        System.out.println("Tüm tipteki evlerin toplam fiyatı:");
        System.out.println(buildingService.getTotalPrice());

        /**
         * Evlerin ortalama metrekaresini dönen bir metot
         */
        System.out.println("Evlerin ortalama metrekaresi:");
        System.out.println(buildingService.getAverageSquareMeterHouse());

        /**
         * Villaların ortalama metrekaresini dönen bir metot
         */
        System.out.println("Villaların ortalama metrekaresi:");
        System.out.println(buildingService.getAverageSquareMeterVilla());

        /**
         * Yazlıkların ortalama metrekaresini dönen bir metot
         */
        System.out.println("Yazlıkların ortalama metrekaresi:");
        System.out.println(buildingService.getAverageSquareMeterSummerHose());

        /**
         * Tüm tipteki evlerin ortalama metrekaresini dönen metot
         */
        System.out.println("Tüm tipteki evlerin ortalama metrekaresi:");
        System.out.println(buildingService.getAverageSquareMeter());

        /**
         * Oda ve salon sayısına göre tüm tipteki evleri filtreleyip dönen metot
         */
        System.out.println("Oda ve salon sayısına göre tüm tipteki evler:");
        System.out.println(buildingService.getBuildingsByFilters(4, 2));


    }
}