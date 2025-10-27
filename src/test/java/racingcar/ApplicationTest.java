package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 단독_우승자_기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_5차_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,cdefghijklm", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @Test
    void 자동차_중복_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,a,c", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 중복되는 차의 이름이 있습니다.")
        );
    }

    @Test
    void 시도_횟수_비정수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c", "문자열"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 정수가 아닌 값이 입력되었습니다.")
        );
    }

    @Test
    void 자동차_개수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 자동차는 2대 이상 필요합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
