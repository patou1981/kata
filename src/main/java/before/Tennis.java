package before;


import before.point.Point;

import java.util.Optional;

public class Tennis {

    public String play(String sequence) {
        if(sequence == null){
            throw new IllegalArgumentException("The sequence should not be null");
        }
        if(!sequence.matches("[AB]+")){
            throw new IllegalArgumentException("The sequence should contains only A or B values");
        }

        Player playerA = new Player("A", Point.love());
        Player playerB = new Player("B", Point.love());
        final ScoreBoard scoreBoard = new ScoreBoard(
                playerA,
                playerB);
        sequence.chars()
                .mapToObj(ch -> (char) ch)
                .map(Object::toString)
                .map(scoreBoard::mapCommandToPlayer)
                .forEach(scoreBoard::applyCommand);
        return Optional.ofNullable(scoreBoard.getWinner())
                .map(Player::name)
                .orElse(null);
    }



}
