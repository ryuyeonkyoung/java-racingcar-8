package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.CarController;

public class Application {
    public static void main(String[] args) {
        CarController carController = AppConfig.createController();
        carController.start();
    }
}
