package christmas.domain.benefit;

import static java.lang.String.format;

import christmas.domain.Payment;
import christmas.view.output.DomainMessage;
import java.util.List;

public class Benefit {
    private final int benefitAmount;
    private final List<DiscountAmount> discountAmount;

    public static Benefit create(List<DiscountAmount> discountAmount){
        return new Benefit(discountAmount);
    }

    private Benefit(List<DiscountAmount> discountAmount){
        this.discountAmount = discountAmount;
        int benefitAmount = 0;

        for (DiscountAmount discount : this.discountAmount) {
            benefitAmount += discount.discountAmount();
        }

        this.benefitAmount = benefitAmount;
    }

    public String benefitList() {
        StringBuilder print = iterateFormat();

        if(print.length() == 0){
            return DomainMessage.OUTPUT_NOTHING.getValue();
        }

        return print.toString();
    }

    private StringBuilder iterateFormat() {
        StringBuilder print = new StringBuilder();
        for (DiscountAmount discount : this.discountAmount) {
            if(!discount.printFormat().equals("")){
                print.append(discount.printFormat()).append("\n");
            }
        }
        return print;
    }

    public String totalBenefit(){
        return format(DomainMessage.OUTPUT_WON.getValue(),benefitAmount);
    }

    public String discountPayment(Payment payment, PresentationPolicy presentationPolicy) {
        int realDiscount = this.benefitAmount - presentationPolicy.discountAmount();

        return format(DomainMessage.OUTPUT_WON.getValue(), payment.finalPay(realDiscount));
    }
}
