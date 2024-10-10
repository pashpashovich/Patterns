package ru.clevertec.facade;

import ru.clevertec.movie.Component;
import ru.clevertec.movie.Movie;
import ru.clevertec.singletone.Schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ScheduleFacade {
    Scanner in = new Scanner(System.in);
    Schedule schedule = Schedule.getInstance();

    public void editMovie() {
        ArrayList<Component> movs = (ArrayList<Component>) schedule.getMovies();
        if (movs.isEmpty()) {
            System.out.println("В расписании нет фильмов");
            return;
        }
        System.out.println("Выберите фильм для изменения:");
        for (int i = 0; i < movs.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + ((Movie)movs.get(i)).getTitle());
        }
        int c = in.nextInt();
        in.nextLine();
        Date date;
        while (true) {
            try {
                System.out.print("Введите новую дату показа фильма (в формате дд.мм.гггг): ");
                String d = in.nextLine();
                SimpleDateFormat format = new SimpleDateFormat();
                format.applyPattern("dd.MM.yyyy");
                date = format.parse(d);
                break;
            } catch (ParseException e) {
                System.out.println("\tНекорректный ввод даты");
            }
        }
        LocalTime time;
        while (true) {
            try {
                System.out.print("Введите новое время показа фильма (в формате чч:мм): ");
                String t = in.nextLine();
                String[] decode = t.split(":");
                time = LocalTime.of(Integer.parseInt(decode[0]), Integer.parseInt(decode[1]));
                break;
            } catch (Exception e) {
                System.out.println("\tНекорректный ввод времени");
            }
        }
        schedule.changeSchedule(c - 1, date, time);
    }

    public void deleteMovie() {
        ArrayList<Component> movs = (ArrayList<Component>) schedule.getMovies();
        if (movs.isEmpty()) {
            System.out.println("В расписании нет фильмов");
            return;
        }
        System.out.println("Выберите фильм для изменения:");
        for (int i = 0; i < movs.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + ((Movie) movs.get(i)).getTitle());
        }
        int c = in.nextInt();
        in.nextLine();
        schedule.deleteMovie(c - 1);
    }
    public void displaySchedule(){
        schedule.showInfo();
    }
    public void addViewer(){
        System.out.print("Введите имя подписчика: ");
        String name = in.nextLine();
        schedule.attach(name);
    }
    public void addMovie(Movie movie){
        schedule.addMovie(movie);
    }
}
