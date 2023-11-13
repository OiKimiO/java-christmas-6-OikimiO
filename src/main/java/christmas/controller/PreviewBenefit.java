package christmas.controller;

import christmas.domain.Payment;
import christmas.domain.ReservationDay;
import christmas.domain.order.OrderHistory;
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
        OrderHistory orderHistory = reservationDto.orderHistory();

        int presentationDiscount = presentation(payment);
        int totalDiscount = totalBenefit(orderHistory, reservationDay);
        OutputView.print(DomainMessage.TOTAL_BENEFIT_AMOUNT);
        OutputView.printf(DomainMessage.OUTPUT_FORMAT,(totalDiscount + presentationDiscount)+"원");

        discountPayment(payment, totalDiscount);
        badge();
    }

    public int presentation(Payment payment) {
        PresentationPolicy presentationPolicy = PresentationPolicy.create(payment);

        OutputView.print(DomainMessage.PRESENTATION_MENU);
        OutputView.printf(DomainMessage.OUTPUT_FORMAT, presentationPolicy.presentation());

        return presentationPolicy.presentationDiscount();
    }

    public int totalBenefit(OrderHistory orderHistory, ReservationDay reservationDay) {
        DDayPolicy dDayPolicy = DDayPolicy.create(reservationDay.reserveDay());
        SpecialPolicy specialPolicy = SpecialPolicy.create(reservationDay.reserveDay());
        WeekDayPolicy weekDayPolicy = WeekDayPolicy.create(orderHistory, reservationDay.reserveDay());
        WeekendPolicy weekendPolicy = WeekendPolicy.create(orderHistory, reservationDay.reserveDay());

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

        return totalDiscount;
    }

    public void discountPayment(Payment payment, int totalDiscount) {
        int totalPayment = payment.payment() + totalDiscount;
        OutputView.print(DomainMessage.AFTER_DISCOUNT_EXPECTATION_AMOUNT);
        OutputView.printf(DomainMessage.OUTPUT_FORMAT,totalPayment + "원");
    }

    public void badge() {
    }
}
