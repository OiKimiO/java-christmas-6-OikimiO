package christmas.domain.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.Payment;
import christmas.domain.order.OrderHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PresentationPolicyTest {
    private PresentationPolicy presentationPolicy(String[] orders){
        OrderHistory orderHistory = OrderHistory.create(orders);
        Payment payment = Payment.create(orderHistory);

        return PresentationPolicy.create(payment);
    }

    @Test
    @DisplayName("120,000원 이상 구매해 증정 정책을 적용한다.")
    void createDayPolicy(){
        String[] orders = new String[]{"양송이수프-2","해산물파스타-5","초코케이크-2","제로콜라-1"};

        PresentationPolicy presentationPolicy = presentationPolicy(orders);

        int discountAmount = presentationPolicy.discountAmount();

        assertThat(discountAmount).isEqualTo(-25000);
    }

    @Test
    @DisplayName("120,000원 미만 구매해 증정 정책을 적용하지 못한다.")
    void createDayPolicyLessThan120000(){
        String[] orders = new String[]{"양송이수프-1","제로콜라-1"};

        PresentationPolicy presentationPolicy = presentationPolicy(orders);

        int discountAmount = presentationPolicy.discountAmount();

        assertThat(discountAmount).isEqualTo(0);
    }
}
