package christmas.controller;

import christmas.domain.Payment;
import christmas.domain.policy.PresentationPolicy;
import christmas.dto.ReservationDto;
import christmas.view.input.InputView;
import christmas.view.output.DomainMessage;
import christmas.view.output.OutputView;

public class PreviewBenefit {
    public PreviewBenefit(){
        ReservationDto reservationDto = InputView.previewBenefit();
        Payment payment = reservationDto.payment();
        presentation(payment);

        benefit();
        discountPayment();
        badge();
    }

    public void presentation(Payment payment) {
        PresentationPolicy presentationPolicy = PresentationPolicy.create(payment);

        OutputView.print(DomainMessage.PRESENTATION_MENU);
        OutputView.printf(DomainMessage.OUTPUT_FORMAT, presentationPolicy.presentation());
    }

    public void benefit() {
        totalBenefit();
    }

    public void totalBenefit() {
    }

    public void discountPayment() {
    }

    public void badge() {
    }
}
