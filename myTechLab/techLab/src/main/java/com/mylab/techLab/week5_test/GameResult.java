package com.mylab.techLab.week5_test;

public enum GameResult {

    EXCEPTION(-1),
    PLAYING(1),
    FINISHED(2);

    private final int resultNumber;

    GameResult(int resultNumber) {
        this.resultNumber = resultNumber;
    }

    public int getResultNumber() {
        return resultNumber;
    }
}
