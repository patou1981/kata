package before.point;

public final class Thirty extends Point implements NextPoint {
    public Thirty() {
        rank = 2;
        value = 30;
    }

    @Override
    public Point winsPoint() {
        return new Forty();
    }
}
