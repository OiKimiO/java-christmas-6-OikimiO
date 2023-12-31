package christmas.domain.order;

import static java.lang.String.format;

import christmas.config.convert.ConvertToInt;
import christmas.domain.menu.Menu;
import christmas.view.output.DomainMessage;
import java.util.StringTokenizer;

public class Order {
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

    public int discount(String cookType, int discountAmount) {
        Integer quantity = this.orderQuantity.quantity();
        if(isEqualCookType(cookType)){
            return discountAmount * quantity;
        }
        return NOT_DISCOUNT;
    }

    public boolean isEqualCookType(String cookType){
        return this.menu.cookType().equals(cookType);
    }

    public String cookType(){
        return this.menu.cookType();
    }

    public int quantity() {
        return this.orderQuantity.quantity();
    }
}
