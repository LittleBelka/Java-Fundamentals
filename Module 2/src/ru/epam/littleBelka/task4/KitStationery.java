package ru.epam.littleBelka.task4;

import ru.epam.littleBelka.task3.*;

import java.util.Arrays;
import java.util.Comparator;

public class KitStationery{

    public Stationery[] kit = new Stationery[5];

    public void createKitStationery() {

        Glue glue = new Glue("Glue", 300, "Kinotti");
        glue.addGlue();
        glue.addGlue();
        Stapler stapler = new Stapler("Stapler", 200, "Berlingo");
        stapler.addStapler();
        Paper paper = new Paper("Paper", 75, "Hatber");
        paper.addPaper();
        Pen pen = new Pen("Pen", "Black", "Erich Krause");
        pen.addPen();
        pen.addPen();
        pen.addPen();
        Pencil pencil = new Pencil("Pencil", "blue", "Silwerhof");
        pencil.addPencil();
        kit[0] = glue;
        kit[1] = stapler;
        kit[2] = paper;
        kit[3] = pen;
        kit[4] = pencil;

    }

    public void sortedByPrice() {

        Arrays.sort(kit, new Comparator<Stationery>() {
            @Override
            public int compare(Stationery o1, Stationery o2) {
                return o1.cost() - o2.cost();
            }
        });
    }

    public void sortedByName() {

        Arrays.sort(kit, new Comparator<Stationery>() {
            @Override
            public int compare(Stationery o1, Stationery o2) {
                return o1.getNameStationery().compareTo(o2.getNameStationery());
            }
        });
    }

    public void sortedByPriceAndName() {

        Arrays.sort(kit, new Comparator<Stationery>() {
            @Override
            public int compare(Stationery o1, Stationery o2) {
                int result = o1.cost() - o2.cost();
                if(result != 0) {
                    return result;
                }
                result = o1.getNameStationery().compareTo(o2.getNameStationery());
                if(result != 0) {
                    return result;
                }
                return 0;
            }
        });
    }

    public void show() {
        for (Stationery e: kit) {
            System.out.println(e.getNameStationery() + "  " + e.cost());
        }
    }

}
