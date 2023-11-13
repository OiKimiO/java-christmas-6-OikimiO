package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Payment;
import christmas.domain.ReservationDay;
import christmas.domain.policy.DDayPolicy;
import christmas.domain.policy.PresentationPolicy;
import christmas.domain.policy.SpecialPolicy;
import christmas.domain.policy.WeekDayPolicy;
import christmas.domain.policy.WeekendPolicy;
import christmas.dto.ReservationDto;
import christmas.view.input.InputView;
import christmas.view.output.DomainMessage;
import christmas.view.output.OutputView;

public class PreviewBenefit {
    public PreviewBenefit(){
        ReservationDto reservationDto = InputView.previewBenefit();
        Payment payment = reservationDto.payment();
        ReservationDay reservationDay = reservationDto.reserveDay();
        OutputView.printf(DomainMessage.PREVIEW_BENEFIT, reservationDay.reserveDay());

        int presentationDiscount = presentation(payment);
        int totalDiscount = totalBenefit(payment, reservationDay);
        OutputView.print(DomainMessage.TOTAL_BENEFIT_AMOUNT);
        OutputView.printf(DomainMessage.OUTPUT_WON,(totalDiscount + presentationDiscount));

        discountPayment(payment, totalDiscount);
        badge(payment);
    }

    public int presentation(Payment payment) {
        PresentationPolicy presentationPolicy = PresentationPolicy.create(payment);

        OutputView.print(DomainMessage.PRESENTATION_MENU);
        OutputView.printf(DomainMessage.PRESENTATION_DISCOUNT, presentationPolicy.presentation());

        return presentationPolicy.presentationDiscount();
    }

    public int totalBenefit(Payment payment, ReservationDay reservationDay) {
        DDayPolicy dDayPolicy = DDayPolicy.create(payment, reservationDay.reserveDay());
        SpecialPolicy specialPolicy = SpecialPolicy.create(payment, reservationDay.reserveDay());
        WeekDayPolicy weekDayPolicy = WeekDayPolicy.create(payment, reservationDay.reserveDay());
        WeekendPolicy weekendPolicy = WeekendPolicy.create(payment, reservationDay.reserveDay());

        int dDayDiscount = dDayPolicy.dDayDiscount();
        int specialDiscount = specialPolicy.specialDiscount();
        int weekDayDiscount = weekDayPolicy.weekDayDiscount();
        int weekendDiscount = weekendPolicy.weekendDiscount();
        int totalDiscount = dDayDiscount + specialDiscount + weekDayDiscount + weekendDiscount;

        OutputView.print(DomainMessage.BENEFIT_LIST);
        if(dDayDiscount > 0){
            OutputView.printf(DomainMessage.CHRISTMAS_DISCOUNT,dDayDiscount);
        }

        if(weekDayDiscount > 0){
            OutputView.printf(DomainMessage.WEEKDAY_DISCOUNT,weekDayDiscount);
        }

        if(weekendDiscount > 0){
            OutputView.printf(DomainMessage.WEEKEND_DISCOUNT,weekendDiscount);
        }

        if(specialDiscount > 0){
            OutputView.printf(DomainMessage.SPECIAL_DISCOUNT,specialDiscount);
        }

        if(dDayDiscount == 0 && weekDayDiscount == 0 && weekendDiscount == 0 && specialDiscount == 0){
            OutputView.print(DomainMessage.OUTPUT_NOTHING);
        }

        return totalDiscount;
    }

    public void discountPayment(Payment payment, int totalDiscount) {
        int totalPayment = payment.payment() + totalDiscount;
        OutputView.print(DomainMessage.AFTER_DISCOUNT_EXPECTATION_AMOUNT);
        OutputView.printf(DomainMessage.OUTPUT_WON,totalPayment);
    }

    public void badge(Payment payment) {
        Badge badge = Badge.create(payment);
        OutputView.print(DomainMessage.DECEMBER_EVENT_BADGE);
        OutputView.printf(DomainMessage.OUTPUT_FORMAT,badge.badge());
    }
}
