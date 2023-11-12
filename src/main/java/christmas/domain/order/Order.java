package christmas.domain.order;

import christmas.config.convert.ConvertToInt;
import christmas.domain.menu.Menu;
import java.util.StringTokenizer;

public class Order {
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

}
