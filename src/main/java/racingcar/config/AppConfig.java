package racingcar.config;

import racingcar.controller.CarController;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    private AppConfig() {
    }

    public static CarController createController() {
        return new CarController(InputView.create(), OutputView.create(), createService());
    }

    public static CarService createService() {
        return new CarService();
    }
}
