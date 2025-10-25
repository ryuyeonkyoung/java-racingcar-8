package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.exception.ErrorMessage;

public class InputView {

    public static final String INPUT_INFORMATION = "입력 문구 : ";

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String inputCars() {
        printInputInfo();
        String input = userInput();
        Cars cars = parseInputToCars(input);
        return input;
    }

    // ??
    public Cars parseInputToCars(String input) {
        validateDelimiter(input);
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
        System.out.print(INPUT_INFORMATION);
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NOT_BLANK.getMessage());
        }
    }
}
