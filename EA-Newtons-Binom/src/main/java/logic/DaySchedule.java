package logic;

import java.util.ArrayList;
import java.util.List;

public class DaySchedule
{
    private Days day;
    private List<RangeTime> listStartEnd;
    public DaySchedule() {}

    public DaySchedule(Days day){
        listStartEnd=new ArrayList<RangeTime>();
        this.day=day;
    }

    public void addRangeToDay(RangeTime range){
        listStartEnd.add(range);
    }

    public boolean isAvailabile(RangeTime timeRange)
    {
        for(RangeTime curr : listStartEnd){
            if(!curr.overlaps(timeRange)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "LOGIC.DaySchedule{" +
                "day=" + day +
                ", listStartEnd=" + listStartEnd +
                '}';
    }
}
