package christmas.domain.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.order.Payment;
import christmas.domain.order.ReservationDay;
import christmas.domain.order.OrderHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialDayPolicyTest {
    private SpecialDayPolicy specialDayPolicy(String[] orders, int reserveDay){
        ReservationDay reservationDay = ReservationDay.create(reserveDay);
        OrderHistory orderHistory = OrderHistory.create(orders);
        Payment payment = Payment.create(orderHistory);

        return SpecialDayPolicy.create(payment, reservationDay);
    }

    @Test
    @DisplayName("스케줄에 별이 포함된 날이 있을 경우 1,000원을 할인 받는다.")
    void createSpecialDayPolicy(){
        String[] orders = new String[]{"양송이수프-2","해산물파스타-2","초코케이크-2","제로콜라-1"};
        int reserveDay = 10;
        SpecialDayPolicy specialDayPolicy = specialDayPolicy(orders, reserveDay);

        int discountAmount = specialDayPolicy.discountAmount();

        assertThat(discountAmount).isEqualTo(-1000);
    }

    @Test
    @DisplayName("스케줄에 별이 포함되어 있지 않아 0원을 할인 받는다.")
    void createSpecialDayPolicyExceptSpecialDay(){
        String[] orders = new String[]{"양송이수프-2","해산물파스타-2","초코케이크-2","제로콜라-1"};
        int reserveDay = 14;
        SpecialDayPolicy specialDayPolicy = specialDayPolicy(orders, reserveDay);

        int discountAmount = specialDayPolicy.discountAmount();

        assertThat(discountAmount).isEqualTo(0);
    }
}
