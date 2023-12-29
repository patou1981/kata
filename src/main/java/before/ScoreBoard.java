package before;

import before.point.Point;

public class ScoreBoard {

    private Point playerAPoints;
    private Point playerBPoints;
    private Player gameWinner;

    public ScoreBoard() {
        playerAPoints = Point.love();
        playerBPoints = Point.love();
        gameWinner = null;
    }

    public Player mapCommandToPlayer(char command) {
        return switch (command) {
            case 'A' -> Player.A;
            case 'B' -> Player.B;
            default -> throw new IllegalArgumentException("Invalid character: " + command);
        };
    }

    public ScoreBoard applyCommand(Player pointsWinner) {
        ScoreTuple scoreTuple = createScoreTuple(pointsWinner);
        if (isADecisivePoint(scoreTuple)) {
            winGame(pointsWinner);
        } else if (isScoreGoingToDeuce(scoreTuple)) {
            deuce();
        } else if (isARegularPoint(scoreTuple.loserScore())) {
            updateNewScore(pointsWinner);
        }
        return this;
    }

    private ScoreTuple createScoreTuple(Player pointsWinner) {
        return switch (pointsWinner) {
            case A -> new ScoreTuple(playerAPoints, playerBPoints);
            case B -> new ScoreTuple(playerBPoints, playerAPoints);
        };
    }

    private static boolean isARegularPoint(Point looser) {
        return looser.rank() != 4;
    }

    private static boolean isADecisivePoint(ScoreTuple scoreTuple) {
        return scoreTuple.winnerScore().rank() >= 3
                && scoreTuple.winnerScore().rank() - scoreTuple.loserScore().rank() > 1;
    }

    private static boolean isScoreGoingToDeuce(ScoreTuple scoreTuple) {
        return scoreTuple.loserScore().isAdvantage()
                || scoreTuple.loserScore().rank() == 3 && scoreTuple.winnerScore().rank() == 2;
    }

    private void deuce() {
        this.playerAPoints = Point.forty();
        this.playerBPoints = Point.forty();
    }

    public boolean isDeuce() {
        return playerAPoints.isForty() && playerBPoints.isForty();
    }

    private void updateNewScore(Player pointsWinner) {
        switch (pointsWinner) {
            case A -> {
                this.playerAPoints = playerAPoints.winsPoint();
                this.playerBPoints = playerBPoints.lostPoint();
            }
            case B -> {
                this.playerAPoints = playerAPoints.lostPoint();
                this.playerBPoints = playerBPoints.winsPoint();
            }
        }
    }


    private void winGame(Player gameWinner) {
        this.gameWinner = gameWinner;
    }

    public Point getPlayerAPoints() {
        return playerAPoints;
    }

    public Point getPlayerBPoints() {
        return playerBPoints;
    }

    public Player getGameWinner() {
        return gameWinner;
    }

    record ScoreTuple(Point winnerScore, Point loserScore) {
    }

}
