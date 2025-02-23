package com.mylab.techLab.week6_junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
    V1 -> V2
    1. @DisplayName 추가
    2. -1에 대해 Exception 변경 및 예외 케이스 변경 및 메세지 검증 추가
    3. @BeforeEach 추가
 */
class NumberBaseballTestV2 {

    @Test
    @DisplayName("숫자와 위치가 전부 동일한 경우")
    void testAllDigitsAndPositionsMatch() {
        assertFinishBaseballGame("142", "142", 3, 0);
    }

    @Test
    @DisplayName("중복된 숫자가 들어갈 경우 예외를 반환한다 SSS")
    void testExceptionForDuplicateDigits_SSS() {
        exceptionBaseballGame("142", "333", "중복된 숫자가 존재합니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 들어갈 경우 예외를 반환한다 SNS")
    void testExceptionForDuplicateDigits_SNS() {
        exceptionBaseballGame("142", "323", "중복된 숫자가 존재합니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 들어갈 경우 예외를 반환한다 SSN")
    void testExceptionForDuplicateDigits_SSN() {
        exceptionBaseballGame("142", "332", "중복된 숫자가 존재합니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 들어갈 경우 예외를 반환한다 NSS")
    void testExceptionForDuplicateDigits_NSS() {
        exceptionBaseballGame("142", "233", "중복된 숫자가 존재합니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 다른 문자가 들어올 경우 예외를 반환한다")
    void testExceptionForNonDigitInput() {
        exceptionBaseballGame("142", "a33", "올바르지 않은 번호입니다.");
    }

    @Test
    @DisplayName("빈 공백이 들어오는 경우 예외를 반환한다")
    void testExceptionForEmptyInput() {
        exceptionBaseballGame("142", "", "올바르지 않은 번호입니다.");
    }

    @Test
    @DisplayName("한 자리의 수만 들어오는 경우 예외를 반환한다")
    void testExceptionForSingleDigitInput() {
        exceptionBaseballGame("142", "1", "숫자의 길이를 3자리로 입력해주세요.");
    }

    @Test
    @DisplayName("두 자리의 수만 들어오는 경우 예외를 반환한다")
    void testExceptionForTwoDigitInput() {
        exceptionBaseballGame("142", "12", "숫자의 길이를 3자리로 입력해주세요.");
    }

    @Test
    @DisplayName("세 자리의 수 이상 들어오는 경우 예외를 반환한다")
    void testExceptionForMoreThanThreeDigitsInput() {
        exceptionBaseballGame("142", "12122", "숫자의 길이를 3자리로 입력해주세요.");
    }

    @Test
    @DisplayName("null값이 들어오는 경우 예외를 반환한다")
    void testExceptionForNullInput() {
        exceptionBaseballGame("142", "12", "숫자의 길이를 3자리로 입력해주세요.");
    }

    @Test
    @DisplayName("숫자와 위치가 두개만 일치하는 경우 OOX")
    void testTwoExactMatches_OOX() {
        assertPlayingBaseballGame("198", "192", 2, 0);
    }

    @Test
    @DisplayName("숫자와 위치가 두개만 일치하는 경우 OXO")
    void testTwoExactMatches_OXO() {
        assertPlayingBaseballGame("142", "152", 2, 0);
    }

    @Test
    @DisplayName("숫자와 위치가 두개만 일치하는 경우 XOO")
    void testTwoExactMatches_XOO() {
        assertPlayingBaseballGame("342", "142", 2, 0);
    }

    @Test
    @DisplayName("숫자와 위치가 두개만 일치하는 경우 OXX")
    void testOneExactMatch_OXX() {
        assertPlayingBaseballGame("194", "182", 1, 0);
    }

    @Test
    @DisplayName("숫자와 위치가 두개만 일치하는 경우 XOX")
    void testOneExactMatch_XOX() {
        assertPlayingBaseballGame("142", "948", 1, 0);
    }

    @Test
    @DisplayName("숫자와 위치가 두개만 일치하는 경우 XXO")
    void testOneExactMatch_XXO() {
        assertPlayingBaseballGame("342", "982", 1, 0);
    }

    @Test
    @DisplayName("아무 것도 일치하지 않는 경우")
    void testNoMatch() {
        assertPlayingBaseballGame("342", "987", 0, 0);
    }

    @Test
    @DisplayName("숫자는 맞지만 전부 위치가 다른 경우")
    void testAllDigitsCorrectButWrongPositions() {
        assertPlayingBaseballGame("342", "234", 0, 3);
    }

    @Test
    @DisplayName("숫자는 2개 맞고 2개의 위치가 다른 경우 XBB")
    void testTwoDigitsCorrectWrongPositions_XBB() {
        assertPlayingBaseballGame("342", "934", 0, 2);
    }

    @Test
    @DisplayName("숫자는 2개 맞고 2개의 위치가 다른 경우 BXB")
    void testTwoDigitsCorrectWrongPositions_BXB() {
        assertPlayingBaseballGame("342", "239", 0, 2);
    }

    @Test
    @DisplayName("숫자는 2개 맞고 2개의 위치가 다른 경우 BBX")
    void testTwoDigitsCorrectWrongPositions_BBX() {
        assertPlayingBaseballGame("342", "239", 0, 2);
    }

    @Test
    @DisplayName("숫자는 1개 맞고 1개의 위치가 다른 경우 BXX")
    void testOneDigitCorrectWrongPosition_BXX() {
        assertPlayingBaseballGame("342", "239", 0, 2);
    }

    @Test
    @DisplayName("숫자는 1개 맞고 1개의 위치가 다른 경우 XBX")
    void testOneDigitCorrectWrongPosition_XBX() {
        assertPlayingBaseballGame("342", "239", 0, 2);
    }

    @Test
    @DisplayName("숫자는 1개 맞고 1개의 위치가 다른 경우 XXB")
    void testOneDigitCorrectWrongPosition_XXB() {
        assertPlayingBaseballGame("342", "239", 0, 2);
    }

    @Test
    @DisplayName("숫자와 위치가 1개 맞고 2개의 숫자만 맞는경우 SBB")
    void testOneStrikeTwoBalls_SBB() {
        assertPlayingBaseballGame("342", "324", 1, 2);
    }

    @Test
    @DisplayName("숫자와 위치가 1개 맞고 2개의 숫자만 맞는경우 BSB")
    void testOneStrikeTwoBalls_BSB() {
        assertPlayingBaseballGame("342", "243", 1, 2);
    }

    @Test
    @DisplayName("숫자와 위치가 1개 맞고 2개의 숫자만 맞는경우 BBS")
    void testOneStrikeTwoBalls_BBS() {
        assertPlayingBaseballGame("342", "432", 1, 2);
    }

    @Test
    @DisplayName("숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우 SBX")
    void testOneStrikeOneBall_SBX() {
        assertPlayingBaseballGame("342", "329", 1, 1);
    }

    @Test
    @DisplayName("숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우 BSX")
    void testOneStrikeOneBall_BSX() {
        assertPlayingBaseballGame("342", "249", 1, 1);
    }

    @Test
    @DisplayName("숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우 SXB")
    void testOneStrikeOneBall_SXB() {
        assertPlayingBaseballGame("342", "492", 1, 1);
    }

    @Test
    @DisplayName("숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우 BXS")
    void testOneStrikeOneBall_BXS() {
        assertPlayingBaseballGame("342", "492", 1, 1);
    }

    @Test
    @DisplayName("숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우 XBS")
    void testOneStrikeOneBall_XBS() {
        assertPlayingBaseballGame("342", "932", 1, 1);
    }

    @Test
    @DisplayName("숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우 XSB")
    void testOneStrikeOneBall_XSB() {
        assertPlayingBaseballGame("342", "943", 1, 1);
    }

    private static void assertFinishBaseballGame(String initNumber, String targetNumber, int expectedStrike, int expectedBall) {
        //given
        NumberBaseballV2 numberBaseballV2 = new NumberBaseballV2(new BasicGameSettingV2());
        numberBaseballV2.testInit(initNumber);

        //when
        GameManagerV2 result = numberBaseballV2.play(targetNumber);

        //then
        assertThat(result.getResultGame()).isEqualTo(2);
        assertThat(result.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(result.getBallCount()).isEqualTo(expectedBall);
    }

    private static void assertPlayingBaseballGame(String initNumber, String targetNumber, int expectedStrike, int expectedBall) {
        //given
        NumberBaseballV2 numberBaseballV2 = new NumberBaseballV2(new BasicGameSettingV2());
        numberBaseballV2.testInit(initNumber);

        //when
        GameManagerV2 result = numberBaseballV2.play(targetNumber);

        //then
        assertThat(result.getResultGame()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(result.getBallCount()).isEqualTo(expectedBall);
    }

    private static void exceptionBaseballGame(String initNumber, String targetNumber, String expectedMessage) {
        //given
        NumberBaseballV2 numberBaseballV2 = new NumberBaseballV2(new BasicGameSettingV2());
        numberBaseballV2.testInit(initNumber);
        //when & then
        assertThatThrownBy(()-> numberBaseballV2.play(targetNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
}
