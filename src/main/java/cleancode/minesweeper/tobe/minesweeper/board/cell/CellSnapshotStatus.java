package cleancode.minesweeper.tobe.minesweeper.board.cell;

/**
 * packageName    : cleancode.minesweeper.tobe.cell
 * fileName       : CellSnapshotStatus
 * author         : nimoh
 * date           : 2024/10/05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/05        nimoh       최초 생성
 */
public enum CellSnapshotStatus {

    EMPTY("빈 셀"),
    FLAG("깃발"),
    LAND_MINE("지뢰"),
    NUMBER("숫자"),
    UNCHECKED("확인 전"),
    ;

    private final String description;

    CellSnapshotStatus(String description) {
        this.description = description;
    }
}
