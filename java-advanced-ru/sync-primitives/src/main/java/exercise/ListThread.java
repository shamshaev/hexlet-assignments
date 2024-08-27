package exercise;

// BEGIN
public class ListThread extends Thread {
    private SafetyList safetyList;

    public ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {
        for (var i = 0; i < 1000; i++) {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            var number = (int) (Math.random() * 1000);
            safetyList.add(number);
        }
    }
}
// END
