package christmas.domain.policy;

import java.util.Arrays;
import java.util.List;

public class SpecialPolicy {
    private List<Integer> specialDay = Arrays.asList(3,10,17,24,25,31);
    private final int DISCOUNT_AMOUNT = 1000;
    private int specialDiscount = 0;

    public SpecialPolicy(int day){
        if(specialDay.contains(day)){
            this.specialDiscount = this.DISCOUNT_AMOUNT;
        }
    }
}
