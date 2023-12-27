package before.point;

public final class Fifteen extends Point implements NextPoint {

    public Fifteen(){
        rank = 1;
        value = 15;
    }

    @Override
    public Point winsPoint() {
        return new Thirty();
    }
}
