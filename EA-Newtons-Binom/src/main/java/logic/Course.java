package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Course implements Cloneable, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "course_name", unique = true)
    private String courseName;
    
    @OneToMany(mappedBy = "course", orphanRemoval = true, targetEntity = Group.class, cascade = CascadeType.ALL)
    private List<Group> groups;
    
    @OneToMany(mappedBy = "course", orphanRemoval = true, targetEntity = Lesson.class, cascade = CascadeType.ALL)
    @JsonProperty("practices")
    private List<Lesson> practices;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date testA;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date testB;
    private double credits;
    private int difficulty;
    @JsonProperty("isMandatory")
    private Boolean isMandatory;


    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public List<Lesson> getPractices() {
		return practices;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setTestA(Date testA) {
		this.testA = testA;
	}

	public void setTestB(Date testB) {
		this.testB = testB;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void setPractices(List<Lesson> practices)
    {
        this.practices = practices;
    }

    public Course()
    {

        groups = new ArrayList<Group>();
        practices = new ArrayList<Lesson>();
    }

    public Course(String courseName, float credits, int difficulty, List groups, Date testA, Date testB, Boolean isMandatory, List<Lesson> practices) {
        this.courseName = courseName;
        this.credits = credits;
        this.difficulty = difficulty;
        this.groups = groups;
        this.testA = testA;
        this.testB = testB;
        this.isMandatory=isMandatory;
        this.practices=practices;
    }
    
    public Course(String courseName, float credits, int difficulty, List<Group> groups, Date testA, Date testB, Boolean isMandatory) {
        this.courseName = courseName;
        this.credits = credits;
        this.difficulty = difficulty;
        this.groups = groups;
        this.testA = testA;
        this.testB = testB;
        this.isMandatory=isMandatory;
    }

    public Course(String courseName, double credits, int difficulty, Date testA, Date testB, Boolean isMandatory) {
        this.courseName = courseName;
        this.credits = credits;
        this.difficulty = difficulty;
        this.testA = testA;
        this.testB = testB;
        this.isMandatory=isMandatory;
        groups = new ArrayList<Group>();
        practices = new ArrayList<Lesson>();
    }





    @Override
    public Object clone()throws CloneNotSupportedException{


        Course clonedCourse = new Course();
        clonedCourse = (Course)super.clone();
        List<Group> clonedGroupList = new ArrayList<Group>(this.groups.size());
        List<Lesson> clonedCoursePractices = new ArrayList<Lesson>(this.practices.size());

        for (Group group: groups) {

            clonedGroupList.add((Group) group.clone());

        }

        clonedCourse.setGroups(clonedGroupList);

        for (Lesson practice: practices)
        {

            clonedCoursePractices.add((Lesson) practice.clone());

        }

        clonedCourse.setPractices(clonedCoursePractices);

        return clonedCourse;

    }


	public Course(String courseName, List<Group> groups, List<Lesson> practices, Date testA, Date testB, double credits,
		int difficulty, Boolean isMandatory) {
	super();
	this.courseName = courseName;
	this.groups = groups;
	this.practices = practices;
	this.testA = testA;
	this.testB = testB;
	this.credits = credits;
	this.difficulty = difficulty;
	this.isMandatory = isMandatory;
}

//	private void setCoursePractice(List<Lesson> practice)
//    {
//
//        this.practices = practice;
//
//    }

    public void setGroups(List<Group> groupList) {

        this.groups = groupList;

    }





    public boolean compareLessonsInCourses(Course course)//if there have range time overLaps with two lessons from different courses
    {

        List<Lesson> lessons = getAllLessonsAndPractices(this);
        List<Lesson> otherLesson = getAllLessonsAndPractices(course);


        for(Lesson lesson1:lessons){
            for(Lesson lesson2:otherLesson){
                RangeTime timeRange1 = lesson1.getTimeRange();
                RangeTime timeRange2 = lesson2.getTimeRange();
                if(timeRange1.overlaps(timeRange2)){
                    return true;
                }
            }
        }

        return false;
    }

    private List<Lesson> getAllLessonsAndPractices(Course course)
    {
        List<Lesson> res=getAllLessonsInGroup(course);


        for(Lesson practice : practices){
            res.add(practice);
        }

        return res;
    }

    private List<Lesson> getAllLessonsInGroup(Course course)
    {
        List<Lesson> res= new ArrayList<Lesson>();
        for(Group group: course.getGroups())
        {
            for (Lesson lesson: group.getLessons())
            {
                res.add(lesson);
            }
        }
        return res;
    }


    public List<Group> getGroups(){
        return groups;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCredits() {
        return credits;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Date getTestA() {
        return testA;
    }

    public Date getTestB() {
        return testB;
    }

//    public Boolean getMandatory() {
//        return isMandatory;
//    }

    public void addGroup(Group newGroup){
        if(!groups.contains(newGroup)){
            groups.add(newGroup);
        }
    }

    @Override
    public String toString()
    {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", groups=" + groups +
                ", practices=" + practices +
                ", testA=" + testA +
                ", testB=" + testB +
                ", credits=" + credits +
                ", difficulty=" + difficulty +
                ", isMandatory=" + isMandatory +
                '}';
    }

    public Boolean isSameName(String courseName){
        return this.courseName.equals(courseName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Double.compare(course.credits, credits) == 0 && difficulty == course.difficulty && courseName.equals(course.courseName) && Objects.equals(testA, course.testA) && Objects.equals(testB, course.testB) && isMandatory.equals(course.isMandatory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, credits, difficulty, testA, testB, isMandatory);
    }

    public void addGroupsWithoutDup(List<Group> newGroups) {
        if(groups == null){
            groups=newGroups;
        }else {
            for (Group group : newGroups) {
                addGroup(group);
            }
        }
    }

//    public List<Lesson> getCoursePractices()
//    {
//
//        return practices;
//    }

    public void addCoursePractice(Lesson practice)
    {
        if(!practices.contains(practice)){
            practices.add(practice);
        }
    }

    public boolean checkIfGroupAndPracticeOverlapping()
    {
        List<Lesson> lessonsFromGroups = getAllLessonsInGroup(this);


        for(Lesson lessonFromSomeGroup : lessonsFromGroups){
            for(Lesson practice : practices){
                if(practice.getTimeRange().overlaps(lessonFromSomeGroup.getTimeRange())){
                    return true;
                }
            }
        }

        return false;
    }

    public void addPracticeWithoutDup(List<Lesson> practices) {
        if(practices == null){
            practices=practices;
        }else {
            for (Lesson practice : practices) {
                addCoursePractice(practice);
            }
        }
    }
}