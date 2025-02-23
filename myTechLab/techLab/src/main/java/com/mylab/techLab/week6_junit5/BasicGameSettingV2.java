package com.mylab.techLab.week6_junit5;

public class BasicGameSettingV2 implements GameSettingV2 {

    private final int[] availableNumbers;
    private final int maxLengthNumber;
    private final int finishStrike;

    public BasicGameSettingV2() {
        this.finishStrike = 3;
        this.availableNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.maxLengthNumber = 3;
    }

    @Override
    public int[] getNumbers() {
        return availableNumbers;
    }

    @Override
    public int getMaxNumber() {
        return maxLengthNumber;
    }

    @Override
    public int getFinishStrike() {
        return finishStrike;
    }
}
