package ru.clevertec.movie;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Movie implements Component {
    private String title;
    private String genre;
    private Date date;
    private LocalTime time;

    public Movie(String title, String genre, Date date, LocalTime time) {
        this.title = title;
        this.genre = genre;
        this.date = date;
        this.time = time;
    }

    public String formatDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(date);
    }

    public LocalTime getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public void showInfo() {
        System.out.println(" ");
    }
}


