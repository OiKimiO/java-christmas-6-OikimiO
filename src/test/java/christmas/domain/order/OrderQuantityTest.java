package christmas.domain.order;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderQuantityTest {
    @Test
    @DisplayName("정상적인 주문 수량을 확인한다.")
    void createOrderQuantity(){
        OrderQuantity orderQuantity = OrderQuantity.create(3);

        assertThat(orderQuantity.quantity()).isEqualTo(3);
    }
}
