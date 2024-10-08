package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.model.*;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final StudyCafePasses studyCafePasses;
    private final StudyCafeLockerPasses studyCafeLockerPasses;

    public StudyCafePassMachine(StudyCafePasses studyCafePasses, StudyCafeLockerPasses studyCafeLockerPasses) {
        this.studyCafePasses = studyCafePasses;
        this.studyCafeLockerPasses = studyCafeLockerPasses;
    }

    public void run() {
        try {
            outputHandler.showInitiateMessages();

            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();
            StudyCafePasses filteredPasses = studyCafePasses.getFilteredByPassType(studyCafePassType);

            outputHandler.showPassListForSelection(filteredPasses);

            StudyCafePass selectedPass = inputHandler.getSelectPass(filteredPasses);

            if (studyCafePassType == StudyCafePassType.FIXED) {
                StudyCafeLockerPass findStudyCafeLockerPass = studyCafeLockerPasses.findSamePassTypeAndDurationWith(selectedPass);

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
