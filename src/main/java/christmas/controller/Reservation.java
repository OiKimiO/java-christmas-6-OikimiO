package christmas.controller;

import static christmas.config.utils.RepeatReader.read;

import christmas.controller.format.OrderFormat;
import christmas.domain.Payment;
import christmas.domain.ReservationDay;
import christmas.domain.order.OrderHistory;
import christmas.view.input.InputView;
import christmas.view.output.DomainMessage;
import christmas.view.output.OutputView;

public class Reservation {
    public Reservation() {
        reservationInfo();
    }

    public void reservationInfo() {
        ReservationDay reserveDay = read(this::reserveDay);
        OrderHistory orderHistory = read(this::receiveOrder);
        orderInfo(orderHistory);
        InputView.reservationInfo(reserveDay, orderHistory);
    }

    public ReservationDay reserveDay() {
        return ReservationDay.create(InputView.reserveDay());
    }

    public OrderHistory receiveOrder() {
        String[] orders = InputView.receiveOrder();
        OrderFormat.validate(orders);

        return OrderHistory.create(orders);
    }

    public void orderInfo(OrderHistory orderHistory) {
        StringBuilder order = orderHistory.historyFormat();
        Payment payment = Payment.create(orderHistory);
        Integer totalBill = payment.payment();

        OutputView.print(DomainMessage.ORDER_MENU);
        OutputView.printf(DomainMessage.OUTPUT_FORMAT, order.toString());
        OutputView.print(DomainMessage.PREV_DISCOUNT_ORDER_AMOUNT);
        OutputView.printf(DomainMessage.OUTPUT_FORMAT, totalBill);
    }
}
