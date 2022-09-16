package logic;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Schedule implements Cloneable{


	@JsonProperty("courses")
    private List<Course> courses = new ArrayList<Course>();
    private double examsfitnessScore = 0;
    private double intensityFitnessScore = 0;
    @JsonProperty("finalFitnessScore")
    private double finalFitnessScore = 0;
    private double finalFitnessCreditPoints = 0;
    private double finalLessonsOverlappingFitnessPoints = 0;
    private double finalRepeatingCoursesFitnessScore = 0;
    private double mustHaveCoursesFitnessScore=0;
    private double overlapLessonsAndPracticesFitnessScore=0;


    public Schedule(List<Course> courses){
        this.courses=courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Object clone()throws CloneNotSupportedException{


        Schedule clonedSchedule  = (Schedule)super.clone();

        List<Course> clonedCoursesList = new ArrayList<Course>(courses.size());

        for (Course course: courses){

            clonedCoursesList.add((Course) course.clone());

        }

        clonedSchedule.setCourses(clonedCoursesList);

        return clonedSchedule;




    }


    public void setExamsFitnessScore(double fitnessScore)
    {
        this.examsfitnessScore = fitnessScore;
    }


    @Override
    public String toString() {
        return "LOGIC.Schedule{" +
                "finalFitnessScore=" + finalFitnessScore +
                ", courses=" + courses +
                '}';
    }
    
    

    public Course getCourseByName(String courseName) {


        for (Course curr: courses) {

            if(curr.getCourseName().equals(courseName)){
                return curr;
            }


        }

        return null;
    }


//    @Override
//	public String toString() {
//		return "LOGIC.Schedule [courses=" + courses + ", examsfitnessScore=" + examsfitnessScore + ", intensityFitnessScore="
//				+ intensityFitnessScore + ", finalFitnessScore=" + finalFitnessScore + ", finalFitnessCreditPoints="
//				+ finalFitnessCreditPoints + ", finalLessonsOverlappingFitnessPoints="
//				+ finalLessonsOverlappingFitnessPoints + ", finalRepeatingCoursesFitnessScore="
//				+ finalRepeatingCoursesFitnessScore + ", mustHaveCoursesFitnessScore=" + mustHaveCoursesFitnessScore
//				+ ", overlapLessonsAndPracticesFitnessScore=" + overlapLessonsAndPracticesFitnessScore + "]";
//	}

	public void printSchedule() {
        System.out.println(this.toString());
    }

    public void removeCourse(String courseName) {
        removeCourse(getCourseByName(courseName));

    }
    public void removeCourse(Course course) {
        courses.remove(course);

    }


    public void addCourseToSchedule(Course courseToAdd)
    {

        courses.add(courseToAdd);


    }


    public void setIntensityFitnessScore(double intestinyFitnessScore)
    {

        this.intensityFitnessScore = intestinyFitnessScore;
    }

    public void setFinalFitnessScore(double finaFitness)
    {

        this.finalFitnessScore = finaFitness;
    }

    public void setPointFitnessScore(double creditPointFitnessScore)
    {
        this.finalFitnessCreditPoints = creditPointFitnessScore;

    }

    public void setLessonsOverlappingFitnessScore(double finalLessonsOverlappingFitnessPoints)
    {
        this.finalLessonsOverlappingFitnessPoints = finalLessonsOverlappingFitnessPoints;
    }

    public void setRepeatingCoursesFitnessScore(double finalRepeatingCoursesFitnessScore)
    {
        this.finalRepeatingCoursesFitnessScore = finalRepeatingCoursesFitnessScore;

    }

    public List<Course> removeCourses(List<Course> mustHaveCourses) {
        List<Course> res = new ArrayList<Course>();
        for(Course mustHaveCourse : mustHaveCourses){
            for(Course course : courses){
                if(course.isSameName(mustHaveCourse.getCourseName())){
                    res.add(course);
                }
            }
        }

        for(Course course : res){
            removeCourse(course);
        }
        return res;
    }

    public void addCoursess(List<Course> courses) {
        for(Course curr : courses){
            addCourseToSchedule(curr);
        }
    }

    public void setMustHaveCourseCoursesFitnessScore(double mustHaveCoursesFitnessScore) {
        this.mustHaveCoursesFitnessScore=mustHaveCoursesFitnessScore;
    }

    public void setLessonsAndPracticeOverlappingFitnessScore(double overlapLessonsAndPracticesFitnessScore)
    {
        this.overlapLessonsAndPracticesFitnessScore=overlapLessonsAndPracticesFitnessScore;
    }
}
