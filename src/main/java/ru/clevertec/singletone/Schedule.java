package ru.clevertec.singletone;

import ru.clevertec.movie.Component;
import ru.clevertec.movie.Movie;
import ru.clevertec.observer.Observer;
import ru.clevertec.observer.Viewer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule implements Component {
    private static Schedule instance;
    private List<Component> movies;
    private List<Observer> observers;

    private Schedule() {
        movies = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public List<Component> getMovies() {
        return movies;
    }

    public static Schedule getInstance() {
        if (instance == null) {
            instance = new Schedule();
        }
        return instance;
    }

    public void addMovie(Component movie) {
        movies.add(movie);
        notifyObservers();
    }

    public void showInfo() {
        if (movies.isEmpty()) System.out.println("В расписании нет фильмов");
        else {
            System.out.println("\nРасписание фильмов:");
            for (Component movie : movies) {
                movie.showInfo();
            }
        }
    }

    public void changeSchedule(int num, Date date, LocalTime time) {
        try {
            Movie movie = (Movie) movies.get(num);
            movie.setDate(date);
            movie.setTime(time);
            System.out.println("Расписание было изменено");
            notifyObservers();
        } catch (Exception e) {
            System.out.println("\tНеправильно выбран фильм для изменения");
        }
    }

    public void deleteMovie(int num) {
        try {
            movies.remove(num);
            System.out.println("Фильм был удален из расписания");
            notifyObservers();
        } catch (Exception e) {
            System.out.println("\tНеправильно выбран фильм для изменения");
        }
    }

    public void attach(String name) {
        Viewer viewer = new Viewer(name);
        observers.add(viewer);
        System.out.println("\tБыл добавлен подписчик " + name);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
