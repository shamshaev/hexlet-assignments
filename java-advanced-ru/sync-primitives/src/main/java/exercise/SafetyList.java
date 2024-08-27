package exercise;

class SafetyList {
    // BEGIN
    private int[] array = new int[10];
    private int size = 0;

    public synchronized void add(Integer number) {
        if (size + 1 == array.length) {
            var newArray = new int[array.length * 3 / 2 + 1];
            System.arraycopy(array, 0, newArray, 0, array.length - 1);
            array = newArray;
        }
        array[size] = number;
        size++;
    }

    public int get(int index) {
        return array[index];
    }

    public int getSize() {
        return size;
    }
    // END
}
