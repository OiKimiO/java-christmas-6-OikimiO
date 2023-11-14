package christmas.dto;

import christmas.domain.order.Payment;
import christmas.domain.order.ReservationDay;
import christmas.domain.order.OrderHistory;

public record ReservationDto(ReservationDay reserveDay,
                             OrderHistory orderHistory,
                             Payment payment) {
    public ReservationDto(ReservationDay reserveDay, OrderHistory orderHistory, Payment payment){
        this.reserveDay = reserveDay;
        this.orderHistory = orderHistory;
        this.payment = payment;
    }
}
