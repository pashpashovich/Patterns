package ru.clevertec.movie;

import ru.clevertec.facade.ScheduleFacade;
import ru.clevertec.factory.ActionMovieFactory;
import ru.clevertec.factory.ComedyMovieFactory;
import ru.clevertec.factory.HorrorMovieFactory;
import ru.clevertec.factory.MovieFactory;
import ru.clevertec.movie.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class MovieCreator {
    Scanner in = new Scanner(System.in);
    public void addMovie(){
        System.out.print("Введите название фильма: ");
        String name = in.nextLine();
        System.out.println("Выберите жанр фильма:" +
                "\n1 - Боевик" +
                "\n2 - Комедия" +
                "\n3 - Ужастик");
        int n = in.nextInt();
        in.nextLine();
        int genre;
        switch (n) {
            case 1:
                genre = 1;
                break;
            case 2:
                genre = 2;
                break;
            case 3:
                genre = 3;
                break;
            default:
                genre = 0;
        }
        Date date = null;
        while (true) {
            try {
                System.out.print("Введите дату показа фильма (в формате дд.мм.гггг): ");
                String d = in.nextLine();
                SimpleDateFormat format = new SimpleDateFormat();
                format.applyPattern("dd.MM.yyyy");
                date = format.parse(d);
                break;
            } catch (ParseException e) {
                System.out.println("\tНекорректный ввод даты");
            }
        }
        LocalTime time = null;
        while (true) {
            try {
                System.out.print("Введите время показа фильма (в формате чч:мм): ");
                String t = in.nextLine();
                String[] decode = t.split(":");
                time = LocalTime.of(Integer.parseInt(decode[0]), Integer.parseInt(decode[1]));
                break;
            } catch (Exception e) {
                System.out.println("\tНекорректный ввод времени");
            }
        }
        MovieFactory movieFactory = createMovieFactoryByGenre(genre);
        Movie movie = movieFactory.createMovie(name, date, time);
        ScheduleFacade scheduleFacade = new ScheduleFacade();
        scheduleFacade.addMovie(movie);
    }
    public static MovieFactory createMovieFactoryByGenre(int type) {
        switch (type) {
            case 1:
                return new ActionMovieFactory();
            case 2:
                return new ComedyMovieFactory();
            case 3:
                return new HorrorMovieFactory();
            default:
                throw new IllegalArgumentException("Unknown movie type");
        }
    }
}
