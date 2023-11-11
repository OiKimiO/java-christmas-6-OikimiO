package christmas.domain.menu;

public enum MainDish {
    T_BON_STEAK(55000),
    BBQ_RIBS(54000),
    SEA_FOOD_SPAGHETTI(35000),
    CHRISTMAX_PASTA(25000);

    private final int price;

    MainDish(int price) {
        this.price = price;
    }

    public int price() {
        return this.price;
    }
}
