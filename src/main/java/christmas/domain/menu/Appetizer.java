package christmas.domain.menu;

public enum Appetizer implements Cooking{
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CEASAR_SALAD("시저샐러드",8000)
    ;

    private final String menuName;
    private final int price;

    Appetizer(String menuName, int price) {
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
