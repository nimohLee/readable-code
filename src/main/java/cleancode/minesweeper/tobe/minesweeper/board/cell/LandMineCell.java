package cleancode.minesweeper.tobe.minesweeper.board.cell;

/**
 * packageName    : cleancode.minesweeper.tobe.cell
 * fileName       : LandMineCell
 * author         : nimoh
 * date           : 2024/10/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/01        nimoh       최초 생성
 */
public class LandMineCell implements Cell {

    private static final CellState cellState = CellState.initialize();

    @Override
    public void open() {
        cellState.open();
    }

    @Override
    public void flag() {
        cellState.flag();
    }

    @Override
    public boolean isChecked() {
        return cellState.isFlagged();
    }

    @Override
    public boolean isLandMine() {
        return true;
    }

    @Override
    public boolean isOpened() {
        return cellState.isOpened();
    }

    @Override
    public boolean hasLandMineCount() {
        return false;
    }

    @Override
    public CellSnapShot getSnapshot() {
        if (cellState.isOpened()) {
            return CellSnapShot.ofLandMine();
        }
        if (cellState.isFlagged()) {
            return CellSnapShot.ofFlag();
        }
        return CellSnapShot.ofUnchecked();
    }
}
