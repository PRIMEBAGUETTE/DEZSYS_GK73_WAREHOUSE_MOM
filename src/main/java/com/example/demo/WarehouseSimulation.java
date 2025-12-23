package com.example.demo;

import com.example.demo.ItemData;
import com.example.demo.WarehouseData;

import java.util.ArrayList;
import java.util.List;

public class WarehouseSimulation {

    private double getRandomDouble( int inMinimum, int inMaximum ) {

        double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum;
        double rounded = Math.round(number * 100.0) / 100.0;
        return rounded;

    }

    private int getRandomInt( int inMinimum, int inMaximum ) {

        double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum;
        Long rounded = Math.round(number);
        return rounded.intValue();

    }

    public WarehouseData getData(String inID) {
        WarehouseData data = new WarehouseData();

        switch (inID) {
            case "1":
                data.setWarehouseID("001");
                data.setWarehouseName("Linz Bahnhof");
                data.setWarehouseAddress("Bahnhofsstrasse 27/9");
                data.setWarehousePostalCode("4020");
                data.setWarehouseCity("Linz");
                data.setWarehouseCountry("Austria");
                break;

            case "2":
                data.setWarehouseID("002");
                data.setWarehouseName("Wien Hauptbahnhof");
                data.setWarehouseAddress("Bahnhofplatz 1");
                data.setWarehousePostalCode("1100");
                data.setWarehouseCity("Wien");
                data.setWarehouseCountry("Austria");
                break;

            case "3":
                data.setWarehouseID("003");
                data.setWarehouseName("Niederösterreich Lager");
                data.setWarehouseAddress("Industriestrasse 5");
                data.setWarehousePostalCode("3100");
                data.setWarehouseCity("St. Pölten");
                data.setWarehouseCountry("Austria");
                break;

            case "4":
                data.setWarehouseID("004");
                data.setWarehouseName("Burgenland Lager");
                data.setWarehouseAddress("Hauptstrasse 12");
                data.setWarehousePostalCode("7000");
                data.setWarehouseCity("Eisenstadt");
                data.setWarehouseCountry("Austria");
                break;

            default:
                data.setWarehouseID("000");
                data.setWarehouseName("Unknown");
        }
        List<ItemData> items = new ArrayList<>();
        items.add(new ItemData("532", "Leberkassemmeln", "Essen", getRandomInt(100, 5000), "Stück"));
        items.add(new ItemData("234", "Schnitzel", "Essen", getRandomInt(100, 5000), "Stück"));
        items.add(new ItemData("325", "Redbull", "Trinken", getRandomInt(50, 500), "Palette"));
        data.setProductData(items);
        return data;
    }

}
