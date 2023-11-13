package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Orders;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

public class ChristmasController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printStartPlanner();
        Date date = readDate();
        ChristmasService orderService = new ChristmasService(readMenus());
        outputView.printEventPreview();
        outputView.printNewLine();
        outputView.printOrderMenus(orderService.getOrders());
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
            return inputView.readMenu();
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
