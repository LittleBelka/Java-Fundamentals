package ru.epam.littleBelka.task1;

public class Pen {

    int numberColors;
    int rodThickness;

    public Pen(int numberColors, int rodThickness) {

        this.numberColors = numberColors;
        this.rodThickness = rodThickness;
    }

    @Override
    public boolean equals(Object object) {

        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(getClass() == object.getClass())) {
            return false;
        }
        Pen pen = (Pen) object;
        if (numberColors != pen.numberColors) {
            return false;
        }
        if (rodThickness != pen.rodThickness) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {

        final int x = Math.abs(numberColors - rodThickness);
        int result = 1;
        result = x * result + numberColors;
        result = x * result + rodThickness;
        return result;
    }

    @Override
    public String toString() {

        return "Pen: numberColors = " + numberColors + ", rodThickness = " + rodThickness;
    }
}












