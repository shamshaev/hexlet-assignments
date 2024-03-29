package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + getFloor() + " этаже";
    }

    @Override
    public int compareTo(Home another) {
        if (getArea() < another.getArea()) {
            return -1;
        } else if (getArea() > another.getArea()) {
            return 1;
        } else {
            return 0;
        }
    }
}
// END
