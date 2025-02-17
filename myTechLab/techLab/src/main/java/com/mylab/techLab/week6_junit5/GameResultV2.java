package com.mylab.techLab.week6_junit5;

public enum GameResultV2 {

    EXCEPTION(-1),
    PLAYING(1),
    FINISHED(2);

    private final int resultNumber;

    GameResultV2(int resultNumber) {
        this.resultNumber = resultNumber;
    }

    public int getResultNumber() {
        return resultNumber;
    }
}
