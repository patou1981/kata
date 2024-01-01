package before;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;

public class Tennis {

    private static final Logger LOGGER = LoggerFactory.getLogger(Tennis.class.getName());

    public Optional<Player> play(String sequence) {
        if (sequence == null) {
            throw new IllegalArgumentException("The sequence should not be null");
        }
        if (!sequence.matches("[AB]+")) {
            throw new IllegalArgumentException("The sequence should contains only A or B values");
        }

        final ScoreBoard scoreBoard = new ScoreBoard();
        return sequence.chars()
                .mapToObj(ch -> (char) ch)
                .map(Player::valueOf)
                .map(scoreBoard::applyCommand)
                .map(this::logScore)
                .map(ScoreBoard::getGameWinner)
                .filter(Objects::nonNull)
                .findFirst();
    }


    private ScoreBoard logScore(ScoreBoard scoreBoard) {
        if(scoreBoard.isDeuce()){
            LOGGER.info("Deuce");
        } else if (scoreBoard.getGameWinner() != null) {
            LOGGER.info("Player {} wins the game", scoreBoard.getGameWinner());
        } else {
            LOGGER.info("Player A : {} / Player B : {}", scoreBoard.getPlayerAPoints(), scoreBoard.getPlayerBPoints());
        }
        return scoreBoard;
    }


}
