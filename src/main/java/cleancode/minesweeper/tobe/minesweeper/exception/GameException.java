package cleancode.minesweeper.tobe.minesweeper.exception;

/**
 * packageName    : cleancode.minesweeper.tobe
 * fileName       : AppException
 * author         : nimoh
 * date           : 2024/09/30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/09/30        nimoh       최초 생성
 */
public class GameException extends RuntimeException {

    public GameException(String message) {
        super(message);
    }
}
