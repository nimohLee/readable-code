package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StudyCafePassTypeTest {

    @DisplayName("사물함을 사용할 수 있는 스터디카페 이용권이면 true를 반환한다.")
    @Test
    void isLockerType() {
        // given
        // 요구사항이 변할 수도 있는 부분이기 때문에 기존 로직이 마음에 들지 않음. 수정 해도 되나..?
        StudyCafePassType passType = StudyCafePassType.FIXED;
        // when
        boolean result = passType.isLockerType();
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("사물함을 사용할 수 없는 스터디카페 이용권이면 true를 반환한다.")
    @Test
    void isNotLockerType() {
        // given
        StudyCafePassType passType = StudyCafePassType.HOURLY;
        // when
        boolean result = passType.isNotLockerType();
        // then
        assertThat(result).isTrue();
    }

}
