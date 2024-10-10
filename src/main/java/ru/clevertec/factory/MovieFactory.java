package ru.clevertec.factory;

import ru.clevertec.movie.Movie;

import java.time.LocalTime;
import java.util.Date;

public interface MovieFactory {

    Movie createMovie(String title, Date date, LocalTime time);
}
