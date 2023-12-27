package before.point;

public final class Advantage extends Point implements NextPoint {
    public Advantage() {
        rank = 5;
        value = 40;
    }

    @Override
    public String toString() {
        return "AD";
    }

    @Override
    public Point winsPoint() {
        return new Love();
    }

    @Override
    public Point lostPoint() {
        return new Forty();
    }
}
