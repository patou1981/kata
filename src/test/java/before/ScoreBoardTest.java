package before;

import before.point.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ScoreBoardTest {

    @Test
    void should_throw_null_pointer_exception_when_player_a_is_null(){
        assertThatThrownBy(() -> new ScoreBoard(null, new Player("B", Point.love())))
                .as("Exception is thrown")
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Player A must not be null");
    }

    @Test
    void player_a_should_have_name_a(){
        assertThatThrownBy(() -> new ScoreBoard(
                new Player("B", Point.love()),
                new Player("B", Point.love())))
                .as("Exception is thrown")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Player A must have name equals to A");

    }

    @Test
    void should_throw_null_pointer_exception_when_player_b_is_null(){
        assertThatThrownBy(() -> new ScoreBoard( new Player("A", Point.love()), null))
                .as("Exception is thrown")
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Player B must not be null");
    }

    @Test
    void player_a_should_have_name_b(){
        assertThatThrownBy(() -> new ScoreBoard(
                new Player("A", Point.love()),
                new Player("A", Point.love())))
                .as("Exception is thrown")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Player B must have name equals to B");

    }

}