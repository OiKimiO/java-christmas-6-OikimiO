package christmas.domain;

public class Badge {
    private static final int STAR = 5000;
    private static final int TREE = 10000;
    private static final int SANTA = 20000;
    private String badge = "없음";

    public static Badge create(Payment payment){
        return new Badge(payment);
    }

    private Badge(Payment payment) {
        if(payment.isBadge(this.STAR)){
            this.badge = "별";
        }

        if(payment.isBadge(this.TREE)){
            this.badge = "트리";
        }

        if(payment.isBadge(this.SANTA)){
            this.badge = "산타";
        }
    }

    public String badge(){
        return this.badge;
    }

}
