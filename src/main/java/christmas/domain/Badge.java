package christmas.domain;

import christmas.view.output.DomainMessage;

public class Badge {
    private static final int STAR = 5000;
    private static final int TREE = 10000;
    private static final int SANTA = 20000;
    private String badge = DomainMessage.OUTPUT_NOTHING.getValue();

    public static Badge create(Payment payment){
        return new Badge(payment);
    }

    private Badge(Payment payment) {
        if(payment.isApplyEvent()){
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
    }

    public String badge(){
        return this.badge;
    }

}
