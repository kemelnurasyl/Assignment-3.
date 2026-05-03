import java.util.*;

public class AnagramSortChecker {

    static void bubbleSort(char[] data) {
        int length = data.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    char temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    static boolean checkAnagram(String firstWord, String secondWord) {
        if (firstWord.length() != secondWord.length()) {
            return false;
        }

        char[] firstArray = firstWord.toCharArray();
        char[] secondArray = secondWord.toCharArray();

        bubbleSort(firstArray);
        bubbleSort(secondArray);

        for (int index = 0; index < firstArray.length; index++) {
            if (firstArray[index] != secondArray[index]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        String firstWord = inputReader.next();
        String secondWord = inputReader.next();

        if (checkAnagram(firstWord, secondWord)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}