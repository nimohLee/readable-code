package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StudyCafePassOrderTest {


    @DisplayName("사물함을 포함한 주문의 총 가격을 계산한다.")
    @Test
    void getTotalPrice() {
        // given
        StudyCafePassType passType = StudyCafePassType.FIXED;
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(passType, 1, 10000, 0.1);
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(passType, 1, 1000);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(studyCafeSeatPass, studyCafeLockerPass);
        // when
        int totalPrice = studyCafePassOrder.getTotalPrice();
        // then
        assertThat(totalPrice).isEqualTo(10000);
    }

    @DisplayName("사물함이 없는 경우 주문의 총 가격을 계산한다.")
    @Test
    void getTotalPriceWithoutLockerPass() {
        // given
        StudyCafePassType passType = StudyCafePassType.HOURLY;
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(passType, 1, 10000, 0.1);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(studyCafeSeatPass, null);
        // when
        int totalPrice = studyCafePassOrder.getTotalPrice();
        // then
        assertThat(totalPrice).isEqualTo(9000);
    }
}
