import java.util.*;

public class ManualQuicksort {

    static void quickSort(int[] numbers, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;

        int pivot = numbers[rightIndex];
        int partitionIndex = leftIndex;

        for (int currentIndex = leftIndex; currentIndex < rightIndex; currentIndex++) {
            if (numbers[currentIndex] < pivot) {
                int temp = numbers[currentIndex];
                numbers[currentIndex] = numbers[partitionIndex];
                numbers[partitionIndex] = temp;
                partitionIndex++;
            }
        }

        int temp = numbers[partitionIndex];
        numbers[partitionIndex] = numbers[rightIndex];
        numbers[rightIndex] = temp;

        quickSort(numbers, leftIndex, partitionIndex - 1);
        quickSort(numbers, partitionIndex + 1, rightIndex);
    }

    static int findKthSmallest(int[] numbers, int kPosition) {
        quickSort(numbers, 0, numbers.length - 1);
        return numbers[kPosition - 1];
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        int arraySize = inputReader.nextInt();
        int[] numbers = new int[arraySize];

        for (int index = 0; index < arraySize; index++) {
            numbers[index] = inputReader.nextInt();
        }

        int kPosition = inputReader.nextInt();

        System.out.println(findKthSmallest(numbers, kPosition));
    }
}