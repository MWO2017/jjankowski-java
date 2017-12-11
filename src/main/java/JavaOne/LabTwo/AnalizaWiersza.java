package JavaOne.LabTwo;

import java.util.HashMap;
import java.util.LinkedList;

public class AnalizaWiersza {

    private static final String LYRICS = "Dwunastu braci, wierzac w sny, zbadalo mur od marzen strony,\n" +
            "A poza murem plakal glos, dziewczecy glos zaprzepaszczony.\n" +
            "I pokochali glosu dzwiek i chetny domysl o Dziewczynie,\n" +
            "I zgadywali ksztalty ust po tym, jak spiew od zalu ginie...\n" +
            "Mowili o niej: \"lka, wiec jest!\" - I nic innego nie mowili,\n" +
            "I przezegnali caly swiat - i swiat zadumal sie w tej chwili...\n" +
            "Porwali mloty w twarda dlon i jeli w mury tluc z loskotem!\n" +
            "I nie wiedziala slepa noc, kto jest czlowiekiem, a kto mlotem?\n" +
            "\"O, predzej skruszmy zimny glaz, nim smierc Dziewczyne rdza powlecze!\" -\n" +
            "Tak, walac w mur, dwunasty brat do jedenastu innych rzecze.\n" +
            "Ale daremny byl ich trud, daremny ramion sprzeg i usil!\n" +
            "Oddali ciala swe na strwon owemu snowi, co ich kusil!\n" +
            "lamia sie piersi, trzeszczy kosc, prochnieja dlonie, twarze bledna...\n" +
            "I wszyscy w jednym zmarli dniu i noc wieczysta mieli jedna!\n" +
            "Lecz cienie zmarlych - Boze moj! - nie wypuscily mlotow z dloni!\n" +
            "I tylko inny plynie czas - i tylko mlot inaczej dzwoni...\n" +
            "I dzwoni w przod! I dzwoni wspak! I wzwyz za kazdym grzmi nawrotem!\n" +
            "I nie wiedziala slepa noc, kto tu jest cieniem, a kto mlotem?\n" +
            "\"O, predzej skruszmy zimny glaz, nim smierc Dziewczyne rdza powlecze!\" -\n" +
            "Tak, walac w mur, dwunasty cien do jedenastu innych rzecze.\n" +
            "Lecz cieniom zbraklo nagle sil, a cien sie mrokom nie opiera!\n" +
            "I powymarly jeszcze raz, bo nigdy dosc sie nie umiera...\n" +
            "I nigdy dosc, i nigdy tak, jak pragnie tego ow, co kona!...\n" +
            "I znikla tresc - i zginal slad - i powiesc o nich juz skonczona!\n" +
            "Lecz dzielne mloty - Boze moj - mdlej nie poddaly sie zalobie!\n" +
            "I same przez sie bily w mur, huczaly spizem same w sobie!\n" +
            "Huczaly w mrok, huczaly w blask i ociekaly ludzkim potem!\n" +
            "I nie wiedziala slepa noc, czym bywa mlot, gdy nie jest mlotem?\n" +
            "\"O, predzej skruszmy zimny glaz, nim smierc Dziewczyne rdza powlecze!\" -\n" +
            "Tak, walac w mur, dwunasty mlot do jedenastu innych rzecze.\n" +
            "I runal mur, tysiacem ech wstrzasajac wzgorza i doliny!\n" +
            "Lecz poza murem - nic i nic! Ni zywej duszy, ni Dziewczyny!\n" +
            "Niczyich oczu ani ust! I niczyjego w kwiatach losu!\n" +
            "Bo to byl glos i tylko - glos, i nic nie bylo oprocz glosu!\n" +
            "Nic - tylko placz i zal i mrok i niewiadomosc i zatrata!\n" +
            "Takiz to swiat! Niedobry swiat! Czemuz innego nie ma swiata?\n" +
            "Wobec klamliwych jawnie snow, wobec zmarnialych w nicosc cudow,\n" +
            "Potezne mloty legly w rzad, na znak spelnionych godnie trudow.\n" +
            "I byla zgroza naglych cisz. I byla proznia w calym niebie!\n" +
            "A ty z tej prozni czemu drwisz, kiedy ta proznia nie drwi z ciebie?";


    public static void main(String[] args) {
        String[] listOfWords = getWordsInLyrics();
        LinkedList<String> letterFromLinkedList = prepareTableOfStringsIntoLinkedList(listOfWords);
        HashMap<String, LinkedList<String>> wordBegins = calculateWordOccurrence(letterFromLinkedList);
        checkWhichLetterIsTheMostPopular(wordBegins);
    }

    private static HashMap<String, LinkedList<String>>  calculateWordOccurrence( LinkedList<String> letterFromLinkedList){
        HashMap<String, LinkedList<String>> wordBegins = new HashMap<String, LinkedList<String>>();
        for (String string : letterFromLinkedList) {
            if (string.length() > 1) {
                String c = (String.valueOf(string.charAt(0)));
                wordBegins.putIfAbsent(c, new LinkedList<String>(new LinkedList<String>()));
                wordBegins.get(c).add(string);
            }
        }
        return wordBegins;
    }

    private static void checkWhichLetterIsTheMostPopular(HashMap<String, LinkedList<String>> wordBegins) {
        int highestNumber = 0;
        String name = "";
        for (String string : wordBegins.keySet()) {
            if (wordBegins.get(string).size() > highestNumber) {
                highestNumber = wordBegins.get(string).size();
                name = string;
            }
        }

        System.out.println("The most popular letter in this text is the letter '" + name + "' It was found " + highestNumber + "" +
                " times. Below you can find all occurrences:\n" + wordBegins.get(name));
    }

    private static LinkedList<String> prepareTableOfStringsIntoLinkedList(String[] arrayOfString) {
        LinkedList<String> wordsInLyrics = new LinkedList<String>();
        int i = 0;
        for (String word : arrayOfString) {
            wordsInLyrics.add(i, word.toLowerCase());
            i++;
        }
        return wordsInLyrics;
    }

    private static String[] getWordsInLyrics() {
        return LYRICS.split("\\W+");
    }
}