package com.mylab.techLab.week6_junit5;

import java.util.Scanner;

import static com.mylab.techLab.week5_test.GameResultV1.EXCEPTION;
import static com.mylab.techLab.week5_test.GameResultV1.FINISHED;


//TODO : 리팩토링이 아주 많이 필요해보입니다. 허허
public class GameClientV2 {
    public static void main(String[] args) {
        NumberBaseballV2 baseball = new NumberBaseballV2();
        baseball.init();
        int gameCount = 0;
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {

            //TODO : Input 클래스 작성
            System.out.println("횟수 : " + gameCount);
            System.out.println("1~9사이의 3자리의 숫자를 조합하세요");
            System.out.print("입력값 ===> ");
            Scanner scanner = new Scanner(System.in);
            StrikeBallCountV2 played = baseball.play(scanner.nextLine());
            if (played.getResultGame() == EXCEPTION.getResultNumber()) {
                System.out.println("잘못된 입력 값입니다. 다시 입력해주세요."+ "\n");
                continue;
            }
            String sb = "스트라이크 : " + played.getStrikeCount() + "개" + "\n" +
                    "볼 : " + played.getBallCount() + "개" + "\n";
            System.out.print(sb);
            if (played.getResultGame() == FINISHED.getResultNumber()) {
                long endTimeMillis = System.currentTimeMillis();
                endTimeMillis = endTimeMillis - currentTimeMillis;

                long seconds = endTimeMillis / 1000; // 초 단위로 변환
                long hours = seconds / 3600; // 시
                long minutes = (seconds % 3600) / 60; // 분
                long remainingSeconds = seconds % 60; // 초

                //TODO : Output 클래스 작성 필요
                System.out.println("통과하셨습니다! 축하드립니다!");
                System.out.println("시간 변환 결과: " + hours + "시간 " + minutes + "분 " + remainingSeconds + "초");

                break;
            }
            gameCount++;
        }
    }
}
