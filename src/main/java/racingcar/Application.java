package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = AppConfig.createController();
        racingController.start();
    }
}
