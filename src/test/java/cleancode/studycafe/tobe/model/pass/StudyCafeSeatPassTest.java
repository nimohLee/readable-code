package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StudyCafeSeatPassTest {

    // cannotUserLocker()는 StudyCafePassType#isNotLockerType의 위임 메서드이기 떄문에 따로 테스트를 하지 않겠다.

    @DisplayName("사물함 이용권의 좌석 이용권을 비교하여 타입과 기간이 모두 동일하면 true를 반환한다.")
    @Test
    void isSameDurationType() {
        // given
        int duration = 1;
        int price = 5000;
        StudyCafePassType passType = StudyCafePassType.FIXED;
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(passType, duration, price);
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(passType, duration, price, 0.1);
        // when
        boolean result = studyCafeSeatPass.isSameDurationType(studyCafeLockerPass);
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("사물함 이용권의 좌석 이용권을 비교하여 타입과 기간이 하나라도 다르면 false를 반환한다.")
    @Test
    void isNotSameDurationType() {
        // given
        int duration = 1;
        int price = 5000;
        StudyCafePassType passType = StudyCafePassType.FIXED;
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(passType, duration, price);
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(passType, 2, price, 0.1);
        // when
        boolean result = studyCafeSeatPass.isSameDurationType(studyCafeLockerPass);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("사물함 이용권의 좌석 이용권을 비교하여 동일하면 true를 반환한다.")
    @Test
    void isSamePassType() {
        // given
        StudyCafePassType passType = StudyCafePassType.FIXED;
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(passType, 2, 5000, 0.1);
        // when
        boolean result = studyCafeSeatPass.isSamePassType(StudyCafePassType.FIXED);
        // then
        assertThat(result).isTrue();
    }

}
