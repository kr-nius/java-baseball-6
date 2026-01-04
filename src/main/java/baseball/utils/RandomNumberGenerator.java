package baseball.utils;

import baseball.constant.GameConstants;
import baseball.model.BaseballNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    // 1~9 사이의 서로 다른 숫자 3개 생성
    public static BaseballNumbers generate() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < GameConstants.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.MIN_DIGIT, GameConstants.MAX_DIGIT);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new BaseballNumbers(computer);
    }

}
