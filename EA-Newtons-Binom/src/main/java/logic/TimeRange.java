package logic;

import java.time.LocalTime;
import java.util.Objects;

//todo: what if end time<start time
public class TimeRange {
    private LocalTime startTime;// = LocalTime.of(12, 20);
    private LocalTime endTime;// = LocalTime.of(12, 20);

    public TimeRange(LocalTime startTime, LocalTime endTime){
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean overlaps(TimeRange timeRange) {
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
        TimeRange timeRange = (TimeRange) o;
        return startTime.equals(timeRange.startTime) && endTime.equals(timeRange.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }
}
