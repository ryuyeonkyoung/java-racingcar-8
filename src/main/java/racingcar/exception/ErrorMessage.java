package racingcar.exception;

public enum ErrorMessage {
    NOT_BLANK_INPUT("입력은 공백일 수 없습니다. 다시 입력해주세요."),
    EXCEPTION_NOT_BLANK("입력은 공백일 수 없습니다."),
    EXCEPTION_CAR_LENGTH_OVERFLOW("자동차 이름은 5자 이하만 가능합니다."),
    EXCEPTION_DELIMITER_NOT_CORRECT("구분자는 쉼표만 사용할 수 있습니다."),
    EXCEPTION_DUPLICATED_CAR_NAME("중복되는 차의 이름이 있습니다.")
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
