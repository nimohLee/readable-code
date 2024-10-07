package cleancode.minesweeper.tobe.gamelevel;

/**
 * packageName    : cleancode.minesweeper.tobe.gamelevl
 * fileName       : VeryBeginner
 * author         : nimoh
 * date           : 2024/10/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/01        nimoh       최초 생성
 */
public class Advanced implements GameLevel {

  @Override
  public int getRowSize() {
    return 120;
  }

  @Override
  public int getColSize() {
    return 124;
  }

  @Override
  public int getLandMineCount() {
    return 9;
  }

}