package JavaOne.LabOne;

public class SortowanieBabelkowe {

    public static void main(String[] args) {
        int[] numbers = new int[]{4, 2, 0, 2, 10, 1, 9, 12, 3, 5};
        sort(numbers);
        printNumbers(numbers);
    }

    private static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (isGreaterThan(numbers[j], numbers[j + 1])) {
                    swap(numbers, j);
                }
            }
        }
    }

    private static void swap(int[] numbers, int positonOfArray) {
        int temp = numbers[positonOfArray];
        numbers[positonOfArray] = numbers[positonOfArray + 1];
        numbers[positonOfArray + 1] = temp;
    }

    private static boolean isGreaterThan(int firstNumber, int secondNumber) {
        return firstNumber > secondNumber;
    }

    private static void printNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
