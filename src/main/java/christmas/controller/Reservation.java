package christmas.controller;

import static christmas.config.utils.RepeatReader.read;

import christmas.controller.format.OrderFormat;
import christmas.domain.ReservationDay;
import christmas.domain.order.OrderHistory;
import christmas.dto.ReservationDto;
import christmas.view.input.InputView;

public class Reservation {
    public Reservation() {
        ReservationDay reserveDay = read(this::reserveDay);
        OrderHistory orderHistory = read(this::receiveOrder);
        ReservationDto reservationDto = new ReservationDto(reserveDay, orderHistory);
    }

    public ReservationDay reserveDay() {
        return ReservationDay.create(InputView.reserveDay());
    }

    public OrderHistory receiveOrder() {
        String[] orders = InputView.receiveOrder();
        OrderFormat.validate(orders);

        return OrderHistory.create(orders);
    }
}
