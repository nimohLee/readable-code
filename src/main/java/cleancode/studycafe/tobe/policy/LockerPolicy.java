package cleancode.studycafe.tobe.policy;

import cleancode.studycafe.tobe.model.StudyCafeSeatPassType;

/**
 * packageName    : cleancode.studycafe.tobe
 * fileName       : LockerBuyablePolicy
 * author         : nimoh
 * date           : 2024/10/09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/09        nimoh       최초 생성
 */
@FunctionalInterface
public interface LockerPolicy {
    boolean isLockerBuyablePassType(StudyCafeSeatPassType studyCafeSeatPassType);
}
