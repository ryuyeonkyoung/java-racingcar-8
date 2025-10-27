package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.exception.ErrorMessage;

public class Cars{
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarNameLength(cars);
        validateDuplicateCarName(cars);
        this.cars = List.copyOf(cars);
    }

    private void validateCarNameLength(List<Car> cars) {
        for (Car car : cars ) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.EXCEPTION_CAR_LENGTH_OVERFLOW.getMessage());
            }
        }
    }

    private void validateDuplicateCarName(List<Car> cars) {

        long distinctCarLength = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        boolean isCarDupl = cars.size() == distinctCarLength;

        if (!isCarDupl) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_DUPLICATED_CAR_NAME.getMessage());
        }


    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public List<Car> getWinners() {
        if (cars.isEmpty()) return List.of();
        int max = getMaxPosition();
        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .toList();
    }

    public List<String> getWinnerNames() {
        return getWinners().stream().map(Car::getName).toList();
    }

    public List<String> toDisplayLines() {
        return cars.stream()
                .map(c -> c.getName() + " : " + "-".repeat(c.getPosition()))
                .toList();
    }

}