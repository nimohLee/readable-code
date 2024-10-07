package cleancode.minesweeper.tobe.minesweeper.board.cell;

/**
 * packageName    : cleancode.minesweeper.tobe.cell
 * fileName       : CellState
 * author         : nimoh
 * date           : 2024/10/03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/03        nimoh       최초 생성
 */
public class CellState {

    private boolean isFlagged;
    private boolean isOpened;

    private CellState(boolean isFlagged, boolean isOpened) {
        this.isFlagged = isFlagged;
        this.isOpened = isOpened;
    }

    public static CellState initialize() {
        return new CellState(false, false);
    }

    public void open() {
        this.isOpened = true;
    }

    public void flag() {
        this.isFlagged = true;
    }

    public boolean isChecked() {
        return isFlagged || isOpened;
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public boolean isFlagged() {
        return isFlagged;
    }
}
