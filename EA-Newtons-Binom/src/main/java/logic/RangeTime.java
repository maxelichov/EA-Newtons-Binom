package logic;

import java.time.LocalTime;
import java.util.Objects;

//todo: what if end time<start time
public class RangeTime {
    private LocalTime startTime;// = LocalTime.of(12, 20);
    private LocalTime endTime;// = LocalTime.of(12, 20);

    public RangeTime(LocalTime startTime, LocalTime endTime){
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean overlaps(RangeTime timeRange) {
        if(timeRange.endTime.isBefore(startTime) || timeRange.startTime.isAfter(endTime)){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "LOGIC.TimeRange{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RangeTime rangeTime = (RangeTime) o;
        return startTime.equals(rangeTime.startTime) && endTime.equals(rangeTime.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }
}
