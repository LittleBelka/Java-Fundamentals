package ru.epam.littleBelka.task3;

public class KitStationery {

    public void createKitStationery() {

        Stationery[] kit = new Stationery[5];

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
}
