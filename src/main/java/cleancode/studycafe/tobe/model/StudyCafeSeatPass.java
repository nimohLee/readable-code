package cleancode.studycafe.tobe.model;

public class StudyCafeSeatPass extends StudyCafePass {

    private final double discountRate;

    private StudyCafeSeatPass(StudyCafeSeatPassType passType, int duration, int price, double discountRate) {
        super(passType, duration, price);
        this.discountRate = discountRate;
    }

    public static StudyCafeSeatPass of(StudyCafeSeatPassType passType, int duration, int price, double discountRate) {
        return new StudyCafeSeatPass(passType, duration, price, discountRate);
    }

    public boolean isPassTypeOf(StudyCafeSeatPassType passType) {
        return this.passType == passType;
    }

    public double getDiscountRate() {
        return discountRate;
    }

}
