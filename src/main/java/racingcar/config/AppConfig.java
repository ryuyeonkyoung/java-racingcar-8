package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    private AppConfig() {
    }

    public static RacingController createController() {
        return new RacingController(InputView.create(), OutputView.create(), createService());
    }

    public static RacingService createService() {
        return new RacingService();
    }
}
