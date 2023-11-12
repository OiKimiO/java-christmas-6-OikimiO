package christmas.dto;

import christmas.domain.Payment;
import christmas.domain.ReservationDay;
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
