package christmas.domain.policy;

import christmas.domain.Payment;
import java.util.Arrays;
import java.util.List;

public class SpecialPolicy {
    private List<Integer> specialDay = Arrays.asList(3,10,17,24,25,31);
    private final int DISCOUNT_AMOUNT = -1000;
    private final int specialDiscount;

    public static SpecialPolicy create(Payment payment, int day){
        return new SpecialPolicy(payment, day);
    }

    private SpecialPolicy(Payment payment, int day){
        int discountAmount = 0;
        if(specialDay.contains(day) && payment.isApplyEvent()){
            discountAmount = this.DISCOUNT_AMOUNT;
        }
        this.specialDiscount = discountAmount;
    }

    public int specialDiscount() {
        return this.specialDiscount;
    }
}
