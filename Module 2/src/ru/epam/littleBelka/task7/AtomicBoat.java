package ru.epam.littleBelka.task7;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Boat {
    String model();
    int submarineSpeed();
}

public class AtomicBoat {

    public String start;

    public AtomicBoat() {
        EngineForAtomicBoat atomicBoat = new EngineForAtomicBoat();
        start = atomicBoat.start();
    }

    class EngineForAtomicBoat {

        @Boat(model = "Шань", submarineSpeed = 65)
        public String start() {
            EngineForAtomicBoat boat = new EngineForAtomicBoat();
            try {
                Class<?> c = boat.getClass();
                Method m = c.getMethod("start");
                Boat submarine = m.getAnnotation(Boat.class);
                return "Пуск лодки \"" + submarine.model() + "\" со скоростью " + submarine.submarineSpeed() + " км/ч";
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return " ";
        }
    }
}

/*class StartAtomBoat {

    public static void main(String[] args) {
        AtomicBoat boat = new AtomicBoat();
    }
}*/
