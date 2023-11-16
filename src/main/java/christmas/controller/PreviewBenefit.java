package christmas.controller;

import christmas.domain.benefit.Badge;
import christmas.domain.order.Payment;
import christmas.domain.order.ReservationDay;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.DDayPolicy;
import christmas.domain.benefit.DiscountAmount;
import christmas.domain.benefit.PresentationPolicy;
import christmas.domain.benefit.SpecialDayPolicy;
import christmas.domain.benefit.WeekDayPolicy;
import christmas.domain.benefit.WeekendPolicy;
import christmas.dto.ReservationDto;
import christmas.view.input.InputView;
import christmas.view.output.DomainMessage;
import christmas.view.output.InputMessage;
import christmas.view.output.OutputView;
import java.util.ArrayList;
import java.util.List;

public class PreviewBenefit {
    public PreviewBenefit(){
        ReservationDto reservationDto = InputView.previewBenefit();
        Payment payment = reservationDto.payment();
        ReservationDay reservationDay = reservationDto.reserveDay();

        benefit(payment, reservationDay);
        badge(payment);
    }

    public Benefit benefit(Payment payment, ReservationDay reservationDay) {
        PresentationPolicy presentationPolicy = PresentationPolicy.create(payment);

        List<DiscountAmount> discountAmounts = new ArrayList<>();
        discountAmounts.add(DDayPolicy.create(payment, reservationDay));
        discountAmounts.add(WeekDayPolicy.create(payment, reservationDay));
        discountAmounts.add(WeekendPolicy.create(payment, reservationDay));
        discountAmounts.add(SpecialDayPolicy.create(payment, reservationDay));
        discountAmounts.add(presentationPolicy);

        Benefit benefit = Benefit.create(discountAmounts);

        String finalPayment = benefit.discountPayment(payment, presentationPolicy);
        printBenefit(presentationPolicy, benefit, finalPayment);
        return benefit;
    }

    private void printBenefit(PresentationPolicy presentationPolicy, Benefit benefit, String finalPayment) {
        printPresentation(presentationPolicy);
        printBenefitList(benefit);
        printTotalBenefit(benefit);
        printFinalPayment(finalPayment);
    }

    public void printPresentation(PresentationPolicy presentationPolicy) {
        OutputView.print(DomainMessage.PRESENTATION_MENU);
        OutputView.printMessage(presentationPolicy.printPresentationFormat());
        OutputView.print(InputMessage.SEPARATE);
    }

    private void printTotalBenefit(Benefit benefit) {
        OutputView.print(DomainMessage.TOTAL_BENEFIT_AMOUNT);
        OutputView.printMessage(benefit.totalBenefit());
        OutputView.print(InputMessage.SEPARATE);
    }

    private void printBenefitList(Benefit benefit) {
        OutputView.print(DomainMessage.BENEFIT_LIST);
        OutputView.printMessage(benefit.benefitList());
    }

    public void printFinalPayment(String finalPayment) {
        OutputView.print(DomainMessage.AFTER_DISCOUNT_EXPECTATION_AMOUNT);
        OutputView.printMessage(finalPayment);
        OutputView.print(InputMessage.SEPARATE);
    }

    public void badge(Payment payment) {
        Badge badge = Badge.create(payment);
        OutputView.print(DomainMessage.DECEMBER_EVENT_BADGE);
        OutputView.printf(DomainMessage.OUTPUT_FORMAT,badge.badge());
    }
}
