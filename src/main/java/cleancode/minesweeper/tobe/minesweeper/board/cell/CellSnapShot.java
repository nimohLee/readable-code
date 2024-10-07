package cleancode.minesweeper.tobe.minesweeper.board.cell;

import java.util.Objects;

/**
 * packageName    : cleancode.minesweeper.tobe.cell
 * fileName       : CellSnapShot
 * author         : nimoh
 * date           : 2024/10/05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/10/05        nimoh       최초 생성
 */
public class CellSnapShot {

    private final CellSnapshotStatus status;
    private final int nearbyLandMineCount;

    private CellSnapShot(CellSnapshotStatus status, int nearbyLandMineCount) {
        this.status = status;
        this.nearbyLandMineCount = nearbyLandMineCount;
    }

    public static CellSnapShot of(CellSnapshotStatus snapshotStatus, int nearbyLandMineCount) {
        return new CellSnapShot(snapshotStatus, nearbyLandMineCount);
    }

    public static CellSnapShot ofEmpty() {
        return of(CellSnapshotStatus.EMPTY, 0);
    }

    public static CellSnapShot ofFlag() {
        return of(CellSnapshotStatus.FLAG, 0);
    }

    public static CellSnapShot ofLandMine() {
        return of(CellSnapshotStatus.LAND_MINE, 0);
    }

    public static CellSnapShot ofNumber(int nearbyLandMineCount) {
        return of(CellSnapshotStatus.NUMBER, nearbyLandMineCount);
    }

    public static CellSnapShot ofUnchecked() {
        return of(CellSnapshotStatus.UNCHECKED, 0);
    }

    public CellSnapshotStatus getStatus() {
        return status;
    }

    public int getNearbyLandMineCount() {
        return nearbyLandMineCount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CellSnapShot snapShot = (CellSnapShot) object;
        return getNearbyLandMineCount() == snapShot.getNearbyLandMineCount() && getStatus() == snapShot.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getNearbyLandMineCount());
    }

    public boolean isSameStatus(CellSnapshotStatus cellSnapshotStatus) {
        return this.status == cellSnapshotStatus;
    }
}
