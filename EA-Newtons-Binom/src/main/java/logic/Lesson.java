package logic;

import java.util.Objects;

public class Lesson implements Cloneable{
    private Days day;
    private TimeRange timeRange;


    public Lesson(Days day, TimeRange timeRange){
        this.day=day;
        this.timeRange = timeRange;
    }


    @Override
    public Object clone()throws CloneNotSupportedException{




        Lesson clonedLesson = (Lesson)super.clone();

        return clonedLesson;
        //  return super.clone();
    }


    @Override
    public String toString() {
        return "LOGIC.Lesson{" +
                "day=" + day +
                ", timeRange=" + timeRange +
                '}';
    }

    public Days getDay() {
        return day;
    }

    public TimeRange getRangeTime() {
        return timeRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return day == lesson.day && timeRange.equals(lesson.timeRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, timeRange);
    }
}
