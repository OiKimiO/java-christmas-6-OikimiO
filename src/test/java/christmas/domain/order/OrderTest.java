package christmas.domain.order;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTest {
    @ParameterizedTest
    @CsvSource(value = {"양송이수프-1,Appetizer", "바비큐립-1,MainDish", "초코케이크-1,Dessert","제로콜라-1,Beverage"},delimiter = ',')
    @DisplayName("주문시 요리 종류가 정상적으로 나오는지 확인한다.")
    void createOrder(String inputOrder, String inputCookType){
        Order order = Order.create(inputOrder);

        String cookType = order.cookType();

        assertThat(cookType).isEqualTo(inputCookType);
    }

    @ParameterizedTest
    @ValueSource(strings = {"두-부","두-유","$@-!#","/*2-ㄴㅊ"})
    @DisplayName("잘못된 주문 입력시 예외가 발생한다. - 날짜")
    void createOrderExceptDay(String wrongData){
        assertThatThrownBy(() -> Order.create(wrongData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"바비큐1립-2","1-2", "15-2"})
    @DisplayName("잘못된 주문 입력시 예외가 발생한다. - 메뉴")
    void createOrderExceptMenu(String wrongData){
        assertThatThrownBy(() -> Order.create(wrongData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }


    @ParameterizedTest
    @CsvSource(value = {"양송이수프-1,6000", "바비큐립-2,108000", "초코케이크-3,45000"},delimiter = ',')
    @DisplayName("주문한 요리에 대한 계산을 진행한다.")
    void createOrderCalculate(String inputOrder, int amount){
        Order order = Order.create(inputOrder);

        Integer calculate = order.calculate();

        assertThat(calculate).isEqualTo(amount);
    }

    @ParameterizedTest
    @CsvSource(value = {"바비큐립-2,-4046", "바비큐립-3,-6069", "바비큐립-1,-2023"},delimiter = ',')
    @DisplayName("주문한 요리에 대한 할인을 진행한다.")
    void createOrderDiscount(String inputOrder, Integer amount){
        Order order = Order.create(inputOrder);

        int discountMain = order.discount("MainDish", -2023);

        assertThat(discountMain).isEqualTo(amount);
    }

    @ParameterizedTest
    @CsvSource(value = {"바비큐립-2,2","초코케이크-5,5", "제로콜라-3,3"},delimiter = ',')
    @DisplayName("주문에 대한 수량을 확인한다.")
    void createOrderQuantity(String inputOrder, Integer inputQuantity){
        Order order = Order.create(inputOrder);

        int quantity = order.quantity();

        assertThat(quantity).isEqualTo(inputQuantity);
    }
}
