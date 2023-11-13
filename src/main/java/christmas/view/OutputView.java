package christmas.view;

import christmas.constant.OutputMessage;

public class OutputView {

    public void printStartPlanner() {
        System.out.println(OutputMessage.START_PLANNER.getMessage());
    }

    public void printVisitDate() {
        System.out.println(OutputMessage.READ_VISIT_DATE.getMessage());
    }

    public void printOrderMenu() {
        System.out.println(OutputMessage.READ_MENU.getMessage());
    }

    public void printExceptionMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public void printNewLine() {
        System.out.println();
    }
}
