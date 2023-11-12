package christmas.controller;

import static christmas.config.utils.RepeatReader.read;

import christmas.controller.format.OrderFormat;
import christmas.domain.ReservationDay;
import christmas.domain.order.OrderHistory;
import christmas.view.input.InputView;

public class Reservation {
    public Reservation() {
        ReservationDay reserveDay = read(this::reserveDay);
        OrderHistory orderHistory = read(this::receiveOrder);
        previewBenefit();
    }

    public ReservationDay reserveDay() {
        return new ReservationDay(InputView.reserveDay());
    }

    public OrderHistory receiveOrder() {
        String[] orders = InputView.receiveOrder();
        OrderFormat.validate(orders);

        return OrderHistory.create(orders);
    }

    public void previewBenefit() {
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
