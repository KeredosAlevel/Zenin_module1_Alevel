
import java.util.Arrays;
import java.util.Random;

public class task1 {

    public static void main(String[] args) {

        int[] masive = new int[50];

        сreatngAnArray(masive);

        System.out.println("Created array: " + Arrays.toString(masive));

        System.out.println("Sorted array:  " + Arrays.toString(sortedArray(masive)));

        System.out.println("Count unique elements: " + "[" + countUniqueElements(sortedArray(masive)) + "]");
    }

    public static int[] сreatngAnArray(int[] masive) {
        Random randomArray = new Random();
        for (int i = 0; i < masive.length; i++) {
            masive[i] = randomArray.nextInt(50); // порог максимального элемента массива
        }
        return masive;
    }

    public static int[] sortedArray(int[] masive) {
        int[] copyArray = Arrays.copyOf(masive, masive.length);
        for (int i = 1; i < copyArray.length; i++) {
            for (int j = 0; j < copyArray.length - i; j++) {
                if (copyArray[j] > copyArray[j + 1]) {
                    int tmp = copyArray[j + 1];
                    copyArray[j + 1] = copyArray[j];
                    copyArray[j] = tmp;
                }
            }
        }
        return copyArray;
    }

    public static int countUniqueElements(int[] masive) {
        int elements = masive[0];
        int rezult = 1;
        for (int count : masive) {
            if (elements == count) {
                continue;
            } else {
                elements = count;
                rezult++;
            }
        }
        return rezult;
    }
}

