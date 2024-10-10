package ru.clevertec.factory;

import ru.clevertec.movie.ActionMovie;
import ru.clevertec.movie.Movie;

import java.time.LocalTime;
import java.util.Date;

public class ActionMovieFactory implements MovieFactory {
    @Override
    public Movie createMovie(String title, Date date, LocalTime time) {
        return new ActionMovie(title, date, time);
    }
}