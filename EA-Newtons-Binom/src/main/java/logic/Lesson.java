package logic;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Lesson implements Cloneable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private Days day;
    
    @JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "timeRangeId")
    @JsonProperty("timeRange")
    private RangeTime timeRange;
    
    @ManyToOne(cascade = CascadeType.ALL)
   	@JoinColumn(name="group_id")
    @JsonIgnore
   	private Group group;
    
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	@JsonIgnore
	private Course course;


    public Lesson(Days day, RangeTime timeRange){
        this.day=day;
        this.timeRange = timeRange;
    }
    
    public long getId() {
		return id;
	}


	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setId(long id) {
		this.id = id;
	}




	public RangeTime getTimeRange() {
		return timeRange;
	}




	public void setTimeRange(RangeTime timeRange) {
		this.timeRange = timeRange;
	}




	public Group getGroup() {
		return group;
	}




	public void setGroup(Group group) {
		this.group = group;
	}




	public void setDay(Days day) {
		this.day = day;
	}




	public Lesson() {}


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

//    public RangeTime getRangeTime() {
//        return timeRange;
//    }

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
