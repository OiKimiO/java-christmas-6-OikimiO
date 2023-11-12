package christmas.dto;

import christmas.domain.ReservationDay;
import christmas.domain.order.OrderHistory;

public record ReservationDto(ReservationDay reserveDay,
                             OrderHistory orderHistory) {
    public ReservationDto(ReservationDay reserveDay, OrderHistory orderHistory){
        this.reserveDay = reserveDay;
        this.orderHistory = orderHistory;
    }
}
