package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "groupsc")
public class Group implements Cloneable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	@JsonIgnore
	private Course course;
	
	@OneToMany(mappedBy="group", orphanRemoval = true, targetEntity = Lesson.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	List<Lesson> lessons;
	
    public Group(List<Lesson> lessons){
        this.lessons=lessons;
    }

    public Group() {
        lessons=new ArrayList<Lesson>();
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
    public Object clone()throws CloneNotSupportedException{

        Group clonedGroup = new Group();

        clonedGroup =  (Group) super.clone();
        List<Lesson> clonedLessons = new ArrayList<Lesson>(lessons.size());

        for (Lesson lesson: lessons) {

            clonedLessons.add((Lesson) lesson.clone());


        }

        clonedGroup.setLessons(clonedLessons);

        return clonedGroup;
        //return super.clone();
    }

    public void setLessons(List<Lesson> clonedLessons) {

        this.lessons = clonedLessons;
    }


    @Override
    public String toString() {
        return "LOGIC.Group{" +
                "lessons=" + lessons +
                '}';
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void addLesson(Lesson currLesson) {
        lessons.add(currLesson);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return lessons.equals(group.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessons);
    }
}
