package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapShot;

/**
 * packageName    : cleancode.minesweeper.tobe.io.sign
 * fileName       : CellSignProvidable
 * author         : nimoh
 * date           : 2024/10/05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/05        nimoh       최초 생성
 */
public interface CellSignProvidable {

    boolean supports(CellSnapShot snapShot);

    String provide(CellSnapShot cellSnapShot);

}
