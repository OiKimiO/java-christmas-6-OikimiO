package christmas.domain.benefit;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Payment;
import christmas.domain.order.OrderHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadgeTest {

    @Test
    @DisplayName("총 지급금액이 10,000원을 넘어 배지를 받았다.")
    void createBadge(){
        String[] orders = new String[]{"티본스테이크-1","바비큐립-1","초코케이크-2","제로콜라-1"};
        OrderHistory orderHistory = OrderHistory.create(orders);
        Payment payment = Payment.create(orderHistory);
        Badge badge = Badge.create(payment);

        assertThat(badge.badge()).isEqualTo("산타");
    }

}
