package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.model.*;

public class StudyCafePassMachine {

    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        try {
            outputHandler.showInitiateMessages();

            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();
            StudyCafePasses filteredPasses = StudyCafePasses.ofPassType(studyCafeFileHandler.readStudyCafePasses(), studyCafePassType);

            outputHandler.showPassListForSelection(filteredPasses);

            StudyCafePass selectedPass = inputHandler.getSelectPass(filteredPasses);

            if (selectedPass == null) {
                throw new IllegalArgumentException("알 수 없는 이용권입니다.");
            }

            if (studyCafePassType == StudyCafePassType.FIXED) {
                StudyCafeLockerPasses lockerPasses = studyCafeFileHandler.readLockerPasses();
                StudyCafeLockerPass findStudyCafeLockerPass = lockerPasses.findSamePassTypeAndDurationWith(selectedPass);

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
