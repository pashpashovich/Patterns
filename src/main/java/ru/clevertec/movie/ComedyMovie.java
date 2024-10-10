package ru.clevertec.movie;

import java.time.LocalTime;
import java.util.Date;

public class ComedyMovie extends Movie {
    public ComedyMovie(String title, Date date, LocalTime time) {
        super(title,"комедия",date,time);
    }

    @Override
    public void showInfo() {
        System.out.println("----------------\nНазвание: " + title + "\nЖанр: комедия" + "\nДата показа: " + formatDate() + "\nВремя показа: " + time + "\n----------------");
    }
}
