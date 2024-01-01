package before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of('A', Player.A),
                Arguments.of('B', Player.B)
        );
    }

    @ParameterizedTest(name = "Given this sequence of command {0}, expected: {1}")
    @MethodSource("provideTestData")
    void should_return_player_when_given_a_proper_command(char command, Player expectedPlayer) {
        assertThat(Player.valueOf(command)).isEqualTo(expectedPlayer);
    }

    @Test
    void should_thrown_an_exception_when_the_command_is_nor_a_nor_b(){
        assertThatThrownBy(() -> Player.valueOf('c'))
                .as("Exception is thrown")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The provided command is nor A nor B but was: c");
    }
}