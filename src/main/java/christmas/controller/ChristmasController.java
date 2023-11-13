package christmas.controller;

import christmas.domain.Date;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class ChristmasController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printStartPlanner();
        Date date = readDate();
        List<String> menus = readMenus();
    }

    private Date readDate() {
        outputView.printVisitDate();
        return inputView.readDate();
    }

    private List<String> readMenus() {
        outputView.printOrderMenu();
        return inputView.readMenu();
    }
}
