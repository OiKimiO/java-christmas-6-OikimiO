package christmas.domain.menu;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;

public class Menu {
    private final String menuName;

    public static Menu create(String menuName){
        return new Menu(menuName);
    }

    public Menu(String menuName) {
        validate(menuName);
        this.menuName = menuName;
    }

    private void validate(String menuName) {
        CookType cookType = new CookType();

        if(isExistMenu(cookType, menuName)){
            throw new InputException(ExceptionType.INVALID_ORDER);
        }
    }

    private boolean isExistMenu(CookType cookType, String menuName) {
        return cookType.isEmptyName(menuName);
    }
}
