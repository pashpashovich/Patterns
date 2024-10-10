package ru.clevertec.factory;

import ru.clevertec.movie.HorrorMovie;
import ru.clevertec.movie.Movie;

import java.time.LocalTime;
import java.util.Date;

public class HorrorMovieFactory implements MovieFactory{
    @Override
    public Movie createMovie(String title, Date date, LocalTime time) {
        return new HorrorMovie(title,date,time);
    }
}
