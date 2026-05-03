import java.util.*;

public class ShippingCapacity {

    static boolean canDeliverWithinDays(int[] packageWeights, int allowedDays, int shipCapacity) {

        int currentLoad = 0;
        int requiredDays = 1;

        for (int weight : packageWeights) {

            if (currentLoad + weight > shipCapacity) {
                requiredDays++;
                currentLoad = 0;
            }

            currentLoad += weight;
        }

        return requiredDays <= allowedDays;
    }

    static int findMinimumShipCapacity(int[] packageWeights, int allowedDays) {

        int minimumCapacity = packageWeights[0];
        int maximumCapacity = 0;

        for (int weight : packageWeights) {

            if (weight > minimumCapacity) {
                minimumCapacity = weight;
            }

            maximumCapacity += weight;
        }

        while (minimumCapacity < maximumCapacity) {

            int middleCapacity =
                    minimumCapacity + (maximumCapacity - minimumCapacity) / 2;

            if (canDeliverWithinDays(
                    packageWeights,
                    allowedDays,
                    middleCapacity)) {

                maximumCapacity = middleCapacity;

            } else {

                minimumCapacity = middleCapacity + 1;
            }
        }

        return minimumCapacity;
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        int numberOfPackages = inputReader.nextInt();

        int[] packageWeights = new int[numberOfPackages];

        for (int index = 0; index < numberOfPackages; index++) {
            packageWeights[index] = inputReader.nextInt();
        }

        int allowedDays = inputReader.nextInt();

        System.out.println(
                findMinimumShipCapacity(packageWeights, allowedDays)
        );
    }
}