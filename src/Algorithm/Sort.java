package Algorithm;

public class Sort {
    public int[] bubbleSort(int[] arr) {
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime);
        System.out.println("Bubble sort time: " + time);

        return arr;
    }
}
