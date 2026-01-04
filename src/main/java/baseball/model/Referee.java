package baseball.model;

import baseball.constant.GameConstants;

public class Referee {

    // 두 개의 숫자 객체를 비교하여 결과를 반환
    public GameResult judge(BaseballNumbers computer, BaseballNumbers player) {
        int strike = countStrikes(computer, player);
        int ball = countBalls(computer, player);
        return new GameResult(strike, ball);
    }

    private int countStrikes(BaseballNumbers computer, BaseballNumbers player) {
        int strike = 0;
        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++) {
            if (computer.isStrike(i, player.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int countBalls(BaseballNumbers computer, BaseballNumbers player) {
        int ball = 0;
        for (int i = 0; i < GameConstants.NUMBER_LENGTH; i++) {
            int playerNumber = player.get(i);
            // 숫자는 포함되어 있지만 위치는 다른 경우 (볼)
            if (computer.contains(playerNumber) && !computer.isStrike(i, playerNumber)) {
                ball++;
            }
        }
        return ball;
    }
}
