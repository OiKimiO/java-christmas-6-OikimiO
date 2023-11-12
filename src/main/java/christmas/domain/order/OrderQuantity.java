package christmas.domain.order;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;

public class OrderQuantity {
    private final Integer orderQuantity;

    public static OrderQuantity create(Integer orderQuantity){
        return new OrderQuantity(orderQuantity);
    }

    private OrderQuantity(Integer orderQuantity) {
        validate(orderQuantity);
        this.orderQuantity = orderQuantity;
    }

    private void validate(int orderQuantity) {
        if(isUnderOne(orderQuantity)){
            throw new InputException(ExceptionType.QUANTITY_UNDER_ONE);
        }
    }

    private boolean isUnderOne(Integer quantity) {
        return quantity < 1;
    }

    public Integer quantity(){
        return this.orderQuantity;
    }

}
