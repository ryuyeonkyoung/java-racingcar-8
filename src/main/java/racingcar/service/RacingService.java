package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

//### 자동차 경주
//- [ ] 주어진 횟수 동안 n대의 자동차의 전진 또는 멈춤 여부를 결정한다.
//        - [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
// - [ ] 전진 또는 멈춤 여부에 따라 차를 움직인다.
public class RacingService {

    public List<Cars> startRacing(int tryNum, Cars cars) {
        List<Cars> carsHistory = new ArrayList<>();
        Cars nextLevelCars = null;

        for (int i = 0; i < tryNum; i++) {
            carsHistory.add(moveCars(cars));
        }

        return carsHistory;
    }

    // TODO: Cars 책임 검토
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
        return new Car(car.getName(), car.getPosition() + 1);
    }

    public boolean canMove() {
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum >= 4;
    }
}
