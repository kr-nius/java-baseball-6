package baseball.model;

import baseball.constant.GameConstants;

public class GameResult {
    private final int strikeCount;
    private final int ballCount;

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    // 승리 조건 확인 (3스트라이크)
    public boolean isWin() {
        return strikeCount == GameConstants.NUMBER_LENGTH;
    }

    // 아무것도 못 맞춘 경우 (낫싱)
    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }
}
