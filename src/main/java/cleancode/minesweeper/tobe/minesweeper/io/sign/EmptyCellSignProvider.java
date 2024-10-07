package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapShot;
import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshotStatus;

/**
 * packageName    : cleancode.minesweeper.tobe.io.sign
 * fileName       : EmptyCellSignProvider
 * author         : nimoh
 * date           : 2024/10/05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/05        nimoh       최초 생성
 */
public class EmptyCellSignProvider implements CellSignProvidable {

    private static final String EMPTY_SIGN = "■";

    @Override
    public boolean supports(CellSnapShot snapShot) {
        return snapShot.isSameStatus(CellSnapshotStatus.EMPTY);
    }

    @Override
    public String provide(CellSnapShot cellSnapShot) {
        return EMPTY_SIGN;
    }

}
