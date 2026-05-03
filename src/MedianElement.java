import java.util.*;

public class MedianElement {

    static void merge(int[] numbers, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++)
            leftArray[i] = numbers[left + i];

        for (int j = 0; j < rightSize; j++)
            rightArray[j] = numbers[middle + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                numbers[k++] = leftArray[i++];
            } else {
                numbers[k++] = rightArray[j++];
            }
        }

        while (i < leftSize) numbers[k++] = leftArray[i++];
        while (j < rightSize) numbers[k++] = rightArray[j++];
    }

    static void mergeSort(int[] numbers, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(numbers, left, middle);
            mergeSort(numbers, middle + 1, right);

            merge(numbers, left, middle, right);
        }
    }

    static double calculateMedian(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1);

        int size = numbers.length;

        if (size % 2 == 1) {
            return numbers[size / 2];
        } else {
            return (numbers[size / 2 - 1] + numbers[size / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        int arraySize = inputReader.nextInt();
        int[] numbers = new int[arraySize];

        for (int index = 0; index < arraySize; index++) {
            numbers[index] = inputReader.nextInt();
        }

        System.out.println(calculateMedian(numbers));
    }
}