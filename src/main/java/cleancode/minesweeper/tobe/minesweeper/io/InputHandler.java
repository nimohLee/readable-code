package cleancode.minesweeper.tobe.minesweeper.io;

import cleancode.minesweeper.tobe.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.tobe.minesweeper.user.UserAction;

/**
 * packageName    : cleancode.minesweeper.tobe.io
 * fileName       : InputHandler
 * author         : nimoh
 * date           : 2024/10/03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/03        nimoh       최초 생성
 */
public interface InputHandler {

    UserAction getUserActionFromUser();

    CellPosition getCellPositionFromUser();
}
