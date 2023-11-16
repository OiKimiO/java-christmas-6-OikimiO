package christmas.domain.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.order.Payment;
import christmas.domain.order.ReservationDay;
import christmas.domain.order.OrderHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekDayPolicyTest {
    private WeekDayPolicy weekDayPolicy(String[] orders, int reserveDay){
        ReservationDay reservationDay = ReservationDay.create(reserveDay);
        OrderHistory orderHistory = OrderHistory.create(orders);
        Payment payment = Payment.create(orderHistory);

        return WeekDayPolicy.create(payment, reservationDay);
    }

    @Test
    @DisplayName("10,000원 이상 주문 후 디저트 개수별로 할인을 적용받는다.")
    void createWeekDayPolicy(){
        String[] orders = new String[]{"양송이수프-2","해산물파스타-2","초코케이크-3","제로콜라-1"};
        int reserveDay = 10;
        WeekDayPolicy weekDayPolicy = weekDayPolicy(orders, reserveDay);

        int discountAmount = weekDayPolicy.discountAmount();

        assertThat(discountAmount).isEqualTo(-6069);
    }

    @Test
    @DisplayName("10,000원 이하로 주문해 할인을 적용받지 못한다.")
    void createWeekDayPolicyLessThan10000(){
        String[] orders = new String[]{"양송이수프-1","제로콜라-1"};
        int reserveDay = 10;
        WeekDayPolicy weekDayPolicy = weekDayPolicy(orders, reserveDay);

        int discountAmount = weekDayPolicy.discountAmount();

        assertThat(discountAmount).isEqualTo(0);
    }

    @Test
    @DisplayName("10,000원 이상 주문 후 디저트가 없어 할인받지 못한다.")
    void createWeekDayPolicyExceptDessert(){
        String[] orders = new String[]{"양송이수프-2","해산물파스타-2","제로콜라-1"};
        int reserveDay = 10;
        WeekDayPolicy weekDayPolicy = weekDayPolicy(orders, reserveDay);

        int discountAmount = weekDayPolicy.discountAmount();

        assertThat(discountAmount).isEqualTo(0);
    }
}
