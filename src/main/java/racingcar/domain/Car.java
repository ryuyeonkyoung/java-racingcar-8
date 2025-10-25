package racingcar.domain;

public class Car implements Comparable<Car>{
    private final String name;
    private final int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of (String name, int position) {
        return new Car(name, position);
    }

    @Override
    public int compareTo(Car other) {
        return other.position - this.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
