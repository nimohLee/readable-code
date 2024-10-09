package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.model.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.StudyCafeSeatPassType;
import cleancode.studycafe.tobe.model.StudyCafeSeatPasses;

import java.util.Scanner;

public class InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    public StudyCafeSeatPassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();

        return StudyCafeSeatPassType.findByUserInput(userInput);
    }

    public StudyCafeSeatPass getSelectPass(StudyCafeSeatPasses passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = Integer.parseInt(userInput) - 1;
        StudyCafeSeatPass studyCafeSeatPass = passes.get(selectedIndex);

        if (studyCafeSeatPass == null) {
            throw new IllegalArgumentException("알 수 없는 이용권입니다.");
        }

        return studyCafeSeatPass;
    }

    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return "1".equals(userInput);
    }

}
