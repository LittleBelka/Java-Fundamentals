package com.epam.littleBelka.task4;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Films{

    public void addFilms () {

        File file = new File("Actors.tmp");
        HashMap<String, FilmsInfo> films = new HashMap<>();
        if (file.exists()) {
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));) {

                films = (HashMap<String, FilmsInfo>) in.readObject();
                films.get("Форрест Гамп").addActor("Гэри Синиз", 61, "США");
                films.get("Эффект бабочки").removeActor("Эми Смарт");
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(films);
                out.close();

                Iterator<Map.Entry<String, FilmsInfo>> iter = films.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, FilmsInfo> entry = iter.next();
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue().getAllActorsWithInform());
                    System.out.println();
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));){
                films.put("Эффект бабочки", new FilmsInfo("Эффект бабочки"));
                films.get("Эффект бабочки").addActor("Эштон Кутчер", 38, "США");
                films.get("Эффект бабочки").addActor("Эми Смарт", 39, "США");
                films.get("Эффект бабочки").addActor("Эрик Штольц", 54, "США");

                films.put("Форрест Гамп", new FilmsInfo("Форрест Гамп"));
                films.get("Форрест Гамп").addActor("Том Хэнкс", 59, "США");
                films.get("Форрест Гамп").addActor("Робин Райт", 49, "США");

                films.put("Гордость и предубеждение", new FilmsInfo("Гордость и предубеждение"));
                films.get("Гордость и предубеждение").addActor("Кира Найтли", 31, "Великобритания");
                films.get("Гордость и предубеждение").addActor("Мэттью Макфэдьен", 41, "Великобритания");

                out.writeObject(films);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
