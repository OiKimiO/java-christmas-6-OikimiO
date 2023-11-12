package christmas.controller;

import static christmas.utils.RepeatReader.read;

import christmas.domain.OrderHistory;
import christmas.domain.OrderQuantity;
import christmas.domain.ReservationDay;
import christmas.domain.menu.Menu;
import christmas.view.InputView;
import java.util.Map;
import java.util.Set;

public class Reservation {
    public Reservation(){
        ReservationDay reserveDay = read(this::reserveDay);
        OrderHistory orderHistory = read(this::receiveOrder);
        previewBenefit();
    }

    public ReservationDay reserveDay() {
        return new ReservationDay(InputView.reserveDay());
    }

    public OrderHistory receiveOrder() {
        Map<String, Integer> orderHistory = InputView.receiveOrder();
        Set<String> orderMenu = orderHistory.keySet();

        Menu menu = inputMenu(orderMenu);
        OrderQuantity orderQuantity = inputOrderQuantity(orderHistory, menu);
        return new OrderHistory(menu, orderQuantity);
    }

    private Menu inputMenu(Set<String> orderMenu) {
        return new Menu(orderMenu);
    }

    private OrderQuantity inputOrderQuantity(Map<String, Integer> orderHistory, Menu menu) {
        return new OrderQuantity(orderHistory, menu);
    }

    public void previewBenefit(){
        order();
        benefit();
        discountPayment();
        badge();
    }

    public void order() {
        menu();
        payment();
    }

    public void menu() {

    }

    public void payment() {
    }

    public void benefit() {
        presentation();
        totalBenefit();
    }

    public void presentation() {
    }

    public void totalBenefit() {
    }

    public void discountPayment() {
    }

    public void badge() {
    }
}
