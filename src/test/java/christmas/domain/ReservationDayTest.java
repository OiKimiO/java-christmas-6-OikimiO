package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReservationDayTest {

    @Test
    @DisplayName("정상적인 예약일을 입력한다.")
    void createReservationDay(){
        ReservationDay reservationDay = ReservationDay.create(3);

        int reserveDay = reservationDay.reserveDay();

        assertThat(reserveDay).isEqualTo(3);
    }

    @Test
    @DisplayName("요일을 확인한다.")
    void createReservationDayOfWeek(){
        ReservationDay reservationDay = ReservationDay.create(3);

        DayOfWeek dayOfWeek = reservationDay.dayOfWeekAfterDays();

        assertThat(dayOfWeek.name()).isEqualTo("SUNDAY");
    }
}
