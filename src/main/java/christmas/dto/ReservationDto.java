package christmas.dto;

import christmas.domain.order.Payment;
import christmas.domain.order.ReservationDay;
import christmas.domain.order.OrderHistory;

public record ReservationDto(ReservationDay reserveDay,
                             Payment payment) {
    public ReservationDto(ReservationDay reserveDay, Payment payment){
        this.reserveDay = reserveDay;
        this.payment = payment;
    }
}
