package ru.epam.littleBelka.task6;

public class AtomicBoat {

    public String start;

    public AtomicBoat() {
        EngineForAtomicBoat atomicBoat = new EngineForAtomicBoat();
        start = atomicBoat.start();
    }

    class EngineForAtomicBoat {

        String start() {
            return "Пуск";
        }
    }
}
