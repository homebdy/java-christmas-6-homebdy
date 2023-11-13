package christmas.view;

import christmas.constant.OutputMessage;
import christmas.domain.Orders;

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

    public void printEventPreview() {
        System.out.println(OutputMessage.EVENT_PREVIEW.getMessage());
    }

    public void printOrderMenus(Orders orders) {
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        System.out.println(orders.display());
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
