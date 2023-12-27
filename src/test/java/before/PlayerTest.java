package before;

import before.point.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayerTest {

    @ParameterizedTest(name = "Given this name \"{0}\" should throw IllegalArgumentException}")
    @NullSource
    @ValueSource(strings = {"", "C", "b", "a"})
    void should_throw_illegal_argument_exception_for_invalid_name(String invalidName){
        assertThatThrownBy(() -> new Player(invalidName, Point.forty()))
                .as("Exception is thrown")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The name of the player should be either A or B");
    }

    @Test
    void should_throw_null_pointer_exception_when_no_score_provided(){
        assertThatThrownBy(() -> new Player("A", null))
                .as("Exception is thrown")
                .isInstanceOf(NullPointerException.class);
    }
}
