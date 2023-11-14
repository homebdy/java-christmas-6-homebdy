package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class ChristmasController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printStartPlanner();
        ChristmasService service = new ChristmasService(readDate(), readMenus());
        printResult(service);
    }

    private Date readDate() {
        return attemptedRead(() -> {
            outputView.printVisitDate();
            return inputView.readDate();
        });
    }

    private List<Order> readMenus() {
        return attemptedRead(() -> {
            outputView.printOrderMenu();
            return inputView.readMenu();
        });
    }

    private void printResult(ChristmasService service) {
        outputView.printEventPreview(service.getDate());
        outputView.printOrderMenus(service.getOrders());
        outputView.printTotalPrice(service.getOrders());
        outputView.printGift(service.getGift());
        outputView.printBenefitContent(service.getDiscounts());
        outputView.printBenefit(service.getEventPlanner());
        outputView.printAfterDiscount(service.getEventPlanner());
        outputView.printBadge(service.getEventPlanner());
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
