package baseball.view;

import baseball.constant.GameConstants;

public class OutputView {

    // 게임 시작 문구 출력
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 결과 객체의 데이터만 받아서 출력 형식을 결정
    public void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(GameConstants.NOTHING);
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append(GameConstants.BALL).append(" ");
        }
        if (strike > 0) {
            sb.append(strike).append(GameConstants.STRIKE);
        }
        System.out.println(sb.toString().trim());
    }

    public void printGameSuccess() {
        System.out.println(GameConstants.NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
