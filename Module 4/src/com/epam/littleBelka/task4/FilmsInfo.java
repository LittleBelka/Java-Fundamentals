package com.epam.littleBelka.task4;

import java.io.Serializable;
import java.util.ArrayList;

public class FilmsInfo implements Serializable{

    private String movieTitle;
    private ArrayList<String> actors;
    private ArrayList<Integer> ageActors;
    private ArrayList<String> placeOfBirth;

    public FilmsInfo(String movieTitle) {
        this.movieTitle = movieTitle;
        this.actors = new ArrayList<>();
        this.ageActors = new ArrayList<>();
        this.placeOfBirth = new ArrayList<>();
    }

    public void addActor(String actor, int age, String country) {
        if (actor != null && country != null && age > 0 && !actors.contains(actor)) {
            actors.add(actor);
            ageActors.add(age);
            placeOfBirth.add(country);
        }
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public ArrayList<String> getInfoAboutActor(String name) {
        if (name != null && actors.contains(name)) {
            ArrayList<String> info = new ArrayList<>();
            info.add(actors.get(actors.indexOf(name)));
            info.add(String.valueOf(ageActors.get(actors.indexOf(name))));
            info.add(placeOfBirth.get(actors.indexOf(name)));
            return info;
        }
        return null;
    }

    public void setMovieTitle(String newTitle) {
        if (newTitle != null && !newTitle.equals("")) {
            movieTitle = newTitle;
        }
    }

    public void setInfoAboutActor(String name, int age, String country ) {
        if (name != null && country != null && age > 0 && actors.contains(name)) {
            removeActor(name);
            addActor(name, age, country);
        }
    }

    public void removeActor(String name) {
        if (name != null && actors.contains(name)) {
            ageActors.remove(actors.indexOf(name));
            placeOfBirth.remove(actors.indexOf(name));
            actors.remove(name);
        }
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public ArrayList<String> getAllActorsWithInform() {
        ArrayList<String> listActors = new ArrayList<>();
        for (int i = 0; i < actors.size(); i++) {
            listActors.add(actors.get(i) + " " + ageActors.get(i) + " " + placeOfBirth.get(i));
        }
        return listActors;
    }

}
