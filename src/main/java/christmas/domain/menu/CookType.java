package christmas.domain.menu;

import java.util.HashMap;
import java.util.Map;

public class CookType {
    private static final Map<String, Integer> cookings = new HashMap<>();
    private static final Map<String, String> cookType = new HashMap<>();

    public CookType(){
        if(isEmpty()){
            generate();
        }
    }

    private boolean isEmpty() {
        return cookings.size() == 0;
    }

    private void generate() {
        addMenu(Appetizer.values());
        addMenu(MainDish.values());
        addMenu(Dessert.values());
        addMenu(Beverage.values());
    }

    private void addMenu(Cooking[] cooks) {
        for (Cooking cook : cooks) {
            cookings.put(cook.menuName(), cook.price());
            cookType.put(cook.menuName(), cook.type());
        }
    }

    public boolean isEmptyName(String menu){
        return cookings.get(menu) == null;
    }

    public int price(String menu){
        return cookings.get(menu);
    }

    public String type(String menu) {
        return cookType.get(menu);
    }
}
