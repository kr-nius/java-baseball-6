package baseball.controller;

import baseball.constant.GameConstants;
import baseball.model.BaseballNumbers;
import baseball.model.GameResult;
import baseball.model.Referee;
import baseball.utils.InputValidator;
import baseball.utils.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Referee referee;

    public BaseballController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.referee = new Referee();
    }

    // 게임 전체 실행 흐름
    public void run() {
        outputView.printStartMessage();

        boolean isRunning = true;
        while (isRunning) {
            playGame();
            isRunning = checkRestart();
        }
    }

    // 한 판의 게임 진행
    private void playGame() {
        BaseballNumbers computerNumbers = RandomNumberGenerator.generate();
        boolean isGameClear = false;

        while (!isGameClear) {
            BaseballNumbers playerNumbers = getPlayerInput();
            GameResult result = referee.judge(computerNumbers, playerNumbers);
            outputView.printResult(result.getStrikeCount(), result.getBallCount());

            isGameClear = checkGameClear(result);
        }
    }

    // 사용자 입력 -> 검증 -> 도메인 객체 변환
    private BaseballNumbers getPlayerInput() {
        String input = inputView.readPlayerNumbers();
        InputValidator.validateInput(input); // 예외 발생 시 프로그램 종료
        return convertToBaseballNumbers(input);
    }

    // 문자열을 숫자 리스트 객체로 변환
    private BaseballNumbers convertToBaseballNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return new BaseballNumbers(numbers);
    }

    // 게임 클리어 여부 확인 및 메시지 출력
    private boolean checkGameClear(GameResult result) {
        if (result.isWin()) {
            outputView.printGameSuccess();
            return true;
        }
        return false;
    }

    // 재시작 여부 확인
    private boolean checkRestart() {
        String command = inputView.readRestartCommand();
        if (command.equals(GameConstants.RESTART_COMMAND)) {
            return true;
        }
        if (command.equals(GameConstants.EXIT_COMMAND)) {
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
