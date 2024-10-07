package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();
    private final List<StudyCafePass> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        try {
            outputHandler.showInitiateMessages();

            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();
            List<StudyCafePass> passes = getFilteredPassesByPassType(studyCafePassType);

            outputHandler.showPassListForSelection(passes);
            StudyCafePass selectedPass = inputHandler.getSelectPass(passes);

            if (studyCafePassType == StudyCafePassType.FIXED) {
                List<StudyCafeLockerPass> lockerPasses = studyCafeFileHandler.readLockerPasses();

                lockerPasses.stream()
                    .filter(lockerPass ->
                        lockerPass.getPassType() == selectedPass.getPassType()
                            && lockerPass.getDuration() == selectedPass.getDuration()
                    )
                    .findFirst()
                    .ifPresent(lockerPass -> {
                        outputHandler.askLockerPass(lockerPass);
                        if (inputHandler.getLockerSelection()) {
                            outputHandler.showPassOrderSummary(selectedPass, lockerPass);
                        }
                    });
            }

            outputHandler.showPassOrderSummary(selectedPass, null);

            throw new IllegalArgumentException("알 수 없는 이용권 타입입니다.");
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private List<StudyCafePass> getFilteredPassesByPassType(StudyCafePassType studyCafePassType) {
        return studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.isPassTypeOf(studyCafePassType))
            .toList();
    }

}
