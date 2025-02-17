package com.mylab.techLab.week6_junit5;

import java.util.*;
import java.util.regex.Pattern;

public class NumberBaseballV2 {

    //게임 세팅으로 빼도될듯
    public static final int[] AVAILABLE_NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static final int MAX_NUMBER_SIZE = 3;
    public static final int FINISH_STRIKES = 3;

    private int[] targetNumber;

    public void testInit(String number) {
        targetNumber = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            targetNumber[i] = Integer.parseInt(number.charAt(i) + "");
        }
    }

    //GameSetting 적용 예정
    public void init() {
        Collections.shuffle(Collections.singletonList(AVAILABLE_NUMBERS));
        targetNumber = new int[3];
        System.arraycopy(AVAILABLE_NUMBERS, 0, targetNumber, 0, 3);
    }

    public StrikeBallCountV2 play(String suggestNumber) {
        StrikeBallCountV2 strikeBallCountV2 = new StrikeBallCountV2();
        validation(suggestNumber);
        boolean[] isStrike = new boolean[targetNumber.length];
        String[] splitSuggestNumber = suggestNumber.split("");
        getStrikes(splitSuggestNumber, strikeBallCountV2, isStrike);
        getBalls(isStrike, splitSuggestNumber, strikeBallCountV2);
        checkFinish(strikeBallCountV2);
        return strikeBallCountV2;
    }

    private void validation(String suggestNumber) {
        if (hasDuplicateNumbersBitSet(suggestNumber)) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }

        if (isValidNumber(suggestNumber)) {
            throw new IllegalArgumentException("올바르지 않은 번호입니다.");
        }

        if (isValidLength(suggestNumber)) {
            throw new IllegalArgumentException("숫자의 길이를 3자리로 입력해주세요.");
        }
    }

    private void getStrikes(String[] splitSuggestNumber, StrikeBallCountV2 strikeBallCountV2, boolean[] isStrike) {
        for (int i = 0; i < targetNumber.length; i++) {
            int tempNumber = Integer.parseInt(splitSuggestNumber[i]);
            if (targetNumber[i] == tempNumber) {
                strikeBallCountV2.increaseStrikeCount();
                isStrike[i] = true;
            }
        }
    }

    private void getBalls(boolean[] isStrike, String[] splitSuggestNumber, StrikeBallCountV2 strikeBallCountV2) {
        for (int i = 0; i < targetNumber.length; i++) {
            for (int j = 0; j < targetNumber.length; j++) {
                if (i != j && !isStrike[j] && targetNumber[i] == Integer.parseInt(splitSuggestNumber[j])) {
                    strikeBallCountV2.increaseBallCount();
                }
            }
        }
    }

    private boolean isValidLength(String suggestNumber) {
        return suggestNumber.length() != MAX_NUMBER_SIZE;
    }

    private boolean isValidNumber(String suggestNumber) {
        return !Pattern.compile("^[1-9]+$").matcher(suggestNumber).matches();
    }

    public static boolean hasDuplicateNumbersBitSet(String input) {
        BitSet bitSet = new BitSet(input.length());

        for (char c : input.toCharArray()) {
            int num = c - '0';
            if (bitSet.get(num)) {
                return true;
            }
            bitSet.set(num);
        }
        return false;
    }

    private static void checkFinish(StrikeBallCountV2 strikeBallCountV2) {
        if (strikeBallCountV2.getStrikeCount() == FINISH_STRIKES) {
            strikeBallCountV2.finishGame();
        } else {
            strikeBallCountV2.playGame();
        }
    }
}
