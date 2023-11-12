package christmas.controller;

import christmas.dto.ReservationDto;
import christmas.view.input.InputView;

public class PreviewBenefit {
    public PreviewBenefit(){
        ReservationDto reservationDto = InputView.previewBenefit();
        benefit();
        discountPayment();
        badge();
    }

    public void benefit() {
        presentation();
        totalBenefit();
    }

    public void presentation() {
    }

    public void totalBenefit() {
    }

    public void discountPayment() {
    }

    public void badge() {
    }
}
