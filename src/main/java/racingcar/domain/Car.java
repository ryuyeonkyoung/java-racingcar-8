package racingcar.domain;

public class Car implements Comparable<Car>{
    private final String name;
    private final int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of (String name) {
        return new Car(name, 0);
    }

    @Override
    public int compareTo(Car other) {
        return other.position - this.position;
    }

    int getPosition() {
        return position;
    }

    String getName() {
        return name;
    }

    public Car move(Car car) {
        return new Car(name, position + 1);
    }
}
