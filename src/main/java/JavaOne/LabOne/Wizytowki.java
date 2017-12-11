package JavaOne.LabOne;

import java.util.Scanner;

public class Wizytowki {

    public static void main(String[] args) {

        System.out.println("Witaj w kreatorze wizytówek, za chwilę poproszę Cie o dane aby przygotować dla CIebie wizytówkę");
        System.out.println("Podaj swoje imie");
        Scanner reader = new Scanner(System.in);
        String name = reader.next();

        System.out.println("Podaj nazwisko");
        String lastname = reader.next();

        System.out.println("Podaj numer telefonu");

        int telNumber = reader.nextInt();

        System.out.println("Podaj nazwe miasta");
        String city = reader.next();

        String downLine = "";
        String upperLine = "";
        int upperLineLength = upperLine.length();

        String firstLine = "* " + name + " " + lastname;
        String secondLine = "* " + "tel. " + telNumber + " adres: " + city;

        if (firstLine.length() > secondLine.length()) {
            int differenceBetweenFisrtAndSecond = firstLine.length() - secondLine.length();
            String result = "";
            for (int i = 0; i < differenceBetweenFisrtAndSecond; i++) {
                result = result + " ";
            }
            result += " *";
            secondLine += result;
            firstLine += " *";
        } else {
            int differenceBetweenSecondAndFirst = secondLine.length() - firstLine.length();
            String result = "";
            for (int i = 0; i < differenceBetweenSecondAndFirst; i++) {
                result = result + " ";
            }
            result = result + " *";

            firstLine += result;
            secondLine += " *";
        }

        for (int i = 0; i < firstLine.length(); i++) {
            downLine += "*";
            upperLine += "*";
        }
        System.out.println();
        System.out.println(upperLine);
        System.out.println(firstLine);
        System.out.println(secondLine);

        for (int i = 0; i < upperLineLength; i++) {
            downLine = downLine + "*";
        }
        System.out.println(downLine);

    }
}
