package christmas.domain.policy;

import static java.lang.String.format;
import static christmas.view.output.DomainMessage.OUTPUT_NOTHING;

import christmas.domain.Payment;
import christmas.view.output.DomainMessage;

public class PresentationPolicy{
    private static final int NONE_CHAMPAGNE = 0;
    private static final int PRESENTATION_AMOUNT = -25000;
    private final int presentation;


    public static PresentationPolicy create(Payment payment){
        return new PresentationPolicy(payment);
    }

    private PresentationPolicy(Payment payment){
        int presentation = 0;
        if(payment.isPresentation()){
            presentation = 1;
        }
        this.presentation = presentation;
    }

    public String presentation(){
        if(isPresentation()){
            return OUTPUT_NOTHING.getValue();
        }

        return format(DomainMessage.PRESENTATION_FORMAT.getValue(), this.presentation);
    }

    private boolean isPresentation() {
        return this.presentation == NONE_CHAMPAGNE;
    }

    public int presentationAmount(){
        if(isPresentation()){
            return NONE_CHAMPAGNE;
        }

        return this.PRESENTATION_AMOUNT;
    }
}
