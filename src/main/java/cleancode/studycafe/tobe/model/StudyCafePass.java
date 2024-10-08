package cleancode.studycafe.tobe.model;

/**
 * packageName    : cleancode.studycafe.tobe.model
 * fileName       : StudyCafePass
 * author         : nimoh
 * date           : 2024/10/08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/08        nimoh       최초 생성
 */
public abstract class StudyCafePass {

    protected final StudyCafeSeatPassType passType;
    protected final int duration;
    protected final int price;

    protected StudyCafePass(StudyCafeSeatPassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public String display() {
        if (passType == StudyCafeSeatPassType.HOURLY) {
            return String.format("%s시간권 - %d원", duration, price);
        }
        if (passType == StudyCafeSeatPassType.WEEKLY) {
            return String.format("%s주권 - %d원", duration, price);
        }
        if (passType == StudyCafeSeatPassType.FIXED) {
            return String.format("%s주권 - %d원", duration, price);
        }
        return "";
    }

    public StudyCafeSeatPassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }
}
