package christmas.view.input;


import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.config.convert.ConvertToInt;
import christmas.domain.Payment;
import christmas.domain.ReservationDay;
import christmas.domain.order.OrderHistory;
import christmas.dto.ReservationDto;

public class InputView {
    private static ReservationDto reservationDto;
    public static int reserveDay(){
        ConvertToInt from = ConvertToInt.from(readLine());
        return from.get();
    }

    public static String receiveOrder() {
        return readLine();
    }

    public static void reservationInfo(ReservationDay reserveDay, OrderHistory orderHistory, Payment payment){
        reservationDto = new ReservationDto(reserveDay, orderHistory, payment);
    }

    public static ReservationDto previewBenefit(){
        return reservationDto;
    }

}
