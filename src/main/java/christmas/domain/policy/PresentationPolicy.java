package christmas.domain.policy;

import java.time.DayOfWeek;

public class PresentationPolicy  implements PeriodPolicy{

    @Override
    public DayOfWeek dayOfWeek() {
        return null;
    }
}
