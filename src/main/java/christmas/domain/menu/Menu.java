package christmas.domain.menu;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;
import java.util.Set;

public class Menu {
    private final Set<String> menu;

    public Menu(Set<String> menu) {
        validate(menu);
        this.menu = menu;
    }

    private void validate(Set<String> menu) {
        CookType cookType = new CookType();

        menu.stream()
                .filter(menuName -> cookType.isEmptyName(menuName))
                .findAny()
                .ifPresent(emptyMenu -> emptyMenuExcption());
    }

    private void emptyMenuExcption() {
        throw new InputException(ExceptionType.INVALID_ORDER);
    }
}
