package cleancode.studycafe.tobe.model;

import java.util.List;

/**
 * packageName    : cleancode.studycafe.tobe.model
 * fileName       : StudyCafeLockerPasses
 * author         : nimoh
 * date           : 2024/10/08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/08        nimoh       최초 생성
 */
public class StudyCafeLockerPasses {

    private final List<StudyCafeLockerPass> lockerPasses;

    private StudyCafeLockerPasses(List<StudyCafeLockerPass> lockerPasses) {
        this.lockerPasses = lockerPasses;
    }

    public static StudyCafeLockerPasses of(List<StudyCafeLockerPass> lockerPasses) {
        return new StudyCafeLockerPasses(lockerPasses);
    }

    public StudyCafeLockerPass findSamePassTypeAndDurationWith(StudyCafeSeatPass studyCafeSeatPass) {
        return lockerPasses.stream()
            .filter(lockerPass ->
                lockerPass.isSamePassTypeAndDurationWith(studyCafeSeatPass))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당하는 스터디카페 사물함 사용권이 없습니다."));
    }
}
