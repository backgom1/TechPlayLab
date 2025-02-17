package com.mylab.techLab.week5_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class NumberBaseballV1 {

    private String number;

    public void testInit(String number) {
        this.number = number;
    }

    public void init() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        int randomNumber = numbers.get(0) * 100 + numbers.get(1) * 10 + numbers.get(2);
        this.number = String.valueOf(randomNumber);
        System.out.println(number);
    }

    public StrikeBallCountV1 play(String suggestNumber) {

        StrikeBallCountV1 strikeBallCountV1 = new StrikeBallCountV1();

        if (!Pattern.compile("^[1-9]+$").matcher(suggestNumber).matches()) {
            strikeBallCountV1.exceptionGame();
            return strikeBallCountV1;
        }

        if (suggestNumber.length() != 3) {
            strikeBallCountV1.exceptionGame();
            return strikeBallCountV1;
            //-1
        }

        String[] splitNumber = number.split("");
        int firstNumber = Integer.parseInt(splitNumber[0]);
        int secondNumber = Integer.parseInt(splitNumber[1]);
        int thirdNumber = Integer.parseInt(splitNumber[2]);

        String[] splitSuggestNumber = suggestNumber.split("");
        int firstSuggestNumber = Integer.parseInt(splitSuggestNumber[0]);
        int secondSuggestNumber = Integer.parseInt(splitSuggestNumber[1]);
        int thirdSuggestNumber = Integer.parseInt(splitSuggestNumber[2]);


        if (firstSuggestNumber == secondSuggestNumber || firstSuggestNumber == thirdSuggestNumber || secondSuggestNumber == thirdSuggestNumber) {
            strikeBallCountV1.exceptionGame();
            return strikeBallCountV1; //-1
        }

        String tempNumber = number;
        if (firstNumber == firstSuggestNumber) {
            String strFirstNumber = String.valueOf(firstNumber);
            tempNumber = tempNumber.replace(strFirstNumber, "0");
            strikeBallCountV1.increaseStrikeCount();
        }
        if (secondNumber == secondSuggestNumber) {
            String strSecondNumber = String.valueOf(secondNumber);
            tempNumber = tempNumber.replace(strSecondNumber, "0");
            strikeBallCountV1.increaseStrikeCount();
        }
        if (thirdNumber == thirdSuggestNumber) {
            String strThirdNumber = String.valueOf(thirdNumber);
            tempNumber = tempNumber.replace(strThirdNumber, "0");
            strikeBallCountV1.increaseStrikeCount();
        }

        for (String targetNumber : splitSuggestNumber) {
            if (tempNumber.contains(targetNumber)) {
                strikeBallCountV1.increaseBallCount();
            }
        }

        if(strikeBallCountV1.getStrikeCount() == 3 ){
            strikeBallCountV1.finishGame();
        }else {
            strikeBallCountV1.playGame();
        }

        return strikeBallCountV1;
    }
}
