package before;


import before.point.Point;

import java.util.Objects;

public record Player(String name, Point score) {

    public Player{
        Objects.requireNonNull(score);
        if(name == null || name.isBlank() || !("A".equals(name) || "B".equals(name))){
            throw new IllegalArgumentException("The name of the player should be either A or B");
        }
    }

    public Player wonPoint(){
        return of(this, score.winsPoint());
    }

    public Player lostPoint(){
        return of(this, score.lostPoint());
    }

    public static Player of(Player player, Point score) {
        return new Player(player.name(), score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(score, player.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}

