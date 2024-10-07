package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapShot;

import java.util.List;

/**
 * packageName    : cleancode.minesweeper.tobe.io.sign
 * fileName       : CellSignFinder
 * author         : nimoh
 * date           : 2024/10/05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/05        nimoh       최초 생성
 */
public class CellSignFinder {

    private static final List<CellSignProvidable> CELL_SIGN_PROVIDERS = List.of(
            new EmptyCellSignProvider(),
            new FlagCellSignProvider(),
            new LandMineCellSignProvider(),
            new NumberCellSignProvider(),
            new UncheckedCellSignProvider()
    );

    public String findCellSignFrom(CellSnapShot snapShot) {
        return CELL_SIGN_PROVIDERS.stream()
                .filter(provider -> provider.supports(snapShot))
                .findFirst()
                .map(provider -> provider.provide(snapShot))
                .orElseThrow(() -> new IllegalArgumentException("확인할 수 없는 셀입니다."));
    }
}
