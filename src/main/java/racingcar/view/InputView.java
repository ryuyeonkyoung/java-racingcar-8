package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.exception.ErrorMessage;

public class InputView {

    public static final String INPUT_INFORMATION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_NUM_INFORMATION = "시도할 횟수는 몇 회인가요?";

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public Cars inputCars() {
        printInputInfo();
        String input = userInput();
        validateDelimiter(input);
        return parseInputToCars(input);
    }

    public int inputTryNum() {
        printInputTryNumInfo();
        String input = userInput();
        return Integer.parseInt(input);
    }

    // ??
    public Cars parseInputToCars(String input) {
        List<Car> cars = Arrays.stream(input.split(","))
                .map(s -> {
                    return Car.of(s, 0);
                }).toList();
        return new Cars(cars);
    }

    private void validateDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_DELIMITER_NOT_CORRECT.getMessage());
        }
    }

    private String userInput() {
        String userInput = Console.readLine().trim();
        validateInput(userInput);
        return userInput;
    }

    private void printInputInfo() {
        System.out.println(INPUT_INFORMATION);
    }

    private void printInputTryNumInfo() {
        System.out.println(INPUT_TRY_NUM_INFORMATION);
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NOT_BLANK.getMessage());
        }
    }
}
