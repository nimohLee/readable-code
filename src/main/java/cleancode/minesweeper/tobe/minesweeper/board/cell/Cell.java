package cleancode.minesweeper.tobe.minesweeper.board.cell;

/**
 * packageName    : cleancode.minesweeper.tobe
 * fileName       : Cell
 * author         : nimoh
 * date           : 2024/10/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/01        nimoh       최초 생성
 */
public interface Cell {


    void open();

    void flag();

    boolean isChecked();

    boolean isLandMine();

    boolean isOpened();

    boolean hasLandMineCount();

    CellSnapShot getSnapshot();
}
