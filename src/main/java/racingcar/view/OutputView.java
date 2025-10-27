package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public static final String OUTPUT_INFORMATION = "실행 결과";
    public static final String WINNER_INFORMATION = "최종 우승자 : ";
    public static final String WINNER_DELIMITER = ", ";

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printResults(List<Cars> carsList) {
        System.out.println(OUTPUT_INFORMATION);
        for (Cars cars : carsList) {
            printResult(cars);
        }
        Cars currCars = carsList.getLast();
        printWinners(currCars);
    }

    public void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printPosition(car);
        }
        System.out.println();
    }

    public void printPosition(Car car) {
        System.out.printf(car.getName() + " : ");
        String carStep = "-".repeat(car.getPosition());
        System.out.printf(carStep);
        System.out.println();
    }

    public void printWinners(Cars cars){
        System.out.printf(WINNER_INFORMATION);
        System.out.println(String.join(WINNER_DELIMITER, cars.getWinnerNames()));
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}