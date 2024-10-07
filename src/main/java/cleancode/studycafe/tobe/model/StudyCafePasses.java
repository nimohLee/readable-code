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
public class StudyCafePasses {

    private final List<StudyCafePass> studyCafePasses;

    private StudyCafePasses(List<StudyCafePass> studyCafePasses) {
        this.studyCafePasses = studyCafePasses;
    }

    public static StudyCafePasses of(List<StudyCafePass> studyCafePasses) {
        return new StudyCafePasses(studyCafePasses);
    }

    public static StudyCafePasses ofPassType(List<StudyCafePass> studyCafePasses, StudyCafePassType studyCafePassType) {
        List<StudyCafePass> passes = getFilteredPassesByPassType(studyCafePasses, studyCafePassType);
        return of(passes);
    }

    private static List<StudyCafePass> getFilteredPassesByPassType(List<StudyCafePass> studyCafePasses, StudyCafePassType studyCafePassType) {
        return studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.isPassTypeOf(studyCafePassType))
            .toList();
    }

    public int size() {
        return studyCafePasses.size();
    }

    public StudyCafePass get(int index) {
        return studyCafePasses.get(index);
    }
}
