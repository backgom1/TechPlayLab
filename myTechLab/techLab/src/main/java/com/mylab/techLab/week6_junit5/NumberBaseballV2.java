package com.mylab.techLab.week6_junit5;

import java.util.*;
import java.util.regex.Pattern;


//서비스를 담당하는 클래스로 판단 했다.
//트랜잭션이 들어가겠지 나중에
//비지니스 계층에는 비지니스로직이 들어가면 안된다
public class NumberBaseballV2 {

    //게임 매니저 와 심판을 두어 필드를 뺴는 작업이 필요함
    private final GameSettingV2 gameSettingV2;
    private int[] targetNumber;

    public NumberBaseballV2(GameSettingV2 gameSettingV2) {
        this.gameSettingV2 = gameSettingV2;
    }

    public void testInit(String number) {
        targetNumber = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            targetNumber[i] = Integer.parseInt(number.charAt(i) + "");
        }
    }

    //GameSetting 적용 예정
    public void init() {
        Collections.shuffle(Collections.singletonList(gameSettingV2.getNumbers()));
        targetNumber = new int[3];
        System.arraycopy(gameSettingV2.getNumbers(), 0, targetNumber, 0, 3);
    }

    public GameManagerV2 play(String suggestNumber) {
        UmpireV2 umpire = new UmpireV2(new GameManagerV2(),new boolean[gameSettingV2.getMaxNumber()]);
        validation(suggestNumber);
        String[] splitSuggestNumber = suggestNumber.split("");
        GameManagerV2 count = umpire.checkCount(targetNumber,splitSuggestNumber);
        //게임 매니저로 역할 분리
        umpire.checkFinish(gameSettingV2);
        return count;
    }

    private void validation(String suggestNumber) {

        if (isValidNumber(suggestNumber)) {
            throw new IllegalArgumentException("올바르지 않은 번호입니다.");
        }

        if (isValidLength(suggestNumber)) {
            throw new IllegalArgumentException("숫자의 길이를 3자리로 입력해주세요.");
        }

        if (hasDuplicateNumbersBitSet(suggestNumber)) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }


    }

    private boolean isValidLength(String suggestNumber) {
        return suggestNumber.length() != gameSettingV2.getMaxNumber();
    }

    private boolean isValidNumber(String suggestNumber) {
        return !Pattern.compile("^[1-9]+$").matcher(suggestNumber).matches();
    }

    public boolean hasDuplicateNumbersBitSet(String input) {
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

}
