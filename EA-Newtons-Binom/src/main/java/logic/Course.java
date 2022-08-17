package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Course implements Cloneable{



    private String courseName;
    private List<Group> groups;
    private List<Lesson> practices;
    private Date testA;
    private Date testB;
    private double credits;
    private int difficulty;
    private Boolean isMandatory;


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

        clonedCourse.setCoursePractice(clonedCoursePractices);

        return clonedCourse;

    }

    private void setCoursePractice(List<Lesson> practice)
    {

        this.practices = practice;

    }

    public void setGroups(List<Group> groupList) {

        this.groups = groupList;

    }





    public boolean compareLessonsInCourses(Course course)//if there have range time overLaps with two lessons from different courses
    {

        List<Lesson> lessons = getAllLessonsAndPractices(this);
        List<Lesson> otherLesson = getAllLessonsAndPractices(course);


        for(Lesson lesson1:lessons){
            for(Lesson lesson2:otherLesson){
                TimeRange timeRange1 = lesson1.getRangeTime();
                TimeRange timeRange2 = lesson2.getRangeTime();
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

    public Boolean getMandatory() {
        return isMandatory;
    }

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

    public List<Lesson> getCoursePractices()
    {

        return practices;
    }

    public void addCoursePractice(Lesson practice)
    {

        practices.add(practice);

    }

    public boolean checkIfGroupAndPracticeOverlapping()
    {
        List<Lesson> lessonsFromGroups = getAllLessonsInGroup(this);


        for(Lesson lessonFromSomeGroup : lessonsFromGroups){
            for(Lesson practice : practices){
                if(practice.getRangeTime().overlaps(lessonFromSomeGroup.getRangeTime())){
                    return true;
                }
            }
        }

        return false;
    }
}