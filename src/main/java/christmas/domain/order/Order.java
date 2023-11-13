package christmas.domain.order;

import static java.lang.String.format;

import christmas.config.convert.ConvertToInt;
import christmas.domain.menu.Menu;
import christmas.view.output.DomainMessage;
import java.util.StringTokenizer;

public class Order {
    private static final int DISCOUNT_AMOUNT = -2300;
    private static final int NOT_DISCOUNT = 0;
    private final Menu menu;
    private final OrderQuantity orderQuantity;

    public static Order create(String order) {
        return new Order(order);
    }

    private Order(String order) {
        StringTokenizer orderTokens = new StringTokenizer(order, "-");

        String menuName = orderTokens.nextToken();
        String quantityToken = orderTokens.nextToken();
        int quantity = ConvertToInt.from(quantityToken).get();

        this.menu = Menu.create(menuName);
        this.orderQuantity = OrderQuantity.create(quantity);
    }

    public String orderFormat(){
        String menuName = menu.name();
        Integer quantity = orderQuantity.quantity();

        return format(DomainMessage.ORDER_MENU_FORMAT.getValue(), menuName, quantity);
    }

    public Integer calculate() {
        Integer price = this.menu.price();
        Integer quantity = this.orderQuantity.quantity();
        return price * quantity;
    }

    private boolean isDiscountOrder(String cookType){
        return this.menu.cookType().equals(cookType);
    }

    public int discount(String cookType) {
        if(isDiscountOrder(cookType)){
            return DISCOUNT_AMOUNT;
        }
        return NOT_DISCOUNT;
    }
}
