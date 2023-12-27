package before;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TennisTest {


    private static Stream<Arguments> provideSequence() {
        return Stream.of(
                Arguments.of("AAAA", List.of("Player A : 15 / Player B : 0",
                        "Player A : 30 / Player B : 0",
                        "Player A : 40 / Player B : 0",
                        "Player A wins the game")),
                Arguments.of("AAABBB", List.of("Player A : 15 / Player B : 0",
                        "Player A : 30 / Player B : 0",
                        "Player A : 40 / Player B : 0",
                        "Player A : 40 / Player B : 15",
                        "Player A : 40 / Player B : 30",
                        "Deuce")),
                Arguments.of("AAABBBABABAA", List.of("Player A : 15 / Player B : 0",
                        "Player A : 30 / Player B : 0",
                        "Player A : 40 / Player B : 0",
                        "Player A : 40 / Player B : 15",
                        "Player A : 40 / Player B : 30",
                        "Deuce",
                        "Player A : AD / Player B : 40",
                        "Deuce",
                        "Player A : AD / Player B : 40",
                        "Player A wins the game"))
        );
    }

    @ParameterizedTest(name = "Given this sequence of point {0} should print the score {1}")
    @MethodSource("provideSequence")
    void given_sequence_point_A_should_print_the_proper_score(String sequence, List<String> message) {
        // Given
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger logger = loggerContext.getLogger(ScoreBoard.class);
        var listAppender = new ListAppender<ILoggingEvent>();
        listAppender.setContext(loggerContext);
        listAppender.start();
        logger.addAppender(listAppender);

        // When
        Tennis match = new Tennis();
        match.play(sequence);

        listAppender.stop();

        // Then
        assertThat(listAppender.list)
                .extracting("formattedMessage")
                .containsAll(message);
    }

    @ParameterizedTest(name = "Given this sequence of point {0} player {1} won the game")
    @CsvSource({
            "AAAA, A",
            "BBBB, B"
    }
    )
    void given_who_wins_points_should_return_the_winner(String sequence, String expectedWinner) {
        Tennis match = new Tennis();

        // When
        String winner = match.play(sequence);

        // Then
        assertThat(winner).isEqualTo(expectedWinner);
    }

    @ParameterizedTest(name = "Given this sequence of point {0} should throw IllegalArgumentException")
    @NullSource
    @ValueSource(strings = {
            "",
            "ksldfab"
    }
    )
    void should_throw_illegal_argument_exception_when_sequence_not_valid(String sequence){
        // Given
        Tennis tennis = new Tennis();

        // When
        assertThatThrownBy(() -> tennis.play(sequence))
                .as("Exception is thrown")
                .isInstanceOf(IllegalArgumentException.class);
    }

}
