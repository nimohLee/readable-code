package cleancode.minesweeper.tobe.minesweeper.board.cell;

import java.util.Arrays;
import java.util.List;

/**
 * packageName    : cleancode.minesweeper.tobe.cell
 * fileName       : Cells
 * author         : nimoh
 * date           : 2024/10/05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/05        nimoh       최초 생성
 */
public class Cells {

    private final List<Cell> cells;

    private Cells(List<Cell> cells) {
        this.cells = cells;
    }

    public static Cells of(List<Cell> cells) {
        return new Cells(cells);
    }

    public static Cells from(Cell[][] cells) {
        List<Cell> cellList = Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .toList();

        return of(cellList);
    }

    public boolean isAllChecked() {
        return cells.stream()
                .allMatch(Cell::isChecked);
    }
}
