package ru.clevertec.factory;

import ru.clevertec.movie.ComedyMovie;
import ru.clevertec.movie.Movie;

import java.time.LocalTime;
import java.util.Date;

public class ComedyMovieFactory implements MovieFactory {
    @Override
    public Movie createMovie(String title, Date date, LocalTime time) {
        return new ComedyMovie(title, date, time);
    }
}
