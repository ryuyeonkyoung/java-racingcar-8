package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;

    public CarController(InputView inputView, OutputView outputView, CarService carService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carService = carService;
    }

    public void start() {
        String input = inputView.inputCars();
        Cars cars = inputView.parseInputToCars(input);
    }
}
