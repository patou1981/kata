package before;

import before.point.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ScoreBoard {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScoreBoard.class.getName());
    private Player playerA;
    private Player playerB;
    private Player winner;


    public ScoreBoard(Player playerA, Player playerB){
        Objects.requireNonNull(playerA, "Player A must not be null");
        if(!"A".equals(playerA.name())){
            throw new IllegalArgumentException("Player A must have name equals to A");
        }
        Objects.requireNonNull(playerB, "Player B must not be null");
        if(!"B".equals(playerB.name())){
            throw new IllegalArgumentException("Player B must have name equals to B");
        }
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public Player mapCommandToPlayer(String command){
        if("A".equals(command)){
            return playerA;
        }
        else {
            return playerB;
        }
    }
    public void applyCommand(Player pointsWinner){
        Point winnersScore = pointsWinner.score();
        Player looser = pointsWinner.equals(playerA) ? playerB : playerA;
        if(isADecisivePoint(winnersScore, looser))
        {
            winGame(pointsWinner);
        }
        else if(isDeuce(looser, winnersScore)){
            deuce();
        }
        else if(isARegularPoint(looser)) {
            updateNewScore(pointsWinner);
        }
    }

    private static boolean isARegularPoint(Player looser) {
        return looser.score().rank() != 4;
    }

    private static boolean isADecisivePoint(Point winnersScore, Player looser) {
        return winnersScore.rank() >= 3 && winnersScore.rank() - looser.score().rank() > 1;
    }

    private static boolean isDeuce(Player looser, Point winnersScore) {
        return looser.score().isAdvantage() || looser.score().rank() == 3 && winnersScore.rank() == 2;
    }

    private void deuce() {
        this.playerA = Player.of(playerA, Point.forty());
        this.playerB = Player.of(playerB, Point.forty());
        logScore();
    }

    private void updateNewScore(Player pointsWinner) {
        if(pointsWinner.equals(playerA)){
            this.playerA = playerA.wonPoint();
            this.playerB = playerB.lostPoint();
        } else {
            this.playerA = playerA.lostPoint();
            this.playerB = playerB.wonPoint();
        }
        logScore();
    }

    private void logScore() {
        if(playerA.score().isForty() && playerB.score().isForty()){
            LOGGER.info("Deuce");
        }
        else {
            LOGGER.info("Player A : {} / Player B : {}", playerA.score(), playerB.score());
        }
    }

    private void winGame(Player gameWinner) {
        LOGGER.info("Player {} wins the game", gameWinner.name());
        this.winner = gameWinner;
    }

    public Player getWinner() {
        return winner;
    }
}
