package exercise;

// BEGIN
public class MaxThread extends Thread {
    private final int[] numbers;
    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {

        max = numbers[0];
        for (var number : numbers) {
            if (max < number) {
                max = number;
            }
        }
    }
}
// END
