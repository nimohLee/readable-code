package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.io.StudyCafeFileHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(studyCafeFileHandler.readStudyCafePasses(), studyCafeFileHandler.readLockerPasses());
        studyCafePassMachine.run();
    }

}
