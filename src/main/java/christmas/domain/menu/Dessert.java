package christmas.domain.menu;

public enum Dessert implements Cooking{
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림",5000);

    private final String menuName;
    private final int price;

    Dessert(String menuName, int price) {
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
