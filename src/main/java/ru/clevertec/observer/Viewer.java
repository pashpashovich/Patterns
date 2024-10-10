package ru.clevertec.observer;

public class Viewer implements Observer {
    private String name;

    public Viewer(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("\t" + name + " получил уведомление о изменении расписания фильмов!");
    }
}