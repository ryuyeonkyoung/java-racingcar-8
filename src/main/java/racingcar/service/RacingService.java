package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingService {

    public List<Cars> startRacing(int tryNum, Cars cars) {
        List<Cars> history = new ArrayList<>();
        Cars currCars = cars;

        for (int i = 0; i < tryNum; i++) {
            currCars = moveCars(currCars);
            history.add(currCars);
        }

        return history;
    }

    public Cars moveCars(Cars cars) {
        List<Car> newCars = new ArrayList<>();
        for (Car car : cars.getCars()) {
            newCars.add(moveOneCar(car));
        }
        return new Cars(newCars);
    }

    public Car moveOneCar(Car car) {
        if (!canMove()) {
            return car;
        }
        return car.move(car);
    }

    public boolean canMove() {
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum >= 4;
    }
}
