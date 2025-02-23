package com.mylab.techLab.week6_junit5;

public class UmpireV2 {

    private final GameManagerV2 strikeBall;
    private final boolean[] isStrike;

    public UmpireV2(GameManagerV2 strikeBall, boolean[] isStrike) {
        this.strikeBall = strikeBall;
        this.isStrike = isStrike;
    }

    public GameManagerV2 checkCount(int[] targetNumber, String[] splitSuggestNumber){
        getStrikes(targetNumber,splitSuggestNumber);
        getBalls(targetNumber,splitSuggestNumber);
        return strikeBall;
    }


    private void getStrikes(int[] targetNumber, String[] splitSuggestNumber) {
        for (int i = 0; i < targetNumber.length; i++) {
            int tempNumber = Integer.parseInt(splitSuggestNumber[i]);
            if (targetNumber[i] == tempNumber) {
                strikeBall.increaseStrikeCount();
                isStrike[i] = true;
            }
        }
    }

    private void getBalls(int[] targetNumber, String[] splitSuggestNumber) {
        for (int i = 0; i < targetNumber.length; i++) {
            for (int j = 0; j < targetNumber.length; j++) {
                if (i != j && !isStrike[j] && targetNumber[i] == Integer.parseInt(splitSuggestNumber[j])) {
                    strikeBall.increaseBallCount();
                }
            }
        }
    }

    public void checkFinish(GameSettingV2 gameSettingV2) {
        if (strikeBall.getStrikeCount() == gameSettingV2.getFinishStrike()) {
            strikeBall.finishGame();
        } else {
            strikeBall.playGame();
        }
    }
}
