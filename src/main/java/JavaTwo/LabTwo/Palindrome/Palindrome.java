package JavaTwo.LabTwo.Palindrome;

public class Palindrome {

    public static boolean check(String wordToCheck) {

        String result = wordToCheck.toLowerCase().replaceAll("[-+.—^:,!’'”“? ]","");
        int wordLength = result.length();
        for (int i = 0; i < wordLength / 2; ++i) {
            if (result.charAt(i) != result.charAt(wordLength - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
