package ru.clevertec.movie;

import java.time.LocalTime;
import java.util.Date;

public class ActionMovie extends Movie {
    public ActionMovie(String title, Date date, LocalTime time) {
        super(title,"боевик",date,time);
    }

    @Override
    public void showInfo() {
        System.out.println("----------------\nНазвание: " + title + "\nЖанр: боевик" + "\nДата показа: " + formatDate() + "\nВремя показа: " + time + "\n----------------");
    }
}
