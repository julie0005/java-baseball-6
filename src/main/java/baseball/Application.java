package baseball;

import static console.Printer.printRestartOrExit;
import static console.Printer.printInput;
import static console.Printer.printQuit;
import static console.Printer.printResult;
import static console.Printer.printStart;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int NUMBER_LIMIT = 3;
    private static final int RESTART = 1;
    private static final int EXIT = 2;
    public static void main(String[] args) {

        String answer = makeRandomNumber();
        printStart();
        while (true) {
            boolean isCorrect = false;
            printInput();
            String input = Console.readLine();
            Result result = Result.calculate(input, answer);
            printResult(result);
            if (result.getStrike() == NUMBER_LIMIT) {
                printQuit(NUMBER_LIMIT);
                isCorrect = true;
            }
            if (isCorrect) {
                printRestartOrExit(RESTART, EXIT);
                String opiton = Console.readLine();
                if (Integer.parseInt(opiton) == EXIT) break;
                else answer = makeRandomNumber();
            }
        }
    }

    static String makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LIMIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.stream().map(Object::toString).collect(Collectors.joining());
    }
}
