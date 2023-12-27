package before.point;

public sealed interface NextPoint permits Point, Love, Fifteen, Thirty, Forty, Advantage {
    Point winsPoint();

    Point lostPoint();
}
