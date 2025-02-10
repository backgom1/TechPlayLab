package com.mylab.techLab.week5_test;

import static com.mylab.techLab.week5_test.GameResult.*;

public class StrikeBallCount {

    private int resultGame;
    private int strikeCount;
    private int ballCount;

    public StrikeBallCount() {}

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getResultGame() {
        return resultGame;
    }

    public void increaseStrikeCount(){
        this.strikeCount++;
    }

    public void increaseBallCount(){
        this.ballCount++;
    }

    public void finishGame() {
        this.resultGame = FINISHED.getResultNumber();
    }

    public void playGame() {
        this.resultGame = PLAYING.getResultNumber();
    }

    public void exceptionGame(){
        this.resultGame = EXCEPTION.getResultNumber();
    }
}
