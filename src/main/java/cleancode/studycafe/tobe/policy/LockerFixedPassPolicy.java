package cleancode.studycafe.tobe.policy;

import cleancode.studycafe.tobe.model.StudyCafeSeatPassType;

/**
 * packageName    : cleancode.studycafe.tobe.policy
 * fileName       : LockerOnlyFixedPassPolicy
 * author         : nimoh
 * date           : 2024/10/09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/09        nimoh       최초 생성
 */
public class LockerFixedPassPolicy implements LockerPolicy {
    @Override
    public boolean isLockerBuyablePassType(StudyCafeSeatPassType studyCafeSeatPassType) {
        return studyCafeSeatPassType == StudyCafeSeatPassType.FIXED;
    }
}
