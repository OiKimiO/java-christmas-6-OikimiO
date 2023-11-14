package christmas.domain.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.Payment;
import christmas.domain.ReservationDay;
import christmas.domain.order.OrderHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DDayPolicyTest {
    private DDayPolicy dDayPolicy(String[] orders, int reserveDay){
        ReservationDay reservationDay = ReservationDay.create(reserveDay);
        OrderHistory orderHistory = OrderHistory.create(orders);
        Payment payment = Payment.create(orderHistory);

        return DDayPolicy.create(payment, reservationDay);
    }

    @Test
    @DisplayName("10,000원 이상 구매해 D-Day 정책을 적용한다.")
    void createDayPolicy(){
        int reserveDay = 10;
        String[] orders = new String[]{"양송이수프-2","해산물파스타-1","초코케이크-2","제로콜라-1"};

        DDayPolicy dDayPolicy = dDayPolicy(orders, reserveDay);

        int discountAmount = dDayPolicy.discountAmount();

        assertThat(discountAmount).isEqualTo(-1900);
    }

    @Test
    @DisplayName("10,000원 미만 구매해 D-Day정책을 적용하지 못한다.")
    void createDayPolicyLessThan10000(){
        int reserveDay = 10;
        String[] orders = new String[]{"양송이수프-1","제로콜라-1"};

        DDayPolicy dDayPolicy = dDayPolicy(orders, reserveDay);

        int discountAmount = dDayPolicy.discountAmount();

        assertThat(discountAmount).isEqualTo(0);
    }

    @Test
    @DisplayName("10,000원 이상 구매했지만, 예약 일자가 25일을 넘어서 적용하지 못한다.")
    void createReserveDayOver25(){
        int reserveDay = 26;
        String[] orders = new String[]{"양송이수프-2","해산물파스타-1","초코케이크-2","제로콜라-1"};

        DDayPolicy dDayPolicy = dDayPolicy(orders, reserveDay);

        int discountAmount = dDayPolicy.discountAmount();

        assertThat(discountAmount).isEqualTo(0);
    }
}
