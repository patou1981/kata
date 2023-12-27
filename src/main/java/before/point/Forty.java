package before.point;

public final class Forty extends Point implements NextPoint {
    public Forty() {
        rank = 3;
        value = 40;
    }

    @Override
    public Point winsPoint() {
        return new Advantage();
    }
}
