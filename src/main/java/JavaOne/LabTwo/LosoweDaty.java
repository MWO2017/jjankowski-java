package JavaOne.LabTwo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

public class LosoweDaty {
    static int day;
    static int month;
    static int year;
    static Scanner scanner;

    public static void main(String[] args) {

        System.out.println("Choose one of the available options:\n" +
                "1 - enter data\n" +
                "2 - generate random data");
        scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        LocalDate localDate = null;
        switch (option) {
            case (1):
                localDate = getLocalDate();
                break;
            case (2):
                localDate = loadRandomDate();
                break;
            default:
                System.out.println("invalid option");
                break;

        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate actualLocalDate = LocalDate.now();

        System.out.println(dtf.format(actualLocalDate));
        System.out.println(dtf.format(localDate));

        long numberOfYears = Math.abs(ChronoUnit.YEARS.between(actualLocalDate, localDate));

        System.out.println("The difference in years is: " + numberOfYears);
    }

    public static LocalDate loadUserDate(int year, int month, int day){
         return LocalDate.of(year, month, day);
    }

    public static LocalDate loadRandomDate() {
        day = generateRandomNumber(1, 28);
        month = generateRandomNumber(1, 12);
        year = generateRandomNumber(1900, 2015);
        return loadUserDate(year, month, day);
    }

    public static int generateRandomNumber(int from, int to) {
        Random rn = new Random();
        int range = to - from + 1;
        int randomNum = rn.nextInt(range) + from;
        return Math.abs(randomNum);
    }

    public static LocalDate getLocalDate() {
        System.out.println("Please provide day of the year");
        day = scanner.nextInt();
        System.out.println("Please provide month of the year");
        month = scanner.nextInt();
        System.out.println("Please provide year");
        year = scanner.nextInt();
        return loadUserDate(year, month, day);
    }

}
