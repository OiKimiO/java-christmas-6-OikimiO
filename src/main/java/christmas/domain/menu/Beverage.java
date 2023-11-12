package christmas.domain.menu;

public enum Beverage implements Cooking {
    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    private final String menuName;
    private final int price;

    Beverage(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    @Override
    public String menuName(){
        return this.menuName;
    }

    @Override
    public int price() {
        return this.price;
    }
}
