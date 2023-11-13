package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

public class ChristmasController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printStartPlanner();
        Date date = readDate();
        Orders menus = readMenus();
    }

    private Date readDate() {
        return attemptedRead(() -> {
            outputView.printVisitDate();
            Date date = inputView.readDate();
            outputView.printNewLine();
            return date;
        });
    }

    private Orders readMenus() {
        return attemptedRead(() -> {
            outputView.printOrderMenu();
            Orders menus = inputView.readMenu();
            outputView.printNewLine();
            return menus;
        });
    }

    private <T> T attemptedRead(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return supplier.get();
        }
    }
}
