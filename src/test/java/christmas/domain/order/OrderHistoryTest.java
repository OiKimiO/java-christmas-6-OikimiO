package christmas.domain.order;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderHistoryTest {
    @Test
    @DisplayName("정상 주문후 계산을 진행한다.")
    void createOrderHistory(){
        String[] orders = new String[]{"양송이수프-2","해산물파스타-1","초코케이크-2","제로콜라-1"};
        OrderHistory orderHistory = OrderHistory.create(orders);

        Integer bill = orderHistory.calculateBill();

        assertThat(bill).isEqualTo(80000);
    }

    @Test
    @DisplayName("정상 주문후 할인 금액을 확인한다.")
    void createOrderHistoryDiscount(){
        String[] orders = new String[]{"양송이수프-2","해산물파스타-3","초코케이크-2","제로콜라-1"};
        OrderHistory orderHistory = OrderHistory.create(orders);

        Integer discountAmount = orderHistory.discount("MainDish", -2023);

        assertThat(discountAmount).isEqualTo(-6069);
    }

}
