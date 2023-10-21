package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public static final int RESTART_OPERATION = 1;
    public static final int EXIT_OPERATION = 2;
    public static final int BASEBALL_NUMBER_LENGTH = 3;
    int exitNumber = 0;
    int strikeNumber = 3;
    int ballNumber = 0;
    List<Integer> answerNumber;
    List<Integer> expectedNumber;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        resetGame();
        while (true) {
            // readExpectedNumber();

            //computeAnswer();

            if (isCompleted() && isExit()) {
                return;
            }
        }
    }

    private void resetGame() {
        makeAnswerNumber();
        exitNumber = 0;
        strikeNumber = 0;
        ballNumber = 0;
    }

    public void makeAnswerNumber() {
        answerNumber = new ArrayList<>();

        while (answerNumber.size() < BASEBALL_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
        // System.out.println(answerNumber.toString());
    }

    private boolean isCompleted() {
        return strikeNumber == BASEBALL_NUMBER_LENGTH;
    }

    private boolean isExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        readExitNumber(readLine());

        switch (exitNumber) {
            case RESTART_OPERATION:
                resetGame();
                break;
            case EXIT_OPERATION:
                return true;
            default:
                throw new IllegalArgumentException(RESTART_OPERATION + " 또는 " + EXIT_OPERATION + "를 입력해야 합니다.");
        }
        return false;
    }

    public void readExitNumber(String input) {
        try {
            exitNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
