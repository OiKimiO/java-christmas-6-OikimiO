package christmas.domain.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.domain.order.Payment;
import christmas.domain.order.ReservationDay;
import christmas.domain.order.OrderHistory;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BenefitTest {

    private List<DiscountAmount> discountAmounts(String[] orders, int reserveDay){
        ReservationDay reservationDay = ReservationDay.create(reserveDay);
        OrderHistory orderHistory = OrderHistory.create(orders);
        Payment payment = Payment.create(orderHistory);

        List<DiscountAmount> discountAmounts = new ArrayList<>();
        discountAmounts.add(DDayPolicy.create(payment, reservationDay));
        discountAmounts.add(WeekDayPolicy.create(payment, reservationDay));
        discountAmounts.add(WeekendPolicy.create(payment, reservationDay));
        discountAmounts.add(SpecialDayPolicy.create(payment, reservationDay));
        discountAmounts.add(PresentationPolicy.create(payment));
        return discountAmounts;
    }

    @Test
    @DisplayName("총 주문금액이 10,000원을 넘어 할인을 받는다.")
    void createBenefit(){
        int reserveDay = 10;
        String[] orders = new String[]{"양송이수프-2","해산물파스타-1","초코케이크-2","제로콜라-1"};
        Benefit benefit = Benefit.create(discountAmounts(orders, reserveDay));

        String totalDiscount = "-6,946원";

        assertThat(benefit.totalBenefit()).isEqualTo(totalDiscount);
    }


    @Test
    @DisplayName("총 주문금액이 10,000을 넘지 않아 할인을 받지 않는다.")
    void createBenefitLessThan10000(){
        int reserveDay = 10;
        String[] orders = new String[]{"양송이수프-1","제로콜라-1"};
        Benefit benefit = Benefit.create(discountAmounts(orders, reserveDay));

        assertThat(benefit.totalBenefit()).isEqualTo("0원");
    }

    @Test
    @DisplayName("총 주문 금액이 10,000원을 넘어 출력 테스트를 한다.")
    void createBenefitPrint(){
        int reserveDay = 10;
        String[] orders = new String[]{"양송이수프-2","해산물파스타-1","초코케이크-2","제로콜라-1"};
        Benefit benefit = Benefit.create(discountAmounts(orders, reserveDay));

        String discountList = "크리스마스 디데이 할인: -1,900원\n평일 할인: -4,046원\n특별 할인: -1,000원\n";

        assertThat(benefit.benefitList()).isEqualTo(discountList);
    }

    @Test
    @DisplayName("사용자가 할인받을 최종 금액을 입력한다.")
    void createBenefitTotalDiscount(){
        int reserveDay = 10;
        String[] orders = new String[]{"양송이수프-2","해산물파스타-1","초코케이크-2","제로콜라-1"};
        ReservationDay reservationDay = ReservationDay.create(reserveDay);
        OrderHistory orderHistory = OrderHistory.create(orders);
        Payment payment = Payment.create(orderHistory);

        Benefit benefit = Benefit.create(discountAmounts(orders, reserveDay));

        PresentationPolicy presentationPolicy = PresentationPolicy.create(payment);

        String realDiscount = "73,054원";

        assertThat(benefit.discountPayment(payment,presentationPolicy)).isEqualTo(realDiscount);
    }

    @Test
    @DisplayName("20개 이상의 음식을 주문한다.")
    void createOrderOver20(){
        int reserveDay = 10;
        String[] orders = new String[]{"양송이수프-2","해산물파스타-15","초코케이크-5","제로콜라-1"};

        assertThatThrownBy(() -> Benefit.create(discountAmounts(orders, reserveDay)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 음식은 최대 20개까지만 주문할 수 있습니다. 다시 입력해주세요.");
    }
}
