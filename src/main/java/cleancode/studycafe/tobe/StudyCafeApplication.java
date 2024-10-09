package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.policy.LockerPolicy;
import cleancode.studycafe.tobe.policy.LockerFixedPassPolicy;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

        LockerPolicy lockerPolicy = new LockerFixedPassPolicy();
        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(studyCafeFileHandler.readStudyCafePasses(), studyCafeFileHandler.readLockerPasses(), lockerPolicy);
        studyCafePassMachine.run();
    }

}
