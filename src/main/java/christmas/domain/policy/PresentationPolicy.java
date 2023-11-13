package christmas.domain.policy;

import christmas.domain.Payment;

public class PresentationPolicy{

    private String presentation;
    private static final int PRESENTATION_AMOUNT = 25000;

    public static PresentationPolicy create(Payment payment){
        return new PresentationPolicy(payment);
    }

    private PresentationPolicy(Payment payment){
        if(payment.isPresentation()){
            this.presentation = "샴페인 1개";
        }
    }

    public String presentation(){
        return this.presentation;
    }

}
