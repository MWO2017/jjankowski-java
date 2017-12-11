package JavaOne.LabTwo;

import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteka {
    static HashMap<String, Integer> register;
    static ArrayList<String> whiteRavens;

    private static String[] BOOKS = {"Priests Of Dawn",
            "Chicken Abroad",
            "Lord With Sins",
            "Chicken Abroad",
            "Fish And Horses",
            "Mistress Of Devotion",
            "Bandit Of The Void",
            "Lord With Sins",
            "Guardians And Gangsters",
            "Lions Of Dread",
            "Chicken Abroad",
            "Future Of Fire",
            "Priests Of Dawn",
            "Fish And Horses",
            "Chicken Abroad",
            "Fish And Horses",
            "Guardians And Gangsters",
            "Inception Of Heaven",
            "Lord With Sins",
            "Future Of Fire",
            "Driving Into The Depths",
            "Starting The Demons",
            "Maid With Blue Eyes",
            "Mistress Of Devotion",
            "Lovers In The Forest",
            "Fish And Horses",
            "Maid With Blue Eyes",
            "Destruction Of The Faceless Ones",
            "Guardians And Gangsters",
            "Chicken Abroad"};

    public static HashMap<String, Integer> createBooksCounter() {
        register = new HashMap();
        for (String book : BOOKS) {
            register.put(book, 0);
        }
        return register;
    }

    public static void countBook(HashMap<String, Integer> booksCounter, String book) {

        if (!booksCounter.containsKey(book)) {
            booksCounter.put(book, 1);
        } else {
            booksCounter.put(book, booksCounter.get(book) + 1);
        }
    }

    public static ArrayList<String> findWhiteRavens(HashMap<String, Integer> register) {
        whiteRavens = new ArrayList<String>();
        for (String name : register.keySet()) {
            if (register.get(name) == 1) {
                whiteRavens.add(name);
            }
        }
        return whiteRavens;
    }

    public static void printWhiteRavens(ArrayList<String> whiteRavens) {
        for (String element : whiteRavens) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        createBooksCounter();
        for (String book : BOOKS) {
            countBook(register, book);
        }
        printWhiteRavens(findWhiteRavens(register));
    }
}
