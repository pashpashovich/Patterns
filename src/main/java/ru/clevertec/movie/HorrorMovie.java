package ru.clevertec.movie;

import java.time.LocalTime;
import java.util.Date;

public class HorrorMovie extends Movie {
    private int age_rating;

    public HorrorMovie(String title, Date date, LocalTime time) {
        super(title,"ужастик",date,time);
        this.age_rating = 18;
    }

    @Override
    public void showInfo() {
        System.out.println("----------------\nНазвание: " + title + "\nЖанр: ужастик\nВозрастное ограничение: " + age_rating + "+" + "\nДата показа: " + formatDate() + "\nВремя показа: " + time + "\n----------------");
    }
}
