package before.point;

public final class Love extends Point implements NextPoint {

    public Love(){
        this.rank = 0;
        this.value = 0;
    }

    @Override
    public Point winsPoint() {
        return new Fifteen();
    }

}
