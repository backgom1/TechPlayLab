package com.mylab.techLab.week5_test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
/*
  테스트 순서
  1. 쉬운 경우에서 어려운 경우
  2. 예외적인 경우에서 정상인 경우로 진행
  -------------------------------

  * 쉬운 경우에서 어려운 경우
  1. 숫자의 위치와 전부 동일한 경우 (3,0)
  2. 숫자와 위치가 2개는 일치하는 경우 (2,0)
   2-1. 숫자와_위치가_두개만_일치하는_경우_OOX
   2-2. 숫자와_위치가_두개만_일치하는_경우_OXO
   2-3. 숫자와_위치가_두개만_일치하는_경우_XOO
  3. 숫자와 위치가 1개는 일치하는 경우 (1,0)
   3-1. 숫자와_위치가_두개만_일치하는_경우_OXX
   3-2. 숫자와_위치가_두개만_일치하는_경우_XOX
   3-3. 숫자와_위치가_두개만_일치하는_경우_XXO
 - 여기서 ball을 측정하는 숫자가 포함되어야 하기 때문에 StrikeBallCount 객체를 여기서 추가했다.
  4. 숫자는 맞지만 위치가 다를 경우 (0,3)
  5. 숫자는 2개 맞고 2개의 위치가 다를 경우 (0,2)
   5-1. 숫자는 2개 맞고 2개의 위치가 다를 경우_BBX
   5-2. 숫자는 2개 맞고 2개의 위치가 다를 경우_BXB
   5-3. 숫자는 2개 맞고 2개의 위치가 다를 경우_XBB
  6. 숫자는 1개 맞고 1개의 위치가 다를 경우 (0,1)
   6-1. 숫자는 1개 맞고 1개의 위치가 다를 경우_BXX
   6-2. 숫자는 1개 맞고 1개의 위치가 다를 경우_XBX
   6-3. 숫자는 1개 맞고 1개의 위치가 다를 경우_XXB
  7.숫자와 위치가 1개 맞고 2개의 숫자만 맞는경우(1,2)
   7-1.숫자와 위치가 1개 맞고 2개의 숫자만 맞는경우_SBB
   7-2.숫자와 위치가 1개 맞고 2개의 숫자만 맞는경우_BSB
   7-3.숫자와 위치가 1개 맞고 2개의 숫자만 맞는경우_BBS
  8.숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우(1,1)
   8-1.숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우_SBX
   8-2.숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우_BSX
   8-2.숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우_BXS
   8-2.숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우_SXB
   8-3.숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우_XBS
   8-3.숫자와 위치가 1개 맞고 1개의 숫자만 맞는경우_XSB
  4. 전부 다 맞지 않는 경우 (0,0)

  * 예외적인 경우에서 어려운 경우
   1. 중복된 숫자가 들어갈 경우
    1-1. 중복된_숫자가_들어갈_경우_SSS
    1-2. 중복된_숫자가_들어갈_경우_NSS
    1-3. 중복된_숫자가_들어갈_경우_SNS
    1-4. 중복된_숫자가_들어갈_경우_SSN
   2. 숫자 외 다른 값이 들어가는 경우
   3. 빈 값이 들어가는 경우
    3-1. null이 들어오는 경우
   4. 3자리가 들어오지 않는 경우
    4-1. 한지리의 수만 들어오는 경우
    4-2. 두자리의 수만 들어오는 경우
    4-3. 세자리이상의 수가 들어오는 경우


 */
class NumberBaseballTest {


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


    private static void assertFinishBaseballGame(String initNumber, String targetNumber, int expectedStrike,int expectedBall) {
        NumberBaseball numberBaseball = new NumberBaseball();
        numberBaseball.testInit(initNumber);
        StrikeBallCount result = numberBaseball.play(targetNumber);
        assertThat(result.getResultGame()).isEqualTo(2);
        assertThat(result.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(result.getBallCount()).isEqualTo(expectedBall);
    }

    private static void assertPlayingBaseballGame(String initNumber, String targetNumber, int expectedStrike, int expectedBall) {
        NumberBaseball numberBaseball = new NumberBaseball();
        numberBaseball.testInit(initNumber);
        StrikeBallCount result = numberBaseball.play(targetNumber);
        assertThat(result.getResultGame()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(result.getBallCount()).isEqualTo(expectedBall);
    }

    private static void exceptionBaseballGame(String initNumber, String targetNumber) {
        NumberBaseball numberBaseball = new NumberBaseball();
        numberBaseball.testInit(initNumber);
        StrikeBallCount result = numberBaseball.play(targetNumber);
        assertThat(result.getResultGame()).isEqualTo(-1);
    }
}