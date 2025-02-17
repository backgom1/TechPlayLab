package com.mylab.techLab.week6_junit5;

import static com.mylab.techLab.week5_test.GameResultV1.*;

public class StrikeBallCountV2 {

    private int resultGame;
    private int strikeCount;
    private int ballCount;

    public StrikeBallCountV2() {}

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

}
