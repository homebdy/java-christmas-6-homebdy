package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readDate() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
