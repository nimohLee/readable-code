package cleancode.minesweeper.tobe.minesweeper.io;

import cleancode.minesweeper.tobe.minesweeper.board.GameBoard;

/**
 * packageName    : cleancode.minesweeper.tobe.io
 * fileName       : OutputHanlder
 * author         : nimoh
 * date           : 2024/10/03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/03        nimoh       최초 생성
 */
public interface OutputHandler {
    void showGameStartComments();

    void showBoard(GameBoard board);

    void showGameWinningComment();

    void showGameLosingComment();

    void showCommentForSelectingCell();

    void showCommentForUserAction();

    void showExceptionMessage(Exception e);

    void showSimpleMessage(String message);
}
