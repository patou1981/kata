package before.point;

import java.util.Objects;

public sealed class Point implements NextPoint permits Love, Fifteen, Thirty, Forty, Advantage {

    int rank;
    int value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Point winsPoint() {
        return null;
    }

    @Override
    public Point lostPoint() {
        return this;
    }

    public int rank() {
        return rank;
    }

    public boolean isForty(){
        return new Forty().equals(this);
    }

    public boolean isAdvantage() {
        return new Advantage().equals(this);
    }

    public static Point love(){
        return new Love();
    }
    public static Point forty(){
        return new Forty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return rank == point.rank && value == point.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, value);
    }
}
