package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.StudyCafeSeatPassType;
import cleancode.studycafe.tobe.model.StudyCafeSeatPasses;

/**
 * packageName    : cleancode.studycafe.tobe.io
 * fileName       : StudyCafeIOHandler
 * author         : nimoh
 * date           : 2024/10/09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/09        nimoh       최초 생성
 */
public class StudyCafeIOHandler {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public StudyCafeSeatPassType getPassTypeSelectingUserAction() {
        return inputHandler.getPassTypeSelectingUserAction();
    }

    public StudyCafeSeatPass getSelectPass(StudyCafeSeatPasses passes) {
       return inputHandler.getSelectPass(passes);
    }

    public boolean getLockerSelection() {
        return inputHandler.getLockerSelection();
    }

    public void showInitiateMessages() {
        outputHandler.showInitiateMessages();
    }

    public void showPassListForSelection(StudyCafeSeatPasses passes) {
       outputHandler.showPassListForSelection(passes);
    }

    public void askLockerPass(StudyCafeLockerPass lockerPass) {
        outputHandler.askLockerPass(lockerPass);
    }

    public void showPassOrderSummary(StudyCafeSeatPass selectedPass, StudyCafeLockerPass lockerPass) {
        outputHandler.showPassOrderSummary(selectedPass, lockerPass);
    }

    public void showSimpleMessage(String message) {
        outputHandler.showSimpleMessage(message);
    }
}
