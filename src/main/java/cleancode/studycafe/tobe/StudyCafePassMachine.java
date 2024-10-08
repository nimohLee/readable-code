package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.model.*;
import cleancode.studycafe.tobe.policy.LockerPolicy;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
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
            outputHandler.showInitiateMessages();

            StudyCafeSeatPassType studyCafeSeatPassType = inputHandler.getPassTypeSelectingUserAction();
            StudyCafeSeatPasses filteredPasses = allStudyCafeSeatPasses.getFilteredByPassType(studyCafeSeatPassType);

            outputHandler.showPassListForSelection(filteredPasses);

            StudyCafeSeatPass selectedPass = inputHandler.getSelectPass(filteredPasses);

            if (lockerPolicy.isLockerBuyablePassType(studyCafeSeatPassType)) {
                StudyCafeLockerPass findStudyCafeLockerPass = allStudyCafeLockerPasses.findSamePassTypeAndDurationWith(selectedPass);

                outputHandler.askLockerPass(findStudyCafeLockerPass);
                if (inputHandler.getLockerSelection()) {
                    outputHandler.showPassOrderSummary(selectedPass, findStudyCafeLockerPass);
                }
            }

            outputHandler.showPassOrderSummary(selectedPass, null);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

}
