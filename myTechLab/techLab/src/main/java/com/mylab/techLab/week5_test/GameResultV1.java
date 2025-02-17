package com.mylab.techLab.week5_test;

public enum GameResultV1 {

    EXCEPTION(-1),
    PLAYING(1),
    FINISHED(2);

    private final int resultNumber;

    GameResultV1(int resultNumber) {
        this.resultNumber = resultNumber;
    }

    public int getResultNumber() {
        return resultNumber;
    }
}
