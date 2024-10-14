package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StudyCafeSeatPassesTest {

    @DisplayName("특정 스터디 카페 이용권 타입을 찾아준다.")
    @Test
    void findPassBy() {
        // given
        StudyCafeSeatPasses studyCafeSeatPasses = StudyCafeSeatPasses.of(List.of(
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 1, 1000, 0.1),
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 2, 2000, 0.2),
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 3, 3000, 0.3),
            StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 4, 4000, 0.4)
        ));
        // when
        List<StudyCafeSeatPass> passes = studyCafeSeatPasses.findPassBy(StudyCafePassType.HOURLY);
        // then
        assertThat(passes).hasSize(2)
            .extracting("passType", "duration", "price", "discountRate")
            .containsExactlyInAnyOrder(
                tuple(StudyCafePassType.HOURLY, 1, 1000, 0.1),
                tuple(StudyCafePassType.HOURLY, 2, 2000, 0.2)
            )
        ;
    }
}
