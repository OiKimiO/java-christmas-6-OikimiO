package christmas.domain.policy;

import java.time.DayOfWeek;

public class SpecialPolicy extends DayPolicy{
    @Override
    public DayOfWeek dayOfWeek() {
        return null;
    }
}
