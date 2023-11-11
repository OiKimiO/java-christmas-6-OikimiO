package christmas.controller;

import static christmas.utils.RepeatReader.read;

import christmas.domain.ReservationDay;
import christmas.view.InputView;

public class Reservation {
    public Reservation(){
        ReservationDay reserveDay = read(this::reserveDay);
        inputOrderMenu();
        previewBenefit();
    }

    public ReservationDay reserveDay() {
        return new ReservationDay(InputView.reserveDay());
    }

    public void inputOrderMenu() {
    }

    public void previewBenefit(){
        order();
        benefit();
        discountPayment();
        badge();
    }

    public void order() {
        menu();
        payment();
    }

    public void menu() {

    }

    public void payment() {
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
