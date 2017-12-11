package JavaOne.LabOne;

import java.util.ArrayList;
import java.util.Scanner;

public class Srednia {

    public static void main(String[] args) {
    int numberOfRemarks=0;
    double avgGrade=0;
    int grade;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę oceń ucznia");
        numberOfRemarks = scanner.nextInt();
        int[] marks = new int[numberOfRemarks];

        for (int i =0; i <numberOfRemarks; i++ ){
            System.out.println("podaj ocene");
            grade = scanner.nextInt();
            marks[i] = grade;
        }
        System.out.println("Srednia ocen wynosi: " + average(marks) );
        System.out.println("Najwyzsza ocena wynosi: " + maxVal(marks) );

    }

    public static double average(int[] marks) {
        int sum = 0;

        for(int i=0; i<marks.length; i++) {
            sum += marks[i];
        }

        return sum/(double)marks.length;
    }

    public static int maxVal(int[] marks){
        int maxVal = 0;

        for (int i =0; i < marks.length; i ++){
            if (maxVal< marks[i]){
                maxVal = marks[i];
            }
        }
        return maxVal;

    }

}