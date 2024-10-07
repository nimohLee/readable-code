package cleancode.minesweeper.tobe.minesweeper.user;

/**
 * packageName    : cleancode.minesweeper.tobe.user
 * fileName       : UserAction
 * author         : nimoh
 * date           : 2024/10/05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/05        nimoh       최초 생성
 */
public enum UserAction {

    OPEN("셀 열기"),
    FLAG("깃발 꽂기"),
    UNKNOWN("알 수 없음");

    private final String description;

    UserAction(String description) {
        this.description = description;
    }
}
