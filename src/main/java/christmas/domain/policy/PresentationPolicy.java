package christmas.domain.policy;

import christmas.domain.Payment;

public class PresentationPolicy{

    private String presentation;

    public static PresentationPolicy create(Payment payment){
        return new PresentationPolicy(payment);
    }

    private PresentationPolicy(Payment payment){
        if(payment.isPresentation()){
            this.presentation = "샴페인 1개";
        }
    }

}
