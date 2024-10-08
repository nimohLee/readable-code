package cleancode.studycafe.tobe.model;

public class StudyCafeLockerPass extends StudyCafePass {

    private StudyCafeLockerPass(StudyCafeSeatPassType passType, int duration, int price) {
        super(passType, duration, price);
    }

    public static StudyCafeLockerPass of(StudyCafeSeatPassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    public boolean isSamePassTypeAndDurationWith(StudyCafeSeatPass studyCafeSeatPass) {
        return passType == studyCafeSeatPass.getPassType() && duration == studyCafeSeatPass.getDuration();
    }

}
