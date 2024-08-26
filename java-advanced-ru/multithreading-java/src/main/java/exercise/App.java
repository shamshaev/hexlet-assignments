package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");


    public static void main(String[] args) {
        int[] numbers = {10, -4, 67, 100, -100, 8};

        System.out.println(App.getMinMax(numbers));
    }



    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        var threadMin = new MinThread(numbers);
        var threadMax = new MaxThread(numbers);



        threadMin.start();
        LOGGER.log(Level.INFO, "Thread " + threadMin.getName() + " started");
        threadMax.start();
        LOGGER.log(Level.INFO, "Thread " + threadMax.getName() + " started");

        try {
            threadMin.join();
            threadMax.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.log(Level.INFO, "Thread " + threadMin.getName() + " finished");
        LOGGER.log(Level.INFO, "Thread " + threadMax.getName() + " finished");

        return Map.of("min", threadMin.getMin(), "max", threadMax.getMax());
    }
    // END
}
