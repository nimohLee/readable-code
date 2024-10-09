package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.StudyCafeIOHandler;
import cleancode.studycafe.tobe.model.*;
import cleancode.studycafe.tobe.policy.LockerPolicy;

public class StudyCafePassMachine {

    private final StudyCafeIOHandler ioHandler = new StudyCafeIOHandler();
    private final StudyCafeSeatPasses allStudyCafeSeatPasses;
    private final StudyCafeLockerPasses allStudyCafeLockerPasses;
    private final LockerPolicy lockerPolicy;

    public StudyCafePassMachine(StudyCafeSeatPasses allStudyCafeSeatPasses, StudyCafeLockerPasses allStudyCafeLockerPasses, LockerPolicy lockerPolicy) {
        this.allStudyCafeSeatPasses = allStudyCafeSeatPasses;
        this.allStudyCafeLockerPasses = allStudyCafeLockerPasses;
        this.lockerPolicy = lockerPolicy;
    }

    public void run() {
        try {
            ioHandler.showInitiateMessages();

            StudyCafeSeatPassType studyCafeSeatPassType = ioHandler.getPassTypeSelectingUserAction();
            StudyCafeSeatPasses filteredPasses = allStudyCafeSeatPasses.getFilteredByPassType(studyCafeSeatPassType);

            ioHandler.showPassListForSelection(filteredPasses);

            StudyCafeSeatPass selectedPass = ioHandler.getSelectPass(filteredPasses);

            if (lockerPolicy.isLockerBuyablePassType(studyCafeSeatPassType)) {
                StudyCafeLockerPass findStudyCafeLockerPass = allStudyCafeLockerPasses.findSamePassTypeAndDurationWith(selectedPass);

                ioHandler.askLockerPass(findStudyCafeLockerPass);
                if (ioHandler.getLockerSelection()) {
                    ioHandler.showPassOrderSummary(selectedPass, findStudyCafeLockerPass);
                }
            }

            ioHandler.showPassOrderSummary(selectedPass, null);
        } catch (AppException e) {
            ioHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            ioHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

}
