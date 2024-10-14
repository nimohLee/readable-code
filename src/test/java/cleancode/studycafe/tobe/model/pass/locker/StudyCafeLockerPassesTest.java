package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class StudyCafeLockerPassesTest {

    @DisplayName("스터디 카페 좌석 이용권과 기간, 좌석 타입이 동일한 사물함 이용권을 찾아준다.")
    @Test
    void findLockerPassBy() {
        // given

        StudyCafePassType targetPassType = StudyCafePassType.FIXED;
        StudyCafeSeatPass targetSeatPass = StudyCafeSeatPass.of(targetPassType, 1, 5000, 0.1);
        StudyCafeLockerPass targetLockerPass = StudyCafeLockerPass.of(targetPassType, 1, 6000);

        StudyCafeLockerPasses studyCafeLockerPasses = StudyCafeLockerPasses.of(List.of(
            targetLockerPass,
            StudyCafeLockerPass.of(targetPassType, 2, 6000),
            StudyCafeLockerPass.of(StudyCafePassType.HOURLY, 1, 7000)
        ));
        // when
        Optional<StudyCafeLockerPass> optionalResults = studyCafeLockerPasses.findLockerPassBy(targetSeatPass);
        // then
        assertThat(optionalResults.get()).isEqualTo(targetLockerPass);
        ;
    }
}
