package christmas.domain.policy;

import christmas.domain.Payment;

public class DDayPolicy {
    private static final int STANDARD_DISCOUNT = -1000;
    private static final int NOT_DISCOUNT = 0;
    private static final int START_DAY = 1;
    private static final int END_DAY = 25;
    private final int dDayDiscount;

    public static DDayPolicy create(Payment payment, int day){
        return new DDayPolicy(payment, day);
    }

    private DDayPolicy(Payment payment, int day){
        int dDayDiscount = 0;
        if(payment.isApplyEvent()){
            dDayDiscount = discountCost(day);
        }
        this.dDayDiscount = dDayDiscount;
    }

    private int discountCost(int day){
        if(isOverDiscountDays(day)){
            return this.NOT_DISCOUNT;
        }

        int addDiscount = -((day - this.START_DAY) * 100);

        return this.STANDARD_DISCOUNT + addDiscount;
    }

    private boolean isOverDiscountDays(int day) {
        return day < START_DAY || day > END_DAY;
    }

    public int dDayDiscount(){
        return this.dDayDiscount;
    }

}
