package cleancode.minesweeper.tobe.minesweeper.io;

import cleancode.minesweeper.tobe.minesweeper.exception.GameException;

/**
 * packageName    : cleancode.minesweeper.tobe
 * fileName       : BoardIndexConvertor
 * author         : nimoh
 * date           : 2024/10/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/01        nimoh       최초 생성
 */
public class BoardIndexConvertor {

    private static final char BASE_CHAR_FOR_COL = 'a';

    public int getSelectedRowIndex(String cellInput) {
        String cellInputRow = cellInput.substring(1);
        return convertRowFrom(cellInputRow);
    }

    public int getSelectedColIndex(String cellInput) {
        char cellInputCol = cellInput.charAt(0);
        return convertColFrom(cellInputCol);
    }

    private int convertRowFrom(String cellInputRow) {
        int rowIndex = Integer.parseInt(cellInputRow) - 1;
        if (rowIndex < 0) {
            throw new GameException("잘못된 입력입니다.");
        }
        return rowIndex;
    }

    private int convertColFrom(char cellInputCol) {
        int colIndex = cellInputCol - BASE_CHAR_FOR_COL;
        if (colIndex < 0) {
            throw new GameException("잘못된 입력입니다.");
        }

        return colIndex;
    }
}
