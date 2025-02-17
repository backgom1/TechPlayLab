package com.mylab.techLab.week6_junit5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
    V1 -> V2
    1. @DisplayName 추가
    2. -1에 대해 Exception 변경 및 예외 케이스 변경
    3. @BeforeEach 추가
 */
class NumberBaseballTestV2 {

    @Test
    void 숫자와_위치가_전부_동일한_경우() {
        assertFinishBaseballGame("142", "142", 3,0);
    }

    @Test
    void 중복된_숫자가_들어갈_경우_예외를_반환한다_SSS() {
        exceptionBaseballGame("142", "333");
    }

    @Test
    void 중복된_숫자가_들어갈_경우_예외를_반환한다_SNS() {
        exceptionBaseballGame("142", "323");
    }

    @Test
    void 중복된_숫자가_들어갈_경우_예외를_반환한다_SSN() {
        exceptionBaseballGame("142", "332");
    }

    @Test
    void 중복된_숫자가_들어갈_경우_예외를_반환한다_NSS() {
        exceptionBaseballGame("142", "233");
    }

    @Test
    void 숫자가_아닌_다른_문자가_들어올_경우_예외를_반환한다() {
        exceptionBaseballGame("142", "a33");
    }

    @Test
    void 빈_공백이_들어오는_경우_예외를_반환한다() {
        exceptionBaseballGame("142", "");
    }

    @Test
    void 한_자리의_수만_들어오는_경우_예외를_반환한다() {
        exceptionBaseballGame("142", "1");
    }

    @Test
    void 두_자리의_수만_들어오는_경우_예외를_반환한다() {
        exceptionBaseballGame("142", "12");
    }

    @Test
    void 세_자리의_수_이상_들어오는_경우_예외를_반환한다() {
        exceptionBaseballGame("142", "12122");
    }

    @Test
    void null값이_들어오는_경우_예외를_반환한다() {
        exceptionBaseballGame("142", "12");
    }

    @Test
    void 숫자와_위치가_두개만_일치하는_경우_OOX() {
        assertPlayingBaseballGame("198", "192", 2,0);
    }

    @Test
    void 숫자와_위치가_두개만_일치하는_경우_OXO() {
        assertPlayingBaseballGame("142", "152", 2,0);
    }

    @Test
    void 숫자와_위치가_두개만_일치하는_경우_XOO() {
        assertPlayingBaseballGame("342", "142", 2,0);
    }

    @Test
    void 숫자와_위치가_두개만_일치하는_경우_OXX() {
        assertPlayingBaseballGame("194", "182", 1,0);
    }

    @Test
    void 숫자와_위치가_두개만_일치하는_경우_XOX() {
        assertPlayingBaseballGame("142", "948", 1,0);
    }

    @Test
    void 숫자와_위치가_두개만_일치하는_경우_XXO() {
        assertPlayingBaseballGame("342", "982", 1,0);
    }

    @Test
    void 아무_것도_일치하지_않는경우() {
        assertPlayingBaseballGame("342", "987", 0,0);
    }

    @Test
    void 숫자는_맞지만_전부_위치가_다를_경우() {
        assertPlayingBaseballGame("342", "234", 0,3);
    }

    @Test
    void 숫자는_2개_맞고_2개의_위치가_다를_경우_XBB() {
        assertPlayingBaseballGame("342", "934", 0,2);
    }

    @Test
    void 숫자는_2개_맞고_2개의_위치가_다를_경우_BXB() {
        assertPlayingBaseballGame("342", "239", 0,2);
    }

    @Test
    void 숫자는_2개_맞고_2개의_위치가_다를_경우_BBX() {
        assertPlayingBaseballGame("342", "239", 0,2);
    }

    @Test
    void 숫자는_1개_맞고_1개의_위치가_다를_경우_BXX() {
        assertPlayingBaseballGame("342", "239", 0,2);
    }

    @Test
    void 숫자는_1개_맞고_1개의_위치가_다를_경우_XBX() {
        assertPlayingBaseballGame("342", "239", 0,2);
    }

    @Test
    void 숫자는_1개_맞고_1개의_위치가_다를_경우_XXB() {
        assertPlayingBaseballGame("342", "239", 0,2);
    }

    @Test
    void 숫자와_위치가_1개_맞고_2개의_숫자만_맞는경우_SBB() {
        assertPlayingBaseballGame("342", "324", 1,2);
    }

    @Test
    void 숫자와_위치가_1개_맞고_2개의_숫자만_맞는경우_BSB() {
        assertPlayingBaseballGame("342", "243", 1,2);
    }

    @Test
    void 숫자와_위치가_1개_맞고_2개의_숫자만_맞는경우_BBS() {
        assertPlayingBaseballGame("342", "432", 1,2);
    }

    @Test
    void 숫자와_위치가_1개_맞고_1개의_숫자만_맞는경우_SBX() {
        assertPlayingBaseballGame("342", "329", 1,1);
    }

    @Test
    void 숫자와_위치가_1개_맞고_1개의_숫자만_맞는경우_BSX() {
        assertPlayingBaseballGame("342", "249", 1,1);
    }

    @Test
    void 숫자와_위치가_1개_맞고_1개의_숫자만_맞는경우_SXB() {
        assertPlayingBaseballGame("342", "492", 1,1);
    }
    @Test
    void 숫자와_위치가_1개_맞고_1개의_숫자만_맞는경우_BXS() {
        assertPlayingBaseballGame("342", "492", 1,1);
    }

    @Test
    void 숫자와_위치가_1개_맞고_1개의_숫자만_맞는경우_XBS() {
        assertPlayingBaseballGame("342", "932", 1,1);
    }

    @Test
    void 숫자와_위치가_1개_맞고_1개의_숫자만_맞는경우_XSB() {
        assertPlayingBaseballGame("342", "943", 1,1);
    }

    private static void assertFinishBaseballGame(String initNumber, String targetNumber, int expectedStrike, int expectedBall) {
        //given
        NumberBaseballV2 numberBaseballV2 = new NumberBaseballV2();
        numberBaseballV2.testInit(initNumber);

        //when
        StrikeBallCountV2 result = numberBaseballV2.play(targetNumber);

        //then
        assertThat(result.getResultGame()).isEqualTo(2);
        assertThat(result.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(result.getBallCount()).isEqualTo(expectedBall);
    }

    private static void assertPlayingBaseballGame(String initNumber, String targetNumber, int expectedStrike, int expectedBall) {
        //given
        NumberBaseballV2 numberBaseballV2 = new NumberBaseballV2();
        numberBaseballV2.testInit(initNumber);

        //when
        StrikeBallCountV2 result = numberBaseballV2.play(targetNumber);

        //then
        assertThat(result.getResultGame()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(result.getBallCount()).isEqualTo(expectedBall);
    }

    private static void exceptionBaseballGame(String initNumber, String targetNumber) {
        //given
        NumberBaseballV2 numberBaseballV2 = new NumberBaseballV2();
        numberBaseballV2.testInit(initNumber);
        //when & then
        assertThatThrownBy(()-> numberBaseballV2.play(targetNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
