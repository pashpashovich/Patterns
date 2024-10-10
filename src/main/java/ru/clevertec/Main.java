package ru.clevertec;

import ru.clevertec.facade.ScheduleFacade;
import ru.clevertec.movie.MovieCreator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ScheduleFacade scheduleFacade = new ScheduleFacade();
        MovieCreator movieFacade = new MovieCreator();
        while (true) {

            System.out.println("Выберите действие:" +
                    "\n1 - добавить подписчика кинотеатра" +
                    "\n2 - добавить фильм" +
                    "\n3 - просмотреть расписание" +
                    "\n4 - изменить расписание" +
                    "\n5 - удалить фильм из расписания" +
                    "\n0 - выход");
            int num = in.nextInt();
            in.nextLine();
            switch (num) {
                case 1 -> scheduleFacade.addViewer();
                case 2 -> movieFacade.addMovie();
                case 3 -> scheduleFacade.displaySchedule();
                case 4 -> scheduleFacade.editMovie();
                case 5 -> scheduleFacade.deleteMovie();
                case 0 -> {
                    return;
                }
                default -> System.out.println("\tНеправильный ввод");
            }
        }
    }
}
