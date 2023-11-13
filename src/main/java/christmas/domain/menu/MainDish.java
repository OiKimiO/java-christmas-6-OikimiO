package christmas.domain.menu;

public enum MainDish implements Cooking{
    T_BON_STEAK("티본스테이크", 55000),
    BBQ_RIBS("바비큐립", 54000),
    SEA_FOOD_SPAGHETTI("해산물파스타", 35000),
    CHRISTMAX_PASTA("크리스마스파스타", 25000);

    private final String menuName;
    private final int price;

    MainDish(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    @Override
    public String type() {
        return "MainDish";
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
