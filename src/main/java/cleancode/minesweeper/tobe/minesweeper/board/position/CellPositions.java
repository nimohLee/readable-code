package cleancode.minesweeper.tobe.minesweeper.board.position;

import cleancode.minesweeper.tobe.minesweeper.board.cell.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName    : cleancode.minesweeper.tobe.position
 * fileName       : CellPositions
 * author         : nimoh
 * date           : 2024/10/05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/05        nimoh       최초 생성
 */
public class CellPositions {

    private final List<CellPosition> cellPositions;

    private CellPositions(List<CellPosition> cellPositions) {
        this.cellPositions = cellPositions;
    }

    public static CellPositions of(List<CellPosition> cellPositions) {
        return new CellPositions(cellPositions);
    }

    public static CellPositions from(Cell[][] board) {
        List<CellPosition> cellPositions = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                CellPosition cellPosition = CellPosition.of(row, col);
                cellPositions.add(cellPosition);
            }
        }
        return of(cellPositions);
    }

    public List<CellPosition> extractRandomPositions(int count) {
        List<CellPosition> positions = new ArrayList<>(cellPositions);
        Collections.shuffle(positions);
        return positions.subList(0, count);
    }

    public List<CellPosition> subtract(List<CellPosition> positionListToSubtract) {
        List<CellPosition> cellPositionList = new ArrayList<>(cellPositions);

        CellPositions positionsToSubtract = of(positionListToSubtract);

        return cellPositionList.stream()
                .filter(positionsToSubtract::doesNotContain)
                .toList();
    }

    private boolean doesNotContain(CellPosition position) {
        return !this.cellPositions.contains(position);
    }


    public List<CellPosition> getPositions() {
        return new ArrayList<>(cellPositions);
    }
}
