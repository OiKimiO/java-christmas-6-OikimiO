package christmas.controller;

import static christmas.config.utils.RepeatReader.read;

import christmas.config.convert.ConvertToArray;
import christmas.controller.format.OrderFormat;
import christmas.domain.order.Payment;
import christmas.domain.order.ReservationDay;
import christmas.domain.order.OrderHistory;
import christmas.view.input.InputView;
import christmas.view.output.DomainMessage;
import christmas.view.output.InputMessage;
import christmas.view.output.OutputView;

public class Reservation {
    public Reservation() {
        OutputView.print(InputMessage.INIT);
        reservationInfo();
    }

    public void reservationInfo() {
        ReservationDay reserveDay = read(this::reserveDay);
        OrderHistory orderHistory = read(this::receiveOrder);
        Payment payment = orderInfo(reserveDay, orderHistory);
        InputView.reservationInfo(reserveDay, payment);
    }

    public ReservationDay reserveDay() {
        OutputView.print(InputMessage.WHEN_VISIT_DATE);
        ReservationDay reservationDay = ReservationDay.create(InputView.reserveDay());
        OutputView.printf(InputMessage.INPUT_FORMAT, reservationDay.printFormat());
        return reservationDay;
    }

    public OrderHistory receiveOrder() {
        OutputView.print(InputMessage.WHAT_ORDER_MENU);

        String order = InputView.receiveOrder();
        String[] orders = ConvertToArray.from(order).get();
        OrderFormat.validate(orders);

        OutputView.printMessage(order);

        return OrderHistory.create(orders);
    }

    public Payment orderInfo(ReservationDay reserveDay, OrderHistory orderHistory) {
        OutputView.printf(DomainMessage.PREVIEW_BENEFIT, reserveDay.reserveDay());
        OutputView.print(InputMessage.SEPARATE);

        StringBuilder order = orderHistory.historyFormat();
        Payment payment = Payment.create(orderHistory);
        Integer bill = payment.payment();

        printBill(bill);
        printOrderMenu(order);
        return payment;
    }

    private void printOrderMenu(StringBuilder order) {
        OutputView.print(DomainMessage.ORDER_MENU);
        OutputView.printMessage(order.toString());
    }

    private void printBill(Integer bill) {
        OutputView.print(DomainMessage.PREV_DISCOUNT_ORDER_AMOUNT);
        OutputView.printf(DomainMessage.OUTPUT_WON, bill);
        OutputView.print(InputMessage.SEPARATE);
    }
}
