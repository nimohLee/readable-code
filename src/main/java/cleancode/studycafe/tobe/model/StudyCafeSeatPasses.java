package cleancode.studycafe.tobe.model;

import java.util.List;

/**
 * packageName    : cleancode.studycafe.tobe.model
 * fileName       : StudyCafePasses
 * author         : nimoh
 * date           : 2024/10/07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/07        nimoh       최초 생성
 */
public class StudyCafeSeatPasses {

    private final List<StudyCafeSeatPass> studyCafeSeatPasses;

    private StudyCafeSeatPasses(List<StudyCafeSeatPass> studyCafeSeatPasses) {
        this.studyCafeSeatPasses = studyCafeSeatPasses;
    }

    public static StudyCafeSeatPasses of(List<StudyCafeSeatPass> studyCafeSeatPasses) {
        return new StudyCafeSeatPasses(studyCafeSeatPasses);
    }

    public StudyCafeSeatPasses getFilteredByPassType(StudyCafeSeatPassType studyCafeSeatPassType) {
        List<StudyCafeSeatPass> studyCafeSeatPassList = studyCafeSeatPasses.stream()
            .filter(studyCafePass -> studyCafePass.isPassTypeOf(studyCafeSeatPassType))
            .toList();
        return of(studyCafeSeatPassList);
    }

    public int size() {
        return studyCafeSeatPasses.size();
    }

    public StudyCafeSeatPass get(int index) {
        return studyCafeSeatPasses.get(index);
    }

}
