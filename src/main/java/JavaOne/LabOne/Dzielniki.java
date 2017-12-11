package JavaOne.LabOne;

import java.util.Scanner;

public class Dzielniki {

    public static void main(String[] args) {
        int enteredNumber;
        enteredNumber = readNumber();
        int[] dividers = findDividers(enteredNumber);
        printDividers(dividers);
    }

    public static int readNumber(){
        int enteredNumber;
        System.out.println("Podaj mi liczbę a znajde jej wszystkie dzielniki");
        Scanner scanner = new Scanner(System.in);
        enteredNumber=  Math.abs(scanner.nextInt());
        return enteredNumber;
    }


    public static void printDividers(int[] dividers){
        for (int i=0; i<dividers.length; i++){
            if (dividers[i] != 0){
                System.out.println("The divider is " + dividers[i]);
            }
        }
    }

    public static int[] findDividers(int x){
        int[] numbersOfDividers = new int[(x/2)];
        for(int i=1; i < x/2; i++){
            if (checkDivider(x,i)){
                numbersOfDividers[i] = i;
            }
        }
        return numbersOfDividers;
    }


    public static boolean checkDivider(int a, int b){
        if (a % b == 0){
            return true;
        } else {
            return false;
        }
    }
}
