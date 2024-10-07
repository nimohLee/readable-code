package cleancode.minesweeper.tobe.minesweeper.board;

/**
 * packageName    : cleancode.minesweeper.tobe
 * fileName       : GameStatus
 * author         : nimoh
 * date           : 2024/10/07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/07        nimoh       최초 생성
 */
public enum GameStatus {

    IN_PROGRESS("진행중"),
    WIN("승리"),
    LOSE("패배"),
    ;

    private final String description;

    GameStatus(String description) {
        this.description = description;
    }

}
